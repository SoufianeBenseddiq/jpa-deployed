package ma.ensa.jsftp1.controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class DevinetteBean {
    private int chances = 3;
    private int inputNumber;
    private int target;
    private boolean disabledInput = false;
    private String message;

    public DevinetteBean(){
        target = getRandomInt();
    }

    private int getRandomInt(){
        int min = 1;
        int max = 10;
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }

    public  int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public int getInputNumber() {
        return inputNumber;
    }


    public void submit(){
        chances--;
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (chances == 0) {
            setDisabledInput(true);
//            setMessage("OOPS, YOU LOST! click reset to try again!");
            ctx.addMessage(
                    "inputNumber",
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "OOPS, YOU LOST! click reset to try again!",
                            "You reached the chances limit !!!")
            );
        }else{
            if(inputNumber == target){
                setMessage("Good Job, the target is : " + target + " :)");
            }else if (inputNumber > target){
                setMessage("You are above the target :(");
            }else{
                setMessage("You are under the target :(");
            }
        }
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public void reset(){
        chances = 3;
        setTarget(getRandomInt());
        setDisabledInput(false);
        setMessage("Welcome back again !");
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public boolean isDisabledInput() {
        return disabledInput;
    }

    public void setDisabledInput(boolean disabledInput) {
        this.disabledInput = disabledInput;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
