package exception;

public class TipException extends RuntimeException {

    private static final long serialVersionUID = 1646240089378043794L;
    private int code = 400;

    public TipException(String msg) {
        super(msg);
    }

    public TipException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}