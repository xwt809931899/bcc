package cn.gebixiaoba.bean;

/**
 * Created by Administrator on 2020/3/25.
 */
public class Message {

    private int code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public Message(){}
    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
