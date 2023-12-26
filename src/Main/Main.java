package Main;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Process> processes = ProcessParser.parseInputFile("giris.txt");
            ResourceManager resourceManager = new ResourceManager();
            Dispatcher dispatcher = new Dispatcher(resourceManager);

            int currentTime = 0;
            while (!processes.isEmpty() || !dispatcher.isEmpty()) {
                System.out.println("Current time: " + currentTime);

                Iterator<Process> iterator = processes.iterator();
                while (iterator.hasNext()) {
                    Process process = iterator.next();
                    if (process.getArrivalTime() <= currentTime && resourceManager.allocateResources(process)) {
                        dispatcher.addProcess(process);
                        iterator.remove();
                    }
                }

                dispatcher.dispatch();
                currentTime++;
                // Optional: simulate time passing
                System.out.print("ddd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
