package Main;

public class ResourceManager {
    private int availablePrinters = 2; // As per your project specification
    private int availableScanners = 1;
    private int availableModems = 1;
    private int availableCDs = 2;

    public boolean allocateResources(Process process) {
        if (process.getPrinters() <= availablePrinters && process.getScanners() <= availableScanners &&
            process.getModems() <= availableModems && process.getCDs() <= availableCDs) {
            
            availablePrinters -= process.getPrinters();
            availableScanners -= process.getScanners();
            availableModems -= process.getModems();
            availableCDs -= process.getCDs();
            return true;
        }
        return false;
    }

    public void releaseResources(Process process) {
        availablePrinters += process.getPrinters();
        availableScanners += process.getScanners();
        availableModems += process.getModems();
        availableCDs += process.getCDs();
    }
}
