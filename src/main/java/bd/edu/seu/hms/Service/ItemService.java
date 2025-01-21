package bd.edu.seu.hms.Service;
import bd.edu.seu.hms.Model.Item;
import bd.edu.seu.hms.Utility.ConnectionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    public boolean save(Item item) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO item VALUE('" + item.getId() + "','" + item.getName() + "','" + item.getDescription() + "','" + item.getSellPrice() + "','" + item.getBuyPrice() + "','" + item.getQuantity() + "','" + item.getStatus() + "','" + item.getImagePath() + "');";
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Item> getItemList() {
        List<Item> ItemList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM item";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double sellPrice = resultSet.getDouble("sellPrice");
                double buyPrice = resultSet.getDouble("buyPrice");
                int quantity = resultSet.getInt("quantity");
                String status = resultSet.getString("status");
                String imagePath = resultSet.getString("imagePath");

                Item item = new Item(id, name, description, sellPrice, buyPrice, quantity, status, imagePath);
                ItemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ItemList;
    }



    public Item getItemByCode(String medicineCode) {
        Item item = null;
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM item WHERE id = '" + medicineCode + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double sellPrice = resultSet.getDouble("sellPrice");
                double buyPrice = resultSet.getDouble("buyPrice");
                int quantity = resultSet.getInt("quantity");
                String status = resultSet.getString("status");
                String imagePath = resultSet.getString("imagePath");

                item = new Item(id, name, description, sellPrice, buyPrice, quantity, status, imagePath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

}
