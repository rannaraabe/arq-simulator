package arq.comp;

class Core
{
    int value;
    private int[] cacheL1;

    void setCache(int l1Size)
    {
        cacheL1 = new int[l1Size];
    }

    void execute(int data)
    {
        cacheL1[data % cacheL1.length] = data;
        System.out.println("Data: " + data);
    }
}
