package comparandoFifoLru;

public class FIFOCache {
	private int capacity;
    private int[] cache;
    private int[] queue;
    private int queueSize;
    private int replacements; // Contador de substituições

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.cache = new int[capacity];
        this.queue = new int[capacity];
        this.queueSize = 0;
        this.replacements = 0;
    }

    public boolean access(int item) {
        // Verifica se o item está no cache
        for (int i = 0; i < queueSize; i++) {
            if (cache[i] == item) {
                return true; // Hit
            }
        }

        // Se não estiver no cache, adiciona
        if (queueSize < capacity) {
            cache[queueSize] = item;
            queue[queueSize] = item;
            queueSize++;
        } else {
            // Remove o item mais antigo (FIFO)
            int oldest = queue[0];
            for (int i = 0; i < queueSize - 1; i++) {
                queue[i] = queue[i + 1];
            }
            queue[queueSize - 1] = item;

            // Substitui o item mais antigo no cache
            for (int i = 0; i < queueSize; i++) {
                if (cache[i] == oldest) {
                    cache[i] = item;
                    break;
                }
            }
            replacements++; // Incrementa o contador de substituições
        }
        return false; // Miss
    }

    public int getReplacements() {
        return replacements;
    }
}
