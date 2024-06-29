import java.io.File;
import java.io.IOException;

public class CreatePath implements File_O_Tool{
    @Override
    public String action(String path, int g, String fileName) {

        String newPath;
        newPath = path + "\\" + fileName.substring(0, fileName.length() - 4) + "-" + g + ".txt";
        try {

            if ((new File(newPath)).createNewFile()) {

                return newPath;

            } else {

                return action(path, g + 1, fileName);

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }
}
