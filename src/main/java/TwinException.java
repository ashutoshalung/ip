public class TwinException extends Exception{

    public TwinException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
