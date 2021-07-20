/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita;

import kim.nikita.model.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class IndexServlet extends HttpServlet{

      private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dotapick";
      private static final String USER = "postgres";
      private static final String PASS = "postgres";
      private static final String SELECT_ALL_QUERY = "select * from heroes";
      private static final String SELECT_FRIENDS_QUERY = "select count(*) from friendship where hero1=? and hero2=? or hero1=? and hero2=?";
      private static final String SELECT_ENEMIES_QUERY = "select count(*) from victimship  where predator=? and victim=?";
      

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String  enemy1=request.getParameter("enemy1");
        String  enemy2=request.getParameter("enemy2");
        String  enemy3=request.getParameter("enemy3");
        String  enemy4=request.getParameter("enemy4");
        String  enemy5=request.getParameter("enemy5");
        String  ally1=request.getParameter("ally1");
        String  ally2=request.getParameter("ally2");
        String  ally3=request.getParameter("ally3");
        String  ally4=request.getParameter("ally4");
        List<String> friends=new ArrayList<>();
        List<String> enemies=new ArrayList<>();
        List<Result> results=new ArrayList<>();
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        friends.add(ally1);
        friends.add(ally2);
        friends.add(ally3);
        friends.add(ally4);
        
        
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
                ResultSet RS = Stmt.executeQuery(SELECT_ALL_QUERY);
                while (RS.next())
                    {   
                        
                        String name = RS.getString("name");
                        if ((!friends.contains(name))&&(!enemies.contains(name)))
                            {
                                Integer countFriends=0;
                                //находим количество друзей среди друзей
                                for (String friend:friends)
                                    {
                                        PreparedStatement pstmtFriends=connection.prepareStatement(SELECT_FRIENDS_QUERY);
                                        pstmtFriends.setString(1,name);
                                        pstmtFriends.setString(2,friend);
                                        pstmtFriends.setString(3,friend);
                                        pstmtFriends.setString(4,name);
                                        ResultSet RSFriends=pstmtFriends.executeQuery();
                                        RSFriends.next();
                                        countFriends+=RSFriends.getInt(1);
                                        
                                        pstmtFriends.close();
                                        
                                        
                                    }
                                Integer countEnemies=0;
                                //находим количество врагов среди врагов
                                for (String enemy:enemies)
                                    {
                                        PreparedStatement pstmtEnemies=connection.prepareStatement(SELECT_ENEMIES_QUERY);
                                        pstmtEnemies.setString(1,enemy);
                                        pstmtEnemies.setString(2,name);
                                        ResultSet RSEnemies=pstmtEnemies.executeQuery();
                                        RSEnemies.next();
                                        countEnemies+=RSEnemies.getInt(1);
                                        pstmtEnemies.close();
                                        
                                    }
                                //находим количество тех врагов, которые для нас являются жертвами
                                Integer countVictims=0;
                                for (String enemy:enemies)
                                    {
                                        PreparedStatement pstmtVictims=connection.prepareStatement(SELECT_ENEMIES_QUERY);
                                        pstmtVictims.setString(1,name);
                                        pstmtVictims.setString(2,enemy);
                                        ResultSet RSVictims=pstmtVictims.executeQuery();
                                        RSVictims.next();
                                        countVictims+=RSVictims.getInt(1);
                                        pstmtVictims.close();
                                        
                                    }
                                Result result=new Result(name,countFriends-countEnemies+countVictims);
                                results.add(result);
                            }
                    }
                connection.close();
                Stmt.close();
                
                

	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		return;
	}
        
        results.sort(Comparator.comparing(o->o.getScore()));
        Collections.reverse(results);
        System.out.println(results);
        
        request.setAttribute("results",results);
        getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
    }

}

