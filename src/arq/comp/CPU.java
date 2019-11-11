package arq.comp;

class CPU
{
    private Core[] cores;
    private int[] cacheL2;

    void setCpu(int coreNum, int l1Size, int l2Size)
    {
        cores = new Core[coreNum];

        cacheL2 = new int[l2Size];

        for(Core core: cores)
        {
            core.setCache(l1Size);
        }
    }

    Core[] getCores()
    {
        return cores;
    }

    void input(int coreIndex, int memoryData)
    {
        cores[coreIndex].execute(cacheL2[memoryData % cacheL2.length] = memoryData);
    }
}