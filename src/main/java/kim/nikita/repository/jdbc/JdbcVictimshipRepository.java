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
import kim.nikita.model.Victimship;
import kim.nikita.repository.VictimshipRepository;
import org.springframework.stereotype.Repository;



@Repository
public class JdbcVictimshipRepository implements VictimshipRepository{

      private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ENEMY_QUERY = "select count(*) from victimship where predator=? and victim=?";
      private static final String SELECT_ALL = "select * from victimship order by predator,victim";
      private static final String INSERT_ENEMIES_QUERY = "insert into victimship (predator,victim) values (?,?)";
    
    @Override
    public boolean isExist(String predator, String victim) {
        
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
                Statement Stmt = connection.createStatement();
                
                PreparedStatement pstmt=connection.prepareStatement(SELECT_ENEMY_QUERY);
                                        pstmt.setString(1,predator);
                                        pstmt.setString(2,victim);                                    
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
    public List<Victimship> getAllVictims() {
        
        List <Victimship> result= new ArrayList<>();
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
                ResultSet resultSet=Stmt.executeQuery(SELECT_ALL);
                while (resultSet.next())
                    {
                        Victimship victimship = new Victimship(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                        result.add(victimship);
                    }
                              
                connection.close();
                Stmt.close();
                                                                       
                                        
                                        

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}   
        
        return result;
        
    }

    @Override
    public void create(String predator,String victim) {
        
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
                
                
                PreparedStatement pstmt=connection.prepareStatement(INSERT_ENEMIES_QUERY);
                                        pstmt.setString(1,predator);
                                        pstmt.setString(2,victim);                                       
                                        pstmt.executeUpdate();
                                        
                
                connection.close();
                pstmt.close();                        

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}   
        
        
        
    }
    
}
