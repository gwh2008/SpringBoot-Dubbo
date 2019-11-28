package cn.coinque.consumer.system.exception;

public class NotAuthorizedException extends RuntimeException {

    public NotAuthorizedException() {
        super("未授权操作！");
    }
}
