package arq.comp;

class Memory
{
    private int[] memory;
    private int index = 0;

    Memory(int size)
    {
        memory = new int[size];
    }

    void add(String data)
    {
        if(index + data.length() < memory.length)
        {
            for(int i = 0; i < data.length(); i++, index++)
            {
                memory[index] = data.charAt(i);
            }
        }
        else
        {
            System.out.println("Memory full!"); // TODO Exception
        }
    }

    int[] getMemory()
    {
        return memory;
    }
}
