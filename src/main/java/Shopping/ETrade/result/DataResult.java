package Shopping.ETrade.result;

public class DataResult<T> extends Result {
    private T data;

    public DataResult(T data, boolean success, String message) {
        super(success);
        this.data = data;

    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public DataResult(boolean success, String message) {
        super(success, message);
    }

    public T getData() {
        return this.data;
    }
}
