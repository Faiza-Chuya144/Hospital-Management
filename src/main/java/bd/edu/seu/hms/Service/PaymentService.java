package bd.edu.seu.hms.Service;

import bd.edu.seu.hms.Model.Payment;
import bd.edu.seu.hms.Utility.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    public boolean save(Payment payment) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO payment VALUES ('" + payment.getTotalPrice() + "', '" + payment.getPay() + "', '" + payment.getBalance() + "')";
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
