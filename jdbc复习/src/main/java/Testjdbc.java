import java.sql.*;

public class Testjdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/jdbc?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "123456";


        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement = connection.createStatement();

        String sql = "select * from people";

        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next()) {
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }

        resultSet.close();
        statement.close();
        connection.close();


    }
}
