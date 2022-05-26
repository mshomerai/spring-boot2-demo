package ml.java.boot2.autoconfig;

public class Pet {

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void meow(){
        System.out.println(type + " meow...");
    }

}
