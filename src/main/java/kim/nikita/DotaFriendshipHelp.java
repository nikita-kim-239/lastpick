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
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;

/**
 *
 * @author Никита
 */
public class DotaFriendshipHelp {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ALL_QUERY = "select F.id,F.hero1_id,F.hero2_id,H1.name as hero1_name,H2.name as hero2_name from friendship as F join heroes as H1 on H1.id=F.hero1_id join heroes as H2 on H2.id=F.hero2_id order by H1.name,H2.name";
      
      public static void main(String[] args)
        {
            List <Friendship> friendship=new ArrayList<> ();
         
            
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
                        Friendship f= new Friendship();
                        f.setId(id);
                        int hero1_id=RS.getInt("hero1_id");
                        String hero1_name=RS.getString("hero1_name");
                        
                        f.setHero1(new Hero(hero1_id,hero1_name));
                        
                        int hero2_id=RS.getInt("hero2_id");
                        String hero2_name=RS.getString("hero2_name");
                        
                        f.setHero2(new Hero(hero2_id,hero2_name));
                        friendship.add(f);
                    }
                    
                
            connection.close();
                Stmt.close();
                
                

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}    
        
        try(
                            BufferedWriter bw = new BufferedWriter(new FileWriter("friendship.txt")))
                    {
                       // чтение построчно

                            for (Friendship f:friendship)
                            {
                                bw.write("insert into friendship (id,hero1_id,hero2_id) values (\""+f.getId()+","+f.getHero1().getId()+","+f.getHero2().getId()+"\");\n");

                            }
                    }
        
        catch(IOException ex){

                        System.out.println(ex.getMessage());
                    } 
                        
                        
                        
        
        
        }
}
