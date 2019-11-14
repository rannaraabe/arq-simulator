package arq.comp;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String dataPath = "txt/";


        // Lendo nome do arquivo
        System.out.println("Reading file from txt folder... Enter file name: ");
        dataPath += scanner.nextLine();


        // Iniciando PC
        PC pc = new PC(600, 2, 4, dataPath);

        String choice;

        do
        {
            System.out.println("\n\nChoose one: ");
            System.out.println("1 - read");
            System.out.println("2 - write");
            System.out.println(">>> Type e to exit");
            choice = scanner.nextLine();
            switch(choice)
            {
                case "1":
                    pc.read();
                    break;
                case "2":
                    pc.write(); //TODO
                    break;
                case "e":
                    break;
            }
        } while(!(choice.equals("e")));
    }
}
