package Main;

public class ResourceManager {
    private int availablePrinters = 2;     // Kullanılabilir yazıcı sayısı
    private int availableScanners = 1;       // Kullanılabilir tarayıcı sayısı
    private int availableModems = 1;        // Kullanılabilir modem sayısı
    private int availableCDs = 2;           // Kullanılabilir CD sayısı

    public boolean allocateResources(Process process) {        // Sürece kaynak tahsis etmek için kullanılan metot.
        if (process.getPrinters() <= availablePrinters && process.getScanners() <= availableScanners &&
            process.getModems() <= availableModems && process.getCDs() <= availableCDs)     // Sürecin ihtiyaç duyduğu kaynak sayısının kullanılabilir kaynak sayısından fazla olup olmadığını kontrol eden if döngüsü.
        {
            availablePrinters -= process.getPrinters();
            availableScanners -= process.getScanners();
            availableModems -= process.getModems();
            availableCDs -= process.getCDs();
            return true;        // Eğer yeterli kaynak varsa, kullanılabilir kaynak sayısını azaltır ve 'true' döndürür.
        }
        return false;        // Eğer yeterli kaynak yoksa, 'false' döndürür.
    }

    public void releaseResources(Process process) {        // Ssüreç tarafından tahsis edilmiş kaynakları serbest bırakmak için kullanılan metot.
        availablePrinters += process.getPrinters();
        availableScanners += process.getScanners();
        availableModems += process.getModems();
        availableCDs += process.getCDs();
        // Kullanılabilir kaynak sayısını, tahsis edilmiş kaynak sayısı kadar artırır. Her kaynak için işlemi ayrı ayrı gerçekleştirir.
    }
}
