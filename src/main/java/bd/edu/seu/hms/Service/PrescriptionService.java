package bd.edu.seu.hms.Service;

import bd.edu.seu.hms.Model.Prescription;
import bd.edu.seu.hms.Utility.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionService {
    public boolean create(Prescription prescription) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO prescription VALUE('" + prescription.getPrescriptionNo() + "','" + prescription.getAppointmentNo() + "','" + prescription.getDoctorName() + "','" + prescription.getPatientName() + "','" + prescription.getDiseasesType() + "','" + prescription.getDescription() + "');";
            statement.execute(query);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Prescription> getPrescriptionList(){
        List<Prescription> prescriptionList = new ArrayList<>();
        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM prescription";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String prescriptionNo = resultSet.getString("prescriptionNo");
                String appointmentNo = resultSet.getString("appointmentNo");
                String doctorName = resultSet.getString("doctorName");
                String patientName = resultSet.getString("patientName");
                String diseasesType = resultSet.getString("diseasesType");
                String description = resultSet.getString("description");

                Prescription prescription = new Prescription(prescriptionNo, appointmentNo, doctorName,patientName,diseasesType, description);
                prescriptionList.add(prescription);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return prescriptionList;
    }
}
