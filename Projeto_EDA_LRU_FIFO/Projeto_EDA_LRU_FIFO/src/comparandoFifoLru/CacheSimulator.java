package comparandoFifoLru;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CacheSimulator {
    public CacheSimulator(int[] accesses, FIFOCache fifoCache, LRUCache lruCache, String outputFile) {
        int fifoHits = 0, fifoMisses = 0;
        int lruHits = 0, lruMisses = 0;

        // Simula os acessos
        for (int item : accesses) {
            if (fifoCache.access(item)) fifoHits++;
            else fifoMisses++;

            if (lruCache.access(item)) lruHits++;
            else lruMisses++;
        }

        // Calcula as métricas
        double fifoHitRate = (double) fifoHits / accesses.length;
        double fifoMissRate = (double) fifoMisses / accesses.length;
        double lruHitRate = (double) lruHits / accesses.length;
        double lruMissRate = (double) lruMisses / accesses.length;

        int fifoReplacements = fifoCache.getReplacements();
        int lruReplacements = lruCache.getReplacements();

        double fifoAvgAccessTime = calculateAverageAccessTime(fifoHits, fifoMisses, 1, 10);
        double lruAvgAccessTime = calculateAverageAccessTime(lruHits, lruMisses, 1, 10);

        // Salva as métricas em um arquivo CSV (acumulativo)
        saveMetricsToFile(outputFile, fifoHits, fifoMisses, fifoHitRate, fifoMissRate, fifoReplacements, fifoAvgAccessTime,
                lruHits, lruMisses, lruHitRate, lruMissRate, lruReplacements, lruAvgAccessTime);
    }

    // Método para calcular o tempo médio de acesso
    public static double calculateAverageAccessTime(int hits, int misses, int hitTime, int missPenalty) {
        return (hits * hitTime + misses * missPenalty) / (double) (hits + misses);
    }

    // Método para salvar as métricas em um arquivo CSV (acumulativo)
    public static void saveMetricsToFile(String filename, int fifoHits, int fifoMisses, double fifoHitRate, double fifoMissRate, int fifoReplacements, double fifoAvgAccessTime,
                                        int lruHits, int lruMisses, double lruHitRate, double lruMissRate, int lruReplacements, double lruAvgAccessTime) {
        try {
            File file = new File(filename);
            boolean fileExists = file.exists();

            FileWriter writer = new FileWriter(file, true); // Modo append (adiciona ao final do arquivo)

            // Se o arquivo não existir, escreve o cabeçalho
            if (!fileExists) {
                writer.write("FIFO Hits,FIFO Misses,FIFO Hit Rate,FIFO Miss Rate,FIFO Replacements,FIFO Avg Access Time," +
                        "LRU Hits,LRU Misses,LRU Hit Rate,LRU Miss Rate,LRU Replacements,LRU Avg Access Time\n");
            }

            // Escreve os dados da execução atual
            writer.write(fifoHits + "," + fifoMisses + "," + fifoHitRate + "," + fifoMissRate + "," + fifoReplacements + "," + fifoAvgAccessTime + "," +
                    lruHits + "," + lruMisses + "," + lruHitRate + "," + lruMissRate + "," + lruReplacements + "," + lruAvgAccessTime + "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}