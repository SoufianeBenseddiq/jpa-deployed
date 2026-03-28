package ma.ensa.jsftp1.beans;


import java.io.Serializable;

public class CalculatorBean implements Serializable {
    private double num1 = 0;
    private double num2 = 0;
    private double sum = 0;

    public void addNumber() {
        sum = num1 + num2;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
