package ma.ensa.jsftp1.controller;

import java.io.Serializable;

public class HelloBean implements Serializable {

    private String message = "Hello World!";

    public String getMessage() {
        return message;
    }

    public String randomRedirect(){
        int random = getRandomInt();
        if(random%2==0){
            return goToPile();
        }
        return goToFace();
    }

    private int getRandomInt(){
        int min = 1;
        int max = 10;
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }

    public String goToPile(){
        return "pile.xhtml";
    }
    public String goToFace(){
        return "face.xhtml";
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("message = " + message);
    }
}