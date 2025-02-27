package comparandoFifoLru;

public class LRUCache {
	 private int capacity;
     private int[] cache;
     private int[] accessTime;
     private int time;
     private int replacements; // Contador de substituições

     public LRUCache(int capacity) {
         this.capacity = capacity;
         this.cache = new int[capacity];
         this.accessTime = new int[capacity];
         this.time = 0;
         this.replacements = 0;
     }

     public boolean access(int item) {
         time++; // Incrementa o tempo global

         // Verifica se o item está no cache
         for (int i = 0; i < capacity; i++) {
             if (cache[i] == item) {
                 accessTime[i] = time; // Atualiza o tempo de acesso
                 return true; // Hit
             }
         }

         // Se não estiver no cache, substitui o item menos recentemente usado
         int lruIndex = 0;
         for (int i = 1; i < capacity; i++) {
             if (accessTime[i] < accessTime[lruIndex]) {
                 lruIndex = i;
             }
         }

         cache[lruIndex] = item;
         accessTime[lruIndex] = time;
         replacements++; // Incrementa o contador de substituições
         return false; // Miss
     }

     public int getReplacements() {
         return replacements;
     }
}
