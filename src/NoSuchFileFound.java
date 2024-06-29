public class NoSuchFileFound extends RuntimeException{
    public NoSuchFileFound() {
        super("Error, file is not found");
    }
}
