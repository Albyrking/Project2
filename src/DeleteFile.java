import java.io.File;

public class DeleteFile implements File_O{
    @Override
    public void action(String[] words) {
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
}
