package arq.comp;

class Core
{
    private Integer[] cacheL1;
    private Integer blkSize;

    void setCache(int l1Size)
    {
        cacheL1 = new Integer[l1Size];
    }

    Integer[] getCacheL1()
    {
        return cacheL1;
    }

    /**
     * Verifica se o dado está em l1
     *
     * @param memIndex dado a ser procurado em l1
     */
    boolean l1HasMem(int memIndex)
    {
        if(cacheL1[memIndex % cacheL1.length] == null)
        {
            return false;
        }
        else return cacheL1[memIndex % cacheL1.length] == memIndex;
    }

    void loadToCacheL1(int memIndex)
    {
        for(int i = memIndex; i < (memIndex + blkSize); i++)
            cacheL1[i % cacheL1.length] = i;
        System.out.println("Loaded Memory Address: " + memIndex);
    }

    void loadToCacheL1(int memIndex, int[] memory)
    {
        System.out.println("Data: " + memory[memIndex]);
    }

    void execute(int memIndex, int[] memory, int nValue)
    {
        System.out.print("Data: " + memory[memIndex] + " changed to ");
        memory[memIndex] = nValue;
        System.out.println(memory[memIndex]);
    }

    void setBlkSize(int blkSize)
    {
        this.blkSize = blkSize;
    }

    void printL1()
    {
        StringBuilder index = new StringBuilder();
        StringBuffer memData = new StringBuffer();
        int sz;

        for(int i = 0; i < cacheL1.length; i++)
        {
            sz = 6;

            index.append(" ".repeat(sz / 2));

            index.append(i);

            index.append(" ".repeat(sz / 2));

            index.append("|");

            memData.append(" ".repeat(sz / 2));

            memData.append(cacheL1[i]);

            memData.append(" ".repeat(sz / 2));

            memData.append("|");
        }


        System.out.println(index);
        System.out.println(memData);

        System.out.println();
    }
}
