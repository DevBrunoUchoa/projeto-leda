package comparandoFifoLru;

public class Main {
	public static void main(String args[]) {
		//Inicializar os dados
		DataGenerator grRandom = new DataGenerator( 2147, 483, 214798);
		int[] accesses = grRandom.gerar();
		
		//Inicializando LRU e FIFO
		FIFOCache fifoCache = new FIFOCache(10);
		LRUCache lruCache = new LRUCache(10);
		
		//Inicializando o Simulador
		CacheSimulator cs = new CacheSimulator(accesses, fifoCache, lruCache,  "C:/Users/MateusH/Desktop/novo_priojeto_sem_erros/Projeto_EDA_LRU_FIFO/src/comparandoFifoLru/cache_metrics.csv");
		
	}
}
