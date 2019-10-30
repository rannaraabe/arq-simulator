package arq.comp;

import java.util.ArrayList;
import java.util.Scanner;

class PC
{
    private CPU cpu;
    private Memory memory;
    private ArrayList<String> data;

    PC(int memSize, int coreNum, ArrayList<String> data)
    {
        memory = new Memory(memSize);

        int cacheL2 = memSize / 10;
        int cacheL1 = cacheL2 / 2;

        cpu = new CPU(coreNum, cacheL1, cacheL2);

        this.data = data;

        toMem();
    }

    private void toMem()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select memory to be read");

        //TODO Select memory to be read and save data to memory, also, select core to do the work
    }
}
