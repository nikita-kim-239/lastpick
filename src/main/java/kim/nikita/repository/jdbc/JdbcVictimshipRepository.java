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
import kim.nikita.model.Hero;
import kim.nikita.model.Victimship;
import kim.nikita.repository.VictimshipRepository;
import org.springframework.stereotype.Repository;



@Repository
public class JdbcVictimshipRepository implements VictimshipRepository{

      private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      
      private static final String SELECT_ALL = "select V.id,V.predator_id,V.victim_id,H1.name as predator_name,H2.name as victim_name from victimship as V join heroes as H1 on H1.id=V.predator_id join heroes as H2 on H2.id=V.victim_id order by V.id DESC";
      private static final String INSERT_ENEMIES_QUERY = "insert into victimship (predator_id,victim_id) values (?,?)";
      private static final String SELECT_COUNT = "select count(*) from victimship where predator_id=? and victim_id=?";
    

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
                        int id=resultSet.getInt("id");
                        int predatorId=resultSet.getInt("predator_id");
                        int victimId=resultSet.getInt("victim_id");
                        String predatorName=resultSet.getString("predator_name");
                        String victimName=resultSet.getString("victim_name");
                        
                        Victimship victimship = new Victimship(id,new Hero(predatorId,predatorName),new Hero(victimId,victimName));
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
    public void create(int predator_id,int victim_id) {
        
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
                                        pstmt.setInt(1,predator_id);
                                        pstmt.setInt(2,victim_id);                                       
                                        pstmt.executeUpdate();
                                        
                
                connection.close();
                pstmt.close();                        

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}   
        
        
        
    }
    
    
    @Override
    public int count(int predator_id,int victim_id) {
        
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
                                        pstmt.setInt(1,predator_id);
                                        pstmt.setInt(2,victim_id);                                       
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
