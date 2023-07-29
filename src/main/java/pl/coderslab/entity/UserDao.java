package pl.coderslab.entity;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import pl.coderslab.jbcrypt.BCrypt;
import pl.coderslab.oppdao.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDao {
    private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?;";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?;";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM users";
    private static final String DATABASE = "workshop2";

public User create(User user){
    try(Connection conn = DbUtil.getConnection(DATABASE)){
        PreparedStatement preStmt = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
        preStmt.setString(1, user.getUserName());
        preStmt.setString(2, user.getEmail());
        preStmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        preStmt.executeUpdate();
        ResultSet rs = preStmt.getGeneratedKeys();
        if (rs.next()){
//            user.setId(rs.getInt(1));
            long id = rs.getLong(1);
            System.out.println("Inserted ID: " + id);
        }

        return user;
    } catch (SQLException e){
        e.printStackTrace();
        return null;
    }
}

public User read(int userId){
    try (PreparedStatement preStmt = DbUtil.getConnection(DATABASE).prepareStatement(READ_USER_QUERY)){
        preStmt.setInt(1, userId);
        ResultSet rs = preStmt.executeQuery();
        if(rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
    return null;
}

public void update(User user){
    try (PreparedStatement preStmt = DbUtil.getConnection(DATABASE).prepareStatement(UPDATE_USER_QUERY)){
        preStmt.setString(1, user.getUserName());
        preStmt.setString(2, user.getEmail());
        preStmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        preStmt.setInt(4, user.getId());
        preStmt.executeUpdate();
    } catch (SQLException e){
        e.printStackTrace();
    }
}

public void delete(int userId){
    try ( PreparedStatement preStmt = DbUtil.getConnection(DATABASE).prepareStatement(DELETE_USER_QUERY)){
        preStmt.setInt(1, userId);
        preStmt.executeUpdate();
    } catch (SQLException e){
        e.printStackTrace();
    }
}

//public void findAll(){
//    String[] dbArray = new String[0];
//    int counter = 0;
//    try (PreparedStatement preStmt = DbUtil.getConnection(DATABASE).prepareStatement(FIND_ALL_USERS_QUERY)){
//    ResultSet rs = preStmt.executeQuery();
//    while(rs.next()){
//        addToArray(dbArray)[counter] = String.format("Id: %s, user name: %s, email: %s, password: %s",
//                rs.getInt("id"),
//                rs.getString("username"),
//                rs.getString("email"),
//                rs.getString("password"));
//        counter++;
//    }
//    } catch (SQLException e){
//        e.printStackTrace();
//    }
//
//}

private String[] addToArray(String[] arr){
    return Arrays.copyOf(arr, arr.length + 1);
}

}

