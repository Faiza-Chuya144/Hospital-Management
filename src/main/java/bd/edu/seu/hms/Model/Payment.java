package bd.edu.seu.hms.Model;

public class Payment {
    private double totalPrice;
    private double pay;
    private double balance;

    public Payment(double totalPrice, double pay, double balance) {
        this.totalPrice = totalPrice;
        this.pay = pay;
        this.balance = balance;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
