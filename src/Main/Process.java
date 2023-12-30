package Main;	// Programı başlatacak fonksiyon

public class Process 	// 'Proccess' isimli dışardan erişilebilen sınıf oluşturur.
	{ 
    private int arrivalTime;		// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'arrivalTime' değişkeni tanımlanır.
    private int priority;		// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'priority' değişkeni tanımlanır.
    private int processTime;	// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'processTime' değişkeni tanımlanır.
    private int memory;		// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'memory' değişkeni tanımlanır.
    private int printers;	// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'printers' değişkeni tanımlanır.
    private int scanners;	// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'scanners' değişkeni tanımlanır.
    private int modems;		// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'modems' değişkeni tanımlanır.
    private int cds;		// Sadece sınıf içinden erişilebilen tam sayı değer alabilen 'cds' değişkeni tanımlanır.

    public Process(int arrivalTime, int priority, int processTime, int memory,
                   int printers, int scanners, int modems, int cds) 	// 'Process' sınıfının yapıcı(constructor) metodudur. Bir 'Process' nesnesi oluşturulurken çağrılır. Değişkenler 
	{
        this.arrivalTime = arrivalTime;		// 'Process' nesnesinin 'arrivalTime' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
        this.priority = priority;		// 'Process' nesnesinin 'priority' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
        this.processTime = processTime;		// 'Process' nesnesinin 'processTime' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
        this.memory = memory;		// 'Process' nesnesinin 'memory' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
        this.printers = printers;		// 'Process' nesnesinin 'printers' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
        this.scanners = scanners;		// 'Process' nesnesinin 'scanners' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
        this.modems = modems;		// 'Process' nesnesinin 'modems' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
        this.cds = cds;		// 'Process' nesnesinin 'cds' değişkenine değer atamak için kullanılır. 'this' anahtar sözcüğü nesnenin kendisini temsil eder.
    }

    // Getters
    public int getArrivalTime() { return arrivalTime; }			// 'Process' nesnesinin 'arrivalTime' değişkeninin değerini int (tam sayı) tipinde döndürür.
    public int getPriority() { return priority; }		// 'Process' nesnesinin 'priority' değişkeninin değerini int (tam sayı) tipinde döndürür.
    public int getProcessTime() { return processTime; }		// 'Process' nesnesinin 'processTime' değişkeninin değerini int (tam sayı) tipinde döndürür.
    public int getMemory() { return memory; }		// 'Process' nesnesinin 'memory' değişkeninin değerini int (tam sayı) tipinde döndürür.
    public int getPrinters() { return printers; }		// 'Process' nesnesinin 'printers' değişkeninin değerini int (tam sayı) tipinde döndürür.
    public int getScanners() { return scanners; }		// 'Process' nesnesinin 'scanners' değişkeninin değerini int (tam sayı) tipinde döndürür.
    public int getModems() { return modems; }		// 'Process' nesnesinin 'modems' değişkeninin değerini int (tam sayı) tipinde döndürür.
    public int getCDs() { return cds; }		// 'Process' nesnesinin 'cds' değişkeninin değerini int (tam sayı) tipinde döndürür.
	
    // Setters, Sürecin varış zamanını ayarlamak için kullanılan metodlar.
    public void setArrivalTime(int arrivalTime) { this.arrivalTime = arrivalTime; }		// Nesnenin "arrivalTime" özelliğini ayarlamak için kullanılır. Metod, 'arrivalTime' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "arrivalTime" özelliğine atar.
    public void setPriority(int priority) { this.priority = priority; }		// Nesnenin "priority" özelliğini ayarlamak için kullanılır. Metod, 'priority' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "priority" özelliğine atar.
    public void setProcessTime(int processTime) { this.processTime = processTime; }		// Nesnenin "processTime" özelliğini ayarlamak için kullanılır. Metod, 'processTime' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "processTime" özelliğine atar.
    public void setMemory(int memory) { this.memory = memory; }		// Nesnenin "memory" özelliğini ayarlamak için kullanılır. Metod, 'memory' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "memory" özelliğine atar.
    public void setPrinters(int printers) { this.printers = printers; }		// Nesnenin "printers" özelliğini ayarlamak için kullanılır. Metod, 'printers' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "printers" özelliğine atar.
    public void setScanners(int scanners) { this.scanners = scanners; }		// Nesnenin "scanners" özelliğini ayarlamak için kullanılır. Metod, 'scanners' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "scanners" özelliğine atar.
    public void setModems(int modems) { this.modems = modems; }		// Nesnenin "modems" özelliğini ayarlamak için kullanılır. Metod, 'modems' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "modems" özelliğine atar.
    public void setCDs(int cds) { this.cds = cds; }		// Nesnenin "cds" özelliğini ayarlamak için kullanılır. Metod, 'cds' adında bir int parametresi alır ve bu parametredeki değeri nesnenin "cds" özelliğine atar.
}
