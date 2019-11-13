package arq.comp;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String dataPath = "txt/";

        // Leitura do arquivo inicial
        System.out.println("Reading file from txt folder... Enter file name: ");
        dataPath += scanner.nextLine();

        // Inicializando um PC
        new PC(600, 2, 4, dataPath);
    }
}
