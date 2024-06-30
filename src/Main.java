import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("List of commands:\ncreate name_of_file path_for_new_file\ndelete name_of_file path_of_file\nrename path_of_file old_name_of_file new_name_for_file\ncopy name_of_file old_path_of_file new_path_of_file");
        String commands = in.nextLine(), command = "";
        String[] words = commands.split(" ");
        CreateFile createFile = new CreateFile();
        DeleteFile deleteFile = new DeleteFile();
        RenameFile renameFile = new RenameFile();
        CopyFile copyFile = new CopyFile();
        command = words[0];

        while (!command.equals("Stop")) {
            try {
                switch (command) {
                    case "create" -> createFile.action(words);
                    case "delete" -> deleteFile.action(words);
                    case "rename" -> renameFile.action(words);
                    case "copy" -> copyFile.action(words);
                    default -> throw new RuntimeException("Check the correctness of your command");
                }
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            commands = in.nextLine();
            words = commands.split(" ");
            command = words[0];

        }


    }


}