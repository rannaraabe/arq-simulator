
package arq.comp;

class CPU
{
    private Core[] cores;
    private Integer[] cacheL2;
    private Integer blkSize;

    void setCpu(int coreNum, int l1Size, int l2Size)
    {
        cores = new Core[coreNum];

        cacheL2 = new Integer[l2Size];

        for(int i = 0; i < coreNum; i++)
        {
            cores[i] = new Core();
            cores[i].setCache(l1Size);
            cores[i].setBlkSize(2);
        }
        blkSize = 2;
    }

    Core[] getCores()
    {
        return cores;
    }

    void input(int memoryIndex, int coreIndex, int[] memory)
    {
        cores[coreIndex].loadToCacheL1(memoryIndex, memory);
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
            if(l2HasMem(memIndex))
            {
                System.out.println(">>> Memory Address is in Cache l1 and Cache l2");
                return true;
            }
            else
            {
                System.out.println(">>> Memory Address is in Cache l1 but is not in cache l2");
                System.out.println(">>> Loading Memory Address in cache l2");
                for(int i = memIndex; i < (memIndex + blkSize); i++)
                    cacheL2[i % cacheL2.length] = i;
                return true;
            }

        }
        else if(l2HasMem(memIndex))
        {
            System.out.println(">>> Memory Address is not in Cache l1");
            System.out.println(">>> Memory Address is in Cache l2");
            System.out.println(">>> Loading Memory Address in cache l1");
            cores[coreIndex].loadToCacheL1(memIndex);
            return true;
        }
        else    // if is not in L1 or L2 load to cache
        {
            System.out.println(">>> Memory Address is not in Cache l2 or Cache l1");
            if(load)
            {
                System.out.println(">>> Loading Memory Address to Cache l2 and l1...");
                for(int i = memIndex; i < (memIndex + blkSize); i++)
                    cacheL2[i % cacheL2.length] = i;

                cores[coreIndex].loadToCacheL1(memIndex);

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

    void printL2()
    {
        StringBuilder index = new StringBuilder();
        StringBuffer memData = new StringBuffer();
        int sz;

        for(int i = 0; i < cacheL2.length; i++)
        {
            sz = 6;

            index.append(" ".repeat(sz / 2));

            index.append(i);

            index.append(" ".repeat(sz / 2));

            index.append("|");

            memData.append(" ".repeat(sz / 2));

            memData.append(cacheL2[i]);

            memData.append(" ".repeat(sz / 2));

            memData.append("|");
        }


        System.out.println(index);
        System.out.println(memData);

        System.out.println();
    }
}