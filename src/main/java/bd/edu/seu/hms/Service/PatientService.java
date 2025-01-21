package bd.edu.seu.hms.Service;

import bd.edu.seu.hms.Model.Patient;
import bd.edu.seu.hms.Utility.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    public boolean save( Patient patient) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO patient VALUE('" + patient.getId() + "','" + patient.getName() + "','" + patient.getPhone() + "','" + patient.getAddress() + "','"+ patient.getGender() +"');";
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Patient patient){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "UPDATE patient SET name = '"+ patient.getName() +"', phone = '"+ patient.getPhone() +"', address = '"+ patient.getAddress() +" ' , gender = '"+ patient.getGender() +"' WHERE id = '"+ patient.getId() +"'";
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
            String query = "DELETE FROM patient WHERE id =" + id;
            statement.execute(query);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Patient> getPatientList() {
        List<Patient> patientList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM patient";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");

                Patient patient = new Patient(id, name, phone, address,gender);
                patientList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }
}
