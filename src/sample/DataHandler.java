package sample;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DataHandler {

    public static String savePath = "SaveFile.txt";
    public static File saveFile = new File(savePath);

    public static int PlayTime = 0;
    public static int Tix = 250;

    public static Boolean saveExists() {
        return saveFile.exists();
    }

    public static void load() {

        try {
            if (saveFile.createNewFile()) {

                save(true, Tix, PlayTime, "");

            } else {

                System.out.println("Save Exists");
                try {
                    Scanner fileReader = new Scanner(new File(savePath));
                    String[] data = fileReader.nextLine().split(";");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void save(Boolean newSave, int newTix, int newPlayTime, String NewPlayerName) {

        if (!newSave) {

            //Save Normally
            System.out.println("Save Exists");



        } else {

            //New Save

            try {

                System.out.println("New Save File");

                FileWriter fileWriter = new FileWriter(savePath);
                fileWriter.write("PlayerName=yes;" + "Coins=" + Tix + ";PlayTime=" + PlayTime);
                fileWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
