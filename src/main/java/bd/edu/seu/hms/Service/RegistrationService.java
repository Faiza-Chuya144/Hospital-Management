package bd.edu.seu.hms.Service;

import bd.edu.seu.hms.Model.User;
import bd.edu.seu.hms.Utility.ConnectionSingleton;

import java.sql.*;


public class RegistrationService {

    public boolean signup(User user){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO registration VALUE('"+ user.getEmail() +"','"+ user.getName() +"','"+ user.getPassword() +"','"+ user.getUser() +"');";
            statement.execute(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public User login(String name,String password,String user){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM registration WHERE name = '"+ name +"' and password = '"+ password +"' and user = '"+ user +"';";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name1 = resultSet.getString("name");
                String password1 = resultSet.getString("password");
                String user1 = resultSet.getString("user");

                return new User(name, password, user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
