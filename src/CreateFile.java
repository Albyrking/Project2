import java.io.File;
import java.io.IOException;

public class CreateFile implements FileOperation {
    @Override
    public void action(String[] words) {
        String path = words[2], fileName =words[1];
        boolean hasTxt = false;
        if (fileName.charAt(fileName.length() - 4) != '.') {
            fileName = fileName + ".txt";
        }

        File file = new File(path + "\\" + fileName);

        try {

            if (file.exists()) {

                File newFile = new File(createPath(path, 1, fileName));
                newFile.createNewFile();
                System.out.println("File was renamed and successfully created");
                System.out.println("New fileName:" + newFile.getName());
            } else {

                file.createNewFile();
                System.out.println("File was created");
                System.out.println("Name:" + file.getName());
            }

        } catch (IOException e) {

            throw new RuntimeException("Enter command one more time");
        }
    }
    public String createPath(String path, int g, String fileName) {
        String newPath;
        newPath = path + "\\" + fileName.substring(0, fileName.length() - 4) + "-" + g + ".txt";
        try {

            if ((new File(newPath)).createNewFile()) {

                return newPath;

            } else {

                return createPath(path, g + 1, fileName);

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }
}
