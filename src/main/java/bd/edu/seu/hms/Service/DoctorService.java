package bd.edu.seu.hms.Service;
import bd.edu.seu.hms.Model.Doctor;
import bd.edu.seu.hms.Utility.ConnectionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    public boolean save(Doctor doctor) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO doctor VALUE('" + doctor.getId() + "','" + doctor.getName() + "','" + doctor.getSpecialization() + "','" +
                    doctor.getQualification() + "','" + doctor.getFee() + "','" + doctor.getPhone() + "','" + doctor.getRoom() + "');";
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Doctor doctor){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "UPDATE doctor SET name = '"+ doctor.getName() +"', specialization = '"+ doctor.getSpecialization() +"', qualification = '"+ doctor.getQualification()
                    +"', fee = '"+ doctor.getFee() +"', phone = '"+ doctor.getPhone() +"', room = '"+ doctor.getRoom() +"' WHERE id = '"+ doctor.getId() +"'";
            statement.execute(query);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(String id){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "DELETE FROM doctor WHERE id =" + id;
            statement.execute(query);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Doctor> getDoctorList() {
        List<Doctor> patientList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM doctor";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                String qualification = resultSet.getString("qualification");
                double fee = resultSet.getDouble("fee");
                String phone = resultSet.getString("phone");
                String room = resultSet.getString("room");

                Doctor doctor = new Doctor(id, name, specialization, qualification, fee, phone,room);
                patientList.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }
}

