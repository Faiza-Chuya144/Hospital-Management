package bd.edu.seu.hms.Model;

public class Prescription {
    private String prescriptionNo;
    private String appointmentNo;
    private String doctorName;
    private String patientName;
    private String diseasesType;
    private String description;

    public Prescription(String prescriptionNo, String appointmentNo, String doctorName, String patientName, String diseasesType, String description) {
        this.prescriptionNo = prescriptionNo;
        this.appointmentNo = appointmentNo;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.diseasesType = diseasesType;
        this.description = description;
    }

    public String getPrescriptionNo() {
        return prescriptionNo;
    }

    public void setPrescriptionNo(String prescriptionNo) {
        this.prescriptionNo = prescriptionNo;
    }

    public String getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiseasesType() {
        return diseasesType;
    }

    public void setDiseasesType(String diseasesType) {
        this.diseasesType = diseasesType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
