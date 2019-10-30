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
        ArrayList<String> data = new ArrayList<>();
        File file;
        Scanner fileData;

        System.out.println("Reading file from txt folder... Enter file name: ");
        dataPath += scanner.nextLine();

        file = new File(dataPath);
        try
        {
            fileData = new Scanner(file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return;
        }


        while (fileData.hasNextLine())
        {
            data.add(fileData.nextLine());
        }


        new PC(600, 4, data);
    }
}
