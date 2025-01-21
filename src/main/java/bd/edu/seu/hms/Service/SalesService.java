package bd.edu.seu.hms.Service;

import bd.edu.seu.hms.Model.Sales;
import bd.edu.seu.hms.Utility.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesService {
    public boolean add(Sales sales){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query ="INSERT INTO sales VALUE('"+ sales.getPrescriptionNo() +"', '"+ sales.getMedicineCode() +"', '"+ sales.getMedicineName() +"', '"+ sales.getPrice() +"', '"+ sales.getQuantity() +"', '"+ sales.getTotalPrice() +"')";
            statement.execute(query);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Sales> getSalesList(){
        List<Sales> salesList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query ="SELECT * FROM sales";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String prescriptionNo = resultSet.getString("prescriptionNo");
                String medicineCode = resultSet.getString("medicineCode");
                String medicineName = resultSet.getString("medicineName");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                double totalPrice = resultSet.getDouble("totalPrice");

                Sales sales = new Sales(prescriptionNo, medicineCode, medicineName, price, quantity, totalPrice);
                salesList.add(sales);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
         return salesList;
    }
}

