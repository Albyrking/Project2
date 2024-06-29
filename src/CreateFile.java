import java.io.File;
import java.io.IOException;

public class CreateFile implements File_O{
    @Override
    public void action(String[] words) {
        CreatePath p = new CreatePath();
        String path = words[2], fileName =words[1];
        boolean hasTxt = false;
        if (fileName.charAt(fileName.length() - 4) != '.') {
            fileName = fileName + ".txt";
        }

        File file = new File(path + "\\" + fileName);

        try {

            if (file.exists()) {

                File newFile = new File(p.action(path, 1, fileName));
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
}
