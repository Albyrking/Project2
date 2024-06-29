import java.io.File;

public class RenameFile implements File_O{
    @Override
    public void action(String[] words) {
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
}
