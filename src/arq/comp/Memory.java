package arq.comp;

class Memory {
	private int[] memory;
	private int index = 0;
	
	/**
	 * Construtor parametrizado
	 * @param size
	 */
	Memory(int size) {
		memory = new int[size];
	}
	
	/**
	 * Adiciona os dados que serao lidos do arquivo na memoria
	 * @param data
	 */
	void add(String data) {
		// Se o dado couber na memoria
		if (index + data.length() < memory.length) {
			// Adiciona cada dado em cada bloco da memoria
			for (int i = 0; i < data.length(); i++, index++) {
				memory[index] = data.charAt(i);
			}
		} else {
			System.out.println("Memory full!");
		}
	}

	int[] getMemory() {
		return memory;
	}
}
