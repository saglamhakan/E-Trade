package Shopping.ETrade.core.result;

public class DataResult<T> extends Result {
    private T data;
    public DataResult(T data, boolean success, String message) {
        super(success);


    }
    public DataResult(T data, boolean success){
        super(success);
        this.data=data;
    }

    public DataResult(boolean success, String message) {
        super(success, message);
    }

    public T getData(){
        return this.data;
    }
}
