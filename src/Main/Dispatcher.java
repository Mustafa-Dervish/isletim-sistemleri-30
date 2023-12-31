package Main;	// // Programı başlatacak fonksiyon

import java.util.*;		// Giriş ve çıkış işlemleri (I/O) gerçekleştirmek için gerekli araçları ekler.

public class Dispatcher		// 'Dispatcher' sınıfı tanımlanır. Süreçleri zamanlamak ve yürütmek için kullanılacak.  
	{
    private Queue<Process> realTimeQueue = new LinkedList<>();		//  Gerçek zamanlı süreçleri depolamak için oluşturulan kuyruk(Queue).
    private List<Queue<Process>> userQueues = new ArrayList<>(3);   // Kullanıcı süreçlerini öncelik seviyelerine göre depolamak için 3 kuyruktan(queue) oluşan liste(list) oluşturur.
    private int[] timeQuanta = {4, 2, 1}; 	    // Farklı kullanıcı süreci seviyeleri için zaman dilimleri dizisi tanımlanır. Tam sayı (int) tipinde
    private ResourceManager resourceManager;		// Kaynakları yönetmek için bir 'ResourceManager' nesnesi.

    public Dispatcher(ResourceManager resourceManager) 	// Kaynak yöneticisi ile başlatıcı metot.
	{
        this.resourceManager = resourceManager;     // Parametre olarak alınan 'resourceManager' nesnesini 'resourceManager' adında bir değişkene atar.

        for (int i = 0; i < 3; i++)         // Tam sayı(int) olan 'i' değişkeni ile oluşturulan 'for' döngüsü, 0'dan 2'ye kadar 3 kez çalışır.
        {
            userQueues.add(new LinkedList<>());     // 'userQueues' adında bir listeye yeni bir 'LinkedList' nesnesi ekler.
        }
    }   // 'resourceManager' nesnesini alır ve kullanıcı süreçleri için 3 boş kuyruk oluşturur.

    public void addProcess(Process process) 
    // 'addProcess' yöntemini tanımlayan yöntem. 'Process' nesnesi parametresi alır ve bu nesneyi önceliğine göre uygun kuyruğa(queue) ekleyerek sıraya koyar.
    {
        if (process.getPriority() == 0)     // Gelen 'process' nesnesinin önceliğini kontrol eder. Eğer öncelik '0' ise, gerçek zamanlı işlem kuyruğuna eklenmesi gerektiğini belirten if bloğu
        {
            realTimeQueue.add(process);     // Öncelik  değeri(getPriority) '0' ise 'process' nesnesini 'realTimeQueue' adlı bir listeye ekler.
        } 

        else        // Öncelik değeri(getPriority) '0' değil ise döndürülecek sonuçlar için 'else' bloğu
        {
            userQueues.get(Math.min(process.getPriority() - 1, 2)).add(process);
             /* 'process' nesnesini uygun kullanıcı işlem kuyruğuna ekleyen süreç.
            'process' nesnesinin önceliğini 1 azaltır. Çünkü öncelik değeri(getPriority) değeri '0' için gerçek zamanlı işlemler için ayrılmıştır */
        }
    }

    private void executeProcess(Process process, int timeQuantum)   // 'timeQuantum' adında tam sayı (işlemin çalıştırılacağı zaman dilimini belirtir) değer parametresini alan yöntem tanımlanır.
    {
        System.out.println("Executing process with priority " + process.getPriority() + " for " + timeQuantum + " seconds");        // Yürütülecek işlemin önceliğini ve zaman dilimini konsola yazdırır.
        
        int remainingTime = Math.max(process.getProcessTime() - timeQuantum, 0);        // İşlemin kalan çalışma süresini hesaplar ve 'remainingTime' değişkenine atar.
                            // 'Math.max()' fonksiyonu ile iki değerden büyük olanı döndürür. Bu sayede kalan sürenin negatif olmadığından emin olunur.
        process.setProcessTime(remainingTime);      // İşlemin kalan çalışma süresini 'remainingTime' değişkeninde değerini günceller.

        if (remainingTime > 0) {       // İşlem tamamlanmadıysa(kalan süre '0'dan büyükse) çalışacak sorgu bloğu.
            int newPriority = Math.min(process.getPriority() + 1, 3);       // İşlemin yeni önceliğini hesaplar. 'Math.min()' fonksiyonu, iki değerden küçük olanı döndürür(yeni önceliğin maksimum 3 olmasını sağlar).
            userQueues.get(newPriority - 1).add(process);       // İşlemi yeni önceliğine göre uygun kuyruğa(queue) ekler.
        } 
        else        // İşlem tamamlandıysa çalışacak olan kod bloğu.(if döngüsü 'remainingTime > 0'koşulunda çalışıyor, harici durumlar else bloğuna gönderilir. 'remainingTime' değerini işlem sonunda pozitif olacak şekilde çevirdiğimiz için else bloğu işlem tamamlandığında çalışacaktır.)
        {
            System.out.println("Process completed");        // İşlem tamamlandığında yazdırılacak çıktı.
            resourceManager.releaseResources(process);      // işlem tarafından kullanılan kaynakları serbest bırakır.
        }
    }

    public void dispatch() {
        while (!realTimeQueue.isEmpty())    // 'realTimeQueue' boş olmadığı sürece yürütülecek 'while' döngüsü. 
        {
            Process process = realTimeQueue.poll();     // gerçek zamanlı işlem kuyruğundan(realTimeQueue) bir işlemi alır ve 'process' değişkenine atar.
            executeProcess(process, 1);     // 'process' değişkeninde tutulan işlemi 1 saniyelik zaman dilimi için çalıştırır.
        }

        for (int i = 0; i < userQueues.size(); i++)     // İşlem kuyruklarının sayısı kadar yinelenen bir döngü başlatır.
        {
            while (!userQueues.get(i).isEmpty())  // i. sıradaki kullanıcı işlem kuyruğu boş olmadığı sürece yürütülecek bir 'while' döngüsü başlatır.
            {
                Process process = userQueues.get(i).poll();     // i. sıradaki kullanıcı işlem kuyruğundan(userQueues) bir işlemi alır ve 'process' değişkenine atar.
                executeProcess(process, timeQuanta[i]);     // 'process' değişkeninde tutulan işlemi timeQuanta[i] değerinde belirtilen zaman dilimi için çalıştırır.
            }
        }
    }

    public boolean isEmpty()    // boolean tipinde 'isEmpty' yöntemini tanımlar. 
    {
        if (!realTimeQueue.isEmpty()) return false;     // Gerçek zamanlı işlem kuyruğu(realTimeQueue) boş değilse false döndürür.
        for (Queue<Process> queue : userQueues)     // Kullanıcı işlem kuyruklarının her biri için bir 'for' döngüsü başlatır.'userQueues' listesinde bulunan her kuyruk, queue değişkenine atanır.
        {
            if (!queue.isEmpty()) return false;     // Döngüdeki herhangi bir kullanıcı işlem kuyruğu boş değilse 'false' döndürür.
        }
        return true;        // Gerçek zamanlı kuyruk ve tüm kullanıcı kuyrukları boş ise 'true' döndürür.
    }
}
