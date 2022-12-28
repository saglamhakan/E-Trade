package Shopping.ETrade.core.result;

public class ErrorDataResult<T> extends DataResult {
    public ErrorDataResult(T data, boolean success, String messsage) {
        super(data, false, messsage);
    }

    public ErrorDataResult(T data, boolean success) {
        super(data, false);
    }
}
