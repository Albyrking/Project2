import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Operations {
    public void createFile(String[] words) {
        String path = words[2], fileName =words[1];
        boolean hasTxt = false;
        if (fileName.charAt(fileName.length() - 4) != '.') {
            fileName = fileName + ".txt";
        }

        File file = new File(path + "\\" + fileName);

        try {

            if (file.exists()) {

                File newFile = new File(createNewPath(path, 1, fileName));
                newFile.createNewFile();
                System.out.println("File was renamed and successfully created");
                System.out.println("New fileName:" + newFile.getName());
            } else {

                file.createNewFile();
                System.out.println("File was created");
                System.out.println("Name:" + file.getName());
            }

        } catch (IOException e) {

            throw new RuntimeException("enter command one more time.");
        }
    }

    public void deleteFile(String[] words) {
        String path = "", fileName = "";
        path = words[2];
        fileName = words[1];
        boolean hasTxt = false;

        if (fileName.charAt(fileName.length() - 4) != '.') {
            fileName = fileName + ".txt";
        }

        File file = new File(path + "\\" + fileName);

        if (file.delete()) {
            System.out.println("File \"" + fileName + "\" was successfully deleted");
        } else {
            throw new SuchFileIsNotFound();
        }

    }

    public void renameFile(String[] words) {
        String path = words[1] + "\\" + words[2] ,  newPath = words[1]+ "\\" +words[3];
        System.out.println("Path:" + path);
        System.out.println("NewPath:" + newPath);
        File file = new File(path);
        if (!file.exists()) {
            throw new SuchFileIsNotFound();
        } else {
            file.renameTo(new File(newPath));
            System.out.println("Done, file "+ words[2] +" is renamed. New name is " + words[3]);
        }

    }

    public void moveFile(String[] words) {
        File file = new File(words[2] + "\\" + words[1]);
        if(file.exists()){
            file.renameTo((new File(words[3] +"\\" + words[1])));
            System.out.println("Done, file " + words[1] +" is copied");
        }else{
            throw new SuchFileIsNotFound();
        }
    }

    public String createNewPath(String path, int g, String fileName) {
        String newPath;
        newPath = path + "\\" + fileName.substring(0, fileName.length() - 4) + "-" + g + ".txt";
        try {

            if ((new File(newPath)).createNewFile()) {

                return newPath;

            } else {

                return createNewPath(path, g + 1, fileName);

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }
}
