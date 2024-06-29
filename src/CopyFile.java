import java.io.File;

public class CopyFile implements FileOperation {
    @Override
    public void action(String[] words) {
        File file = new File(words[2] + "\\" + words[1]);
        if(file.exists()){
            file.renameTo((new File(words[3] +"\\" + words[1])));
            System.out.println("Done, file " + words[1] +" is copied");
        }else{
            throw new NoSuchFileFound();
        }
    }
}
