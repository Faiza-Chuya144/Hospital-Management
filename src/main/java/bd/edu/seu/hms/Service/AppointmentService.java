package bd.edu.seu.hms.Service;
import bd.edu.seu.hms.Model.Appointment;
import bd.edu.seu.hms.Utility.ConnectionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    public boolean create(Appointment appointment) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO appointment VALUE('" + appointment.getAppointmentNo() + "','" + appointment.getDoctorName() + "','" + appointment.getPatientName() + "','" + appointment.getRoom() + "','" + appointment.getDate() + "');";
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String appointmentNo){
        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "DELETE FROM appointment WHERE appointmentNo =" + appointmentNo;
            statement.execute(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Appointment> getAppointmentList(){
        List<Appointment> appointmentList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM appointment";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String appointmentNo = resultSet.getString("appointmentNo");
                String doctorName = resultSet.getString("doctorName");
                String patientName = resultSet.getString("patientName");
                String room = resultSet.getString("room");
                String date = resultSet.getString("date");

                Appointment appointment = new Appointment(appointmentNo, doctorName, patientName, room, date);
                appointmentList.add(appointment);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
         return appointmentList;
    }

    public  List<Appointment> getAppointmentsForDoctor(String doctorName) {
        List<Appointment> appointmentList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM appointment WHERE doctorName = '" + doctorName + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String appointmentNo = resultSet.getString("appointmentNo");
                String doctorName1 = resultSet.getString("doctorName");
                String patientName = resultSet.getString("patientName");
                String room = resultSet.getString("room");
                String date = resultSet.getString("date");

                Appointment appointment = new Appointment(appointmentNo, doctorName1, patientName, room, date);
                appointmentList.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }
}