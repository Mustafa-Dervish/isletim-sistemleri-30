package Main;

import java.util.*;

public class Dispatcher {
    private Queue<Process> realTimeQueue = new LinkedList<>();
    private List<Queue<Process>> userQueues = new ArrayList<>(3); // 3-level feedback scheduler
    private int[] timeQuanta = {4, 2, 1}; // Time quanta for different user process levels
    private ResourceManager resourceManager;

    public Dispatcher(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
        for (int i = 0; i < 3; i++) {
            userQueues.add(new LinkedList<>());
        }
    }

    public void addProcess(Process process) {
        if (process.getPriority() == 0) {
            realTimeQueue.add(process);
        } else {
            userQueues.get(Math.min(process.getPriority() - 1, 2)).add(process);
        }
    }

    private void executeProcess(Process process, int timeQuantum) {
        System.out.println("Executing process with priority " + process.getPriority() + " for " + timeQuantum + " seconds");
        int remainingTime = Math.max(process.getProcessTime() - timeQuantum, 0);
        process.setProcessTime(remainingTime);

        if (remainingTime > 0) {
            int newPriority = Math.min(process.getPriority() + 1, 3);
            userQueues.get(newPriority - 1).add(process);
        } else {
            System.out.println("Process completed");
            resourceManager.releaseResources(process);
        }
    }

    public void dispatch() {
        while (!realTimeQueue.isEmpty()) {
            Process process = realTimeQueue.poll();
            executeProcess(process, 1); // Real-time processes get 1 second of execution time
        }

        for (int i = 0; i < userQueues.size(); i++) {
            while (!userQueues.get(i).isEmpty()) {
                Process process = userQueues.get(i).poll();
                executeProcess(process, timeQuanta[i]);
            }
        }
    }

    public boolean isEmpty() {
        if (!realTimeQueue.isEmpty()) return false;
        for (Queue<Process> queue : userQueues) {
            if (!queue.isEmpty()) return false;
        }
        return true;
    }
}
