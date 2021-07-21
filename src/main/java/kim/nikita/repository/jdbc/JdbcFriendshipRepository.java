/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.repository.FriendshipRepository;
import org.springframework.stereotype.Repository;



@Repository
public class JdbcFriendshipRepository implements FriendshipRepository{

      private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ALL_QUERY = "select * from friendship order by hero1,hero2";
      private static final String INSERT_FRIENDS_QUERY = "insert into friendship (hero1,hero2) values (?,?)";
      private static final String SELECT_FRIENDS_QUERY = "select count(*) from friendship where hero1=? and hero2=? or hero1=? and hero2=?";
    
    @Override
    public boolean isFriends(String hero1,String hero2) {
        
        int good=0;
        try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		
	}

        System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
        
        
        try {
		connection = DriverManager
		.getConnection(URL, USER, PASS);
                
                
                PreparedStatement pstmt=connection.prepareStatement(SELECT_FRIENDS_QUERY);
                                        pstmt.setString(1,hero1);
                                        pstmt.setString(2,hero2);
                                        pstmt.setString(3,hero2);
                                        pstmt.setString(4,hero1);
                                        ResultSet resultSet=pstmt.executeQuery();
                                        resultSet.next();
                                        good=resultSet.getInt(1);
                                        
                connection.close();
                pstmt.close();
                                        

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}   
        return good==1;
    }

    @Override
    public List<Friendship> getAllFriends() {
        
        List <Friendship> friendship = new ArrayList<Friendship>();
        try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		
	}

        System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
        
        try {
		connection = DriverManager
		.getConnection(URL, USER, PASS);
                Statement Stmt = connection.createStatement();
                ResultSet RS = Stmt.executeQuery(SELECT_ALL_QUERY);
                while (RS.next())
                    {   
                        int id=RS.getInt("id");
                        String hero1 = RS.getString("hero1");
                        String hero2 = RS.getString("hero2");
                        friendship.add(new Friendship(id,hero1,hero2));
                        
                    }    
                
            connection.close();
                Stmt.close();
                
                

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}    
        return friendship;
        
    }

    @Override
    public void create(String hero1, String hero2) {
       
        
        
        try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		
	}

        System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
        
        
        try {
		connection = DriverManager
		.getConnection(URL, USER, PASS);
                
                
                PreparedStatement pstmt=connection.prepareStatement(INSERT_FRIENDS_QUERY);
                                        pstmt.setString(1,hero1);
                                        pstmt.setString(2,hero2);                                       
                                        pstmt.executeUpdate();
                                        
                connection.close();
                pstmt.close();

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}   
        
    }
    
}
