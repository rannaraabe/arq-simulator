package arq.comp;

class Core
{
    private Integer[] cacheL1;

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

    void execute(int memIndex)
    {
        cacheL1[memIndex % cacheL1.length] = memIndex;
        System.out.println("Memory Address: " + memIndex);
    }

    void execute(int memIndex, int[] memory)
    {
        System.out.println("Data: " + memory[memIndex]);
    }

    void execute(int memIndex, int[] memory, int nValue)
    {
        System.out.print("Data: " + memory[memIndex] + " changed to ");
        memory[memIndex] = nValue;
        System.out.println(memory[memIndex]);
    }
}
