package Main;

public class Process {
    private int arrivalTime;
    private int priority;
    private int processTime;
    private int memory;
    private int printers;
    private int scanners;
    private int modems;
    private int cds;

    public Process(int arrivalTime, int priority, int processTime, int memory,
                   int printers, int scanners, int modems, int cds) {
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.processTime = processTime;
        this.memory = memory;
        this.printers = printers;
        this.scanners = scanners;
        this.modems = modems;
        this.cds = cds;
    }

    // Getters
    public int getArrivalTime() { return arrivalTime; }
    public int getPriority() { return priority; }
    public int getProcessTime() { return processTime; }
    public int getMemory() { return memory; }
    public int getPrinters() { return printers; }
    public int getScanners() { return scanners; }
    public int getModems() { return modems; }
    public int getCDs() { return cds; }

    // Setters
    public void setArrivalTime(int arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setPriority(int priority) { this.priority = priority; }
    public void setProcessTime(int processTime) { this.processTime = processTime; }
    public void setMemory(int memory) { this.memory = memory; }
    public void setPrinters(int printers) { this.printers = printers; }
    public void setScanners(int scanners) { this.scanners = scanners; }
    public void setModems(int modems) { this.modems = modems; }
    public void setCDs(int cds) { this.cds = cds; }
}
