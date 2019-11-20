package arq.comp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PC
{
    private CPU[] cpus;
    private Memory memory;
    private int memoryIndex;
    private int cpuIndex;
    private int coreIndex;

    /**
     * Construtor parametrizado
     *
     * @param memSize  tamanho da memória do pc
     * @param cpuNum   número de cpus
     * @param coreNum  número de core por cpu
     * @param dataPath caminho para o arquivo contendo os dados que serão lidos na memória
     */
    PC(int memSize, int cpuNum, int coreNum, String dataPath)
    {
        int l2size = memSize / 10;
        int l1size = l2size / 2;

        memory = new Memory(memSize);

        cpus = new CPU[cpuNum];

        for(int i = 0; i < cpuNum; i++)
        {
            cpus[i] = new CPU();
            cpus[i].setCpu(coreNum, l1size, l2size);
        }

        toMem(dataPath);
    }

    /**
     * Le os dados do arquivo passado e adiciona na memoria
     *
     * @param dataPath caminho para o arquivo a ser lido
     */
    private void toMem(String dataPath)
    {
        File file = new File(dataPath);
        Scanner fileData;
        try
        {
            fileData = new Scanner(file);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Arquivo invalido!");
            return;
        }

        while(fileData.hasNextLine())
        {
            memory.add(fileData.nextLine());
        }
    }

    private void choose()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select memory to be read[0, " + (memory.getMemory().length - 1) + "]: ");

        memoryIndex = scanner.nextInt();

        System.out.println("Select a CPU[0, " + (cpus.length - 1) + "]: ");

        cpuIndex = scanner.nextInt();

        System.out.println("Select a core[0, " + (cpus[cpuIndex].getCores().length - 1) + "]: ");

        coreIndex = scanner.nextInt();

        printMemory(true);
    }

    /**
     * O usuário informa o endereço da memória principal para leitura e o core que
     * irá utilizar aquele dado
     */
    void read()
    {
        choose();
        // Check if Memory Address is loaded in l2 or l1, if not, load it
        if(cpus[cpuIndex].memIsLoaded(memoryIndex, coreIndex, true))
            cpus[cpuIndex].input(memoryIndex, coreIndex, memory.getMemory());
    }

    void write()
    {
        Scanner scanner = new Scanner(System.in);
        int nValue;
        choose();
        System.out.println("Enter new value: ");
        nValue = scanner.nextInt();

        // Check if Memory Address is loaded, if not, load and write
        if(cpus[cpuIndex].memIsLoaded(memoryIndex, coreIndex, true))
            cpus[cpuIndex].input(memoryIndex, coreIndex, memory.getMemory(), nValue);
    }

    void printMemory(Boolean printCaches)
    {
        System.out.println(">>> Memory state: ");

        memory.printMemory();

        if(printCaches)
        {

            System.out.println(">>> L2 state: ");

            cpus[cpuIndex].printL2();

            System.out.println(">>> L1 state: ");

            cpus[cpuIndex].getCores()[coreIndex].printL1();
        }
    }
}

