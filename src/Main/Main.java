package Main;	// Programı başlatacak fonksiyon

import java.io.IOException;		// Dosya/dizin işlemlerinde okuma, yazma, arama işlemleri sırasında oluşan hata durumlarında özel durum fırlatır(throw).
import java.util.Iterator;		//Kkoleksiyon üzerinde nesneleri gezinmek için kullanılan bir arayüz olan Iterator'ı içe aktarır.
import java.util.List;		// 'java.util' paketinden 'List' arayüzünü içe aktarır. List : sıralı bir öğe koleksiyonunu temsil eder.

public class Main {		// Programın çalışmaya başladığı 'Main' sınıfını oluşturduk.
    public static void main(String[] args) {		// 'main' metodu tanımlanır.
        try {
            List<Process> processes = ProcessParser.parseInputFile("giris.txt");		// 'giris.txt' isimli dosyadan 'ProcessParser.parseInputFile()' metodu ile veri okur. Okunan veriyi 'List<Process>' liste olarak depolar.
            ResourceManager resourceManager = new ResourceManager();		// Kaynak yöneticisi oluştur.
            Dispatcher dispatcher = new Dispatcher(resourceManager);		// İşlemci oluştur.

            int currentTime = 0;		// 'currentTime' değişkeni tam sayı tipinde '0' olarak atanır.
            while (!processes.isEmpty() || !dispatcher.isEmpty()) 		// İşlenecek süreçler veya dağıtıcıda çalışan süreçler olduğu sürece devam eder.
			{
                System.out.println("Current time: " + currentTime);		// Simülasyonun o anki zamanını yazdırır.

                Iterator<Process> iterator = processes.iterator();	// 'processes' listesinde bulunan süreçleri dolaşmak için bir 'iterator' oluşturur.
                while (iterator.hasNext()) // Listedeki her süreci kontrol eder.
				{
                    Process process = iterator.next();
                    if (process.getArrivalTime() <= currentTime && resourceManager.allocateResources(process)) 
						// Sürecin varış zamanının mevcut zamana eşit veya daha erken olup olmadığını kontrol eder.(process.getArrivalTime() <= currentTime)
						// Süreç için gerekli kaynakların tahsis edilip edilemeyeceğini kontrol eder.(resourceManager.allocateResources(process))
						 
						// '&&' operatörü olduğu için her iki koşulun da gerçekleşmesi gerekir.
					{
                        dispatcher.addProcess(process);		// Süreci yürütme için dağıtıcıya ekler.
                        iterator.remove();		// Süreci processes listesinden kaldırır.
                    }
                }

                dispatcher.dispatch();		// işlemci sınıflarını kullanarak işlem planlaması ve kaynak yönetimini gerçekleştirmenize yardımcı olur. 
                currentTime++;		// 'currentTime' değişkeninin değeri 1 artırılır.
                System.out.print("ddd");		// İsteğe bağlı Zamanın geçtiğini 'ddd' yazarak simüle eder.
            }
        } catch (IOException e) // Okuma işlemi sırasında oluşabilecek istisnaları yönetir.
		{
            e.printStackTrace();		// 'Exception' nesnesinde hata durumunda hatanın ayrıntılarını yazdırmak için kullanılan bir metod.
        }
    }
}
