/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kim.nikita.model.Victimship;
import org.apache.log4j.Logger;


@WebServlet("/victimship")
public class VictimServlet extends HttpServlet{
    
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ALL_QUERY = "select * from victimship order by predator,victim";
    private static final String INSERT_ENEMIES_QUERY = "insert into victimship (predator,victim) values (?,?)";
    private static final Logger log = Logger.getLogger(VictimServlet.class);
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        
        try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		return;
	}

        System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
        List <Victimship> victimship = new ArrayList <Victimship>();
        try {
		connection = DriverManager
		.getConnection(URL, USER, PASS);
                Statement Stmt = connection.createStatement();
                ResultSet RS = Stmt.executeQuery(SELECT_ALL_QUERY);
                
                
                
                while (RS.next())
                    {   
                        int id=RS.getInt("id");
                        String predator = RS.getString("predator");
                        String victim = RS.getString("victim");
                        
                        Victimship victims=new Victimship(id,predator,victim);
                        victimship.add(victims);
                    }
             connection.close();
                Stmt.close();
                    } catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		return;
	}   
        
        
        request.setAttribute("victims",victimship);
        getServletContext().getRequestDispatcher("/victims.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        String predator=request.getParameter("predator");
        String victim=request.getParameter("victim");
     
        try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		return;
	}

        System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
        
        
        try {
		connection = DriverManager
		.getConnection(URL, USER, PASS);
                Statement Stmt = connection.createStatement();
                
                PreparedStatement pstmtInsert=connection.prepareStatement(INSERT_ENEMIES_QUERY);
                                        pstmtInsert.setString(1,predator);
                                        pstmtInsert.setString(2,victim);                      
                                        pstmtInsert.executeUpdate();
                
                
                    
                

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		return;
	}   
        log.info("redirect to victims");
        response.sendRedirect(request.getContextPath() + "/victimship");
        
    }
    
}
