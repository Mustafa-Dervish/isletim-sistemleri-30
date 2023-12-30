// Bir dosyadan okunan verileri işleyerek bir işlem listesi oluşturur. Her bir süreç için bir 'Process' nesnesi oluşturan bir 'ProcessParser' sınıfını tanımlar. Bu sınıf, süreçlerin yönetimini ve işletilmesini kolaylaştırmak için kullanılır.

package Main;

// package import ederken * işareti kullanılması paketteki tüm sınıfların eklenmesini sağlar
import java.io.*;       // giriş ve çıkış işlemleri (I/O) gerçekleştirmek için gerekli araçları ekler.
import java.util.*;     // Koleksiyonlar, tarih ve saat işlemleri, uluslararasılaştırma ve çeşitli yardımcı sınıfları içerir

public class ProcessParser {        // Input dosyasından süreç bilgilerini okuyup işleyen class(sınıf).
    public static List<Process> parseInputFile(String filename) throws IOException 
    // Dosyadan süreç bilgilerini okuyup, her süreç için bir Process nesnesi oluşturan ve bu nesneleri bir liste halinde döndüren metot.
    {
        List<Process> processes = new ArrayList<>();    // Süreçleri depolamak için bir ArrayList nesnesi oluşturulur.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))     // BufferedReader sınıfı kullanılarak dosya okumaya hazırlanır.
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");        // Her satır ' , ' ayrılmış parçalara bölünür.
                int arrivalTime = Integer.parseInt(parts[0].trim());
                int priority = Integer.parseInt(parts[1].trim());
                int processTime = Integer.parseInt(parts[2].trim());
                int memory = Integer.parseInt(parts[3].trim());
                int printers = Integer.parseInt(parts[4].trim());
                int scanners = Integer.parseInt(parts[5].trim());
                int modems = Integer.parseInt(parts[6].trim());
                int cds = Integer.parseInt(parts[7].trim());

                Process process = new Process(arrivalTime, priority, processTime, memory, printers, scanners, modems, cds);
                /*
                Her parçadan Varış zamanı (arrivalTime), Öncelik (priority), İşlem süresi (processTime), Bellek kullanımı (memory)
                Yazıcı sayısı (printers), Tarayıcı sayısı (scanners), Modem sayısı (modems), CD sayısı (cds) bilgilerini ayrıştırır.
                */
                
                processes.add(process);    // Oluşturulan Process nesnesi, süreçler listesine eklenir.
            }
        }
        return processes;    // Tüm süreçleri içeren liste, metot tarafından döndürülür.
    }
}
