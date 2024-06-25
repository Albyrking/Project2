import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String commands = in.nextLine(), command = "";
        String[] words = commands.split(" ");
        File_Operations file_operations = new File_Operations();
        command = words[0];
        while (!command.equals("Stop")) {
            switch (command) {
                case "create" -> file_operations.createFile(words);
                case "delete" -> file_operations.deleteFile(words);
                case "rename" -> file_operations.renameFile(words);
                case "copy" -> file_operations.moveFile(words);
            }

            commands = in.nextLine();
            words = commands.split(" ");
            command = words[0];

        }


    }


}