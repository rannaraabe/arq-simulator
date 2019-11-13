package arq.comp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PC {
	private CPU[] cpus;
	private Memory memory;

	/**
	 * Construtor parametrizado
	 * 
	 * @param memSize
	 * @param cpuNum
	 * @param coreNum
	 * @param dataPath
	 */
	PC(int memSize, int cpuNum, int coreNum, String dataPath) {
		memory = new Memory(memSize);
		cpus = new CPU[cpuNum];

		for (CPU cpu : cpus) {
			cpu.setCpu(coreNum, memSize / 2, memSize / 10);
		}

		toMem(dataPath);
	}

	/**
	 * Le os dados do arquivo passado e adiciona na memoria
	 * 
	 * @param dataPath
	 */
	private void toMem(String dataPath) {
		File file = new File(dataPath);
		Scanner fileData;

		try {
			fileData = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		while (fileData.hasNextLine()) {
			memory.add(fileData.nextLine());
		}

		input();
		// TODO Select memory to be read and save data to memory, also, select core to
		// do the work
	}

	/**
	 * O usuário informa o endereço da memória principal para leitura e o core que
	 * irá utilizar aquele dado
	 */
	private void input() {
		Scanner scanner = new Scanner(System.in);
		int memoryIndex;
		int cpuIndex;
		int coreIndex;

		System.out.println("Select memory to be read[0, " + memory.getMemory().length + "]: ");
		memoryIndex = scanner.nextInt();

		System.out.println("Select a CPU[0, " + cpus.length);
		cpuIndex = scanner.nextInt();

		System.out.println("Select a core[0, " + cpus[cpuIndex].getCores().length);
		coreIndex = scanner.nextInt();

		cpus[cpuIndex].input(memory.getMemory()[memoryIndex], coreIndex);
	}
}
