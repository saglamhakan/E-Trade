package Shopping.ETrade.core.result;

public class SuccessResult extends Result{
    public SuccessResult(String success) {
        super(true);
    }

    public SuccessResult(String success, String message) {
        super(true, "Success login");
    }
}
