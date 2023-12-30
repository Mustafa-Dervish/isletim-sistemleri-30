// Bir dosyadan okunan verileri işleyerek bir işlem listesi oluşturur. Her bir süreç için bir 'Process' nesnesi oluşturan bir 'ProcessParser' sınıfını tanımlar. Bu sınıf, süreçlerin yönetimini ve işletilmesini kolaylaştırmak için kullanılır.

package Main;

// package import ederken * işareti kullanılması paketteki tüm sınıfların eklenmesini sağlar
import java.io.*;       // giriş ve çıkış işlemleri (I/O) gerçekleştirmek için gerekli araçları ekler.
import java.util.*;     // Koleksiyonlar, tarih ve saat işlemleri, uluslararasılaştırma ve çeşitli yardımcı sınıfları içerir

public class ProcessParser {
    public static List<Process> parseInputFile(String filename) throws IOException {
        List<Process> processes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int arrivalTime = Integer.parseInt(parts[0].trim());
                int priority = Integer.parseInt(parts[1].trim());
                int processTime = Integer.parseInt(parts[2].trim());
                int memory = Integer.parseInt(parts[3].trim());
                int printers = Integer.parseInt(parts[4].trim());
                int scanners = Integer.parseInt(parts[5].trim());
                int modems = Integer.parseInt(parts[6].trim());
                int cds = Integer.parseInt(parts[7].trim());

                Process process = new Process(arrivalTime, priority, processTime, memory,
                                              printers, scanners, modems, cds);
                processes.add(process);
            }
        }
        return processes;
    }
}
