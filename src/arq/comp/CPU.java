package arq.comp;

class CPU {
	private Core[] cores;
	private int[] cacheL2;

	/**
	 * Utiliza mapeamento direto para inserir o dado na cache L2
	 * 
	 * @param coreIndex
	 * @param memoryData
	 */
	void input(int coreIndex, int memoryData) {
		cores[coreIndex].execute(cacheL2[memoryData % cacheL2.length] = memoryData);
	}

	void setCpu(int coreNum, int l1Size, int l2Size) {
		cores = new Core[coreNum];
		cacheL2 = new int[l2Size];

		// Setando a cache L1 para cada um dos cores do processador
		for (Core core : cores) {
			core.setCache(l1Size);
		}
	}

	Core[] getCores() {
		return cores;
	}
}