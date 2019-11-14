
package arq.comp;

class CPU
{
    private Core[] cores;
    private Integer[] cacheL2;

    void setCpu(int coreNum, int l1Size, int l2Size)
    {
        cores = new Core[coreNum];

        cacheL2 = new Integer[l2Size];

        for(int i = 0; i < coreNum; i++)
        {
            cores[i] = new Core();
            cores[i].setCache(l1Size);
        }
    }

    Core[] getCores()
    {
        return cores;
    }

    void input(int memoryIndex, int coreIndex, int[] memory)
    {
        cores[coreIndex].execute(memoryIndex, memory);
    }


    /**
     * Verifica se o dado está na cache l2
     *
     * @param memIndex dado a ser procurado em l2
     */
    private boolean l2HasMem(int memIndex)
    {
        if(cacheL2[memIndex % cacheL2.length] == null)
        {
            return false;
        }
        else return cacheL2[memIndex % cacheL2.length] == memIndex;
    }

    boolean memIsLoaded(int memIndex, int coreIndex, boolean load)
    {
        if(cores[coreIndex].l1HasMem(memIndex))
        {
            System.out.println(">>> Memory Address is in Cache l1");
            return true;
        }
        else if(l2HasMem(memIndex))
        {
            System.out.println(">>> Memory Address is not in Cache l1");
            System.out.println(">>> Memory Address is in Cache l2");
            return true;
        }
        else    // if is not in L1 or L2 load to cache
        {
            System.out.println(">>> Memory Address is not in Cache l2 or Cache l1");
            if(load)
            {
                System.out.println(">>> Loading Memory Address to Cache l2 and l1...");
                cacheL2[memIndex % cacheL2.length] = memIndex;
                cores[coreIndex].execute(memIndex);

                return true;
            }
            else
                return false;
        }
    }

    void input(int memoryIndex, int coreIndex, int[] memory, int nValue)
    {
        cores[coreIndex].execute(memoryIndex, memory, nValue);
    }
}