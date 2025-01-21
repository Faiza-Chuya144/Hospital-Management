package bd.edu.seu.hms.Model;

public class Sales {
    private String prescriptionNo;
    private String medicineCode;
    private String medicineName;
    private double price;
    private int quantity;
    private double totalPrice;

    public Sales(String prescriptionNo, String medicineCode, String medicineName, double price, int quantity, double totalPrice) {
        this.prescriptionNo = prescriptionNo;
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getPrescriptionNo() {
        return prescriptionNo;
    }

    public void setPrescriptionNo(String prescriptionNo) {
        this.prescriptionNo = prescriptionNo;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
