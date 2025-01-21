package bd.edu.seu.hms.Model;

public class Appointment {
    private String appointmentNo;
    private String doctorName;
    private String patientName;
    private String room;
    private String date;

    public Appointment(String appointmentNo, String doctorName, String patientName, String room, String date) {
        this.appointmentNo = appointmentNo;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.room = room;
        this.date = date;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
