package main.utils;

/**
 * Created by admin on 26.04.2017.
 */
public class Message {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void beanInit(){
        System.out.println("Bean start");
    }
    public void beanDestroy(){
        System.out.println("Bean done");
    }
}
