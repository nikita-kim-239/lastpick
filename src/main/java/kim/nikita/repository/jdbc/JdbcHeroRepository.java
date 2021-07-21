/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kim.nikita.model.Hero;
import kim.nikita.repository.HeroRepository;
import org.springframework.stereotype.Repository;



@Repository
public class JdbcHeroRepository implements HeroRepository{

      private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ALL_QUERY = "select * from heroes order by name";
    @Override
    public List<Hero> getAllHeroes() {
        
        List <Hero> heroes = new ArrayList<Hero>();
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
                        String name = RS.getString("name");
                        heroes.add(new Hero(id,name));
                        
                    }    
                
            connection.close();
                Stmt.close();
                
                

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}    
        return heroes;
    }
    
}
