package comparandoFifoLru;
import java.util.Random;

public class DataGenerator  {
		private int length;
		private int rangeStart;
		private int rangeEnd;
		
		public DataGenerator(int length, int rangeStart, int rangeEnd) {
			this.length = length;
			this.rangeStart = rangeStart;
			this.rangeEnd = rangeEnd;
		}
        public int[] gerar() {
            Random random = new Random();
            int[] accesses = new int[this.length];
            for (int i = 0; i < length; i++) {
                accesses[i] = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            }
            return accesses;
        }
}