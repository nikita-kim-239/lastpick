/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita;




import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kim.nikita.model.Hero;
import kim.nikita.model.Victimship;

/**
 *
 * @author Никита
 */
public class DotaVictimshipHelp {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ALL_QUERY = "select V.id,V.predator_id,V.victim_id,H1.name as predator_name,H2.name as victim_name from victimship as V join heroes as H1 on H1.id=V.predator_id join heroes as H2 on H2.id=V.victim_id order by predator_name,victim_name";
      
      public static void main(String[] args)
        {
            List <Victimship> victimship=new ArrayList<> ();
         
            
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
                        Victimship v= new Victimship();
                        v.setId(id);
                        int predator_id=RS.getInt("predator_id");
                        String predator_name=RS.getString("predator_name");
                        
                        v.setPredator(new Hero(predator_id,predator_name));
                        
                        int victim_id=RS.getInt("victim_id");
                        String victim_name=RS.getString("victim_name");
                        
                        v.setVictim(new Hero(victim_id,victim_name));
                        victimship.add(v);
                    }
                    
                
            connection.close();
                Stmt.close();
                
                

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}    
        
        try(
                            BufferedWriter bw = new BufferedWriter(new FileWriter("victimship.txt")))
                    {
                       // чтение построчно

                            for (Victimship v:victimship)
                            {
                                bw.write("insert into victimship (id,hero1_id,hero2_id) values (\""+v.getId()+","+v.getPredator().getId()+","+v.getVictim().getId()+"\");\n");

                            }
                    }
        
        catch(IOException ex){

                        System.out.println(ex.getMessage());
                    } 
                        
                        
                        
        
        
        }
}