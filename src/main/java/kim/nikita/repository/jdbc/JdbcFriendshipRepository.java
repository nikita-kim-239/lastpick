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
      private static final String SELECT_ALL_QUERY = "select F.id,F.hero1_id,F.hero2_id,H1.name as hero1_name,H2.name as hero2_name from friendship as F join heroes as H1 on H1.id=F.hero1_id join heroes as H2 on H2.id=F.hero2_id order by F.id DESC";
      private static final String INSERT_FRIENDS_QUERY = "insert into friendship (hero1_id,hero2_id) values (?,?)";
      private static final String SELECT_COUNT = "select count(*) from friendship where hero1_id=? and hero2_id=? or hero1_id=? and hero2_id=?";
    
   

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
                        int hero1_id = RS.getInt("hero1_id");
                        int hero2_id = RS.getInt("hero2_id");
                        String hero1_name=RS.getString("hero1_name");
                        String hero2_name=RS.getString("hero2_name");
                        friendship.add(new Friendship(id,new Hero(hero1_id,hero1_name),new Hero(hero2_id,hero2_name)));
                        
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
    public void create(int hero1_id, int hero2_id) {
       
        
        
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
                                        pstmt.setInt(1,hero1_id);
                                        pstmt.setInt(2,hero2_id); 
                                        
                                        pstmt.executeUpdate();
                                        
                connection.close();
                pstmt.close();

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}   
        
    }
    
    
    @Override
    public int count(int hero1_id,int hero2_id) {
        
        int count=0;
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
                
                
                PreparedStatement pstmt=connection.prepareStatement(SELECT_COUNT);
                                        pstmt.setInt(1,hero1_id);
                                        pstmt.setInt(2,hero2_id);  
                                        pstmt.setInt(3,hero2_id);
                                        pstmt.setInt(4,hero1_id); 
                                        ResultSet rs=pstmt.executeQuery();
                                        rs.next();
                                        count=rs.getInt(1);
                                        
                
                connection.close();
                pstmt.close();                        

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}   
        
        return count;
        
    }
    
    
}
