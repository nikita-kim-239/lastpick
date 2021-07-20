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
import kim.nikita.model.Friendship;
import org.apache.log4j.Logger;

@WebServlet("/friendship")
public class FriendsServlet extends HttpServlet{
    private static final Logger log = Logger.getLogger(FriendsServlet.class);
    
     private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ALL_QUERY = "select * from friendship order by hero1,hero2";
    private static final String INSERT_FRIENDS_QUERY = "insert into friendship (hero1,hero2) values (?,?)";
    
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
        List <Friendship> friends = new ArrayList <Friendship>();
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
                        
                        Friendship friendship=new Friendship(id,hero1,hero2);
                        friends.add(friendship);
                    }
             connection.close();
                Stmt.close();
                    } catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		return;
	}   
        
        
        request.setAttribute("friends",friends);
        log.info("redirect to friends");
        getServletContext().getRequestDispatcher("/friends.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        String hero1=request.getParameter("hero1");
        String hero2=request.getParameter("hero2");
     
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
                
                PreparedStatement pstmtInsert=connection.prepareStatement(INSERT_FRIENDS_QUERY);
                                        pstmtInsert.setString(1,hero1);
                                        pstmtInsert.setString(2,hero2);
                                        pstmtInsert.executeUpdate();
                
                
                    
                

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		return;
                
	}   
        response.sendRedirect(request.getContextPath() + "/friendship");
    }
}
