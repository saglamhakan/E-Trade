package Shopping.ETrade.core.result;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(T data, String success, String messsage) {
        super(data,true, messsage);
    }

    public SuccessDataResult(T data, String success) {
        super(data, true);
    }
}
