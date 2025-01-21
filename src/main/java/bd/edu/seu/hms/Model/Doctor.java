package bd.edu.seu.hms.Model;

public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private String qualification;
    private double fee;
    private String phone;
    private String room;


    public Doctor(String id, String name, String specialization, String qualification, double fee, String phone, String room) {
        this.id= id;
        this.name = name;
        this.specialization = specialization;
        this.qualification = qualification;
        this.fee = fee;
        this.phone = phone;
        this.room = room;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
