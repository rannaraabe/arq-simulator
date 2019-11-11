package arq.comp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String dataPath = "txt/";


        System.out.println("Reading file from txt folder... Enter file name: ");
        dataPath += scanner.nextLine();




        new PC(600, 2, 4, dataPath);
    }
}
