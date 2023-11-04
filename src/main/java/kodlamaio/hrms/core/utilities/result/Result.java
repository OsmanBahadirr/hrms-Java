package kodlamaio.hrms.core.utilities.result;

import lombok.Getter;

public class Result {
    @Getter
    private boolean success;

    @Getter
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
