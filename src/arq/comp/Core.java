package arq.comp;

class Core {
	int value;
	private int[] cacheL1;

	/**
	 * Utiliza mapeamento direto para inserir o dado na cache L1
	 * 
	 * @param data
	 */
	void execute(int data) {
		cacheL1[data % cacheL1.length] = data;
		System.out.println("Data: " + data);
	}

	void setCache(int l1Size) {
		cacheL1 = new int[l1Size];
	}
}
