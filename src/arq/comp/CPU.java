package arq.comp;

class CPU
{
    private Core[] cores;
    private int[] CacheL1;
    private int[] CacheL2;

    CPU(int coreNum, int l1Size, int l2Size)
    {
        cores = new Core[coreNum];
        CacheL1 = new int[l1Size];
        CacheL2 = new int[l2Size];
    }
}
