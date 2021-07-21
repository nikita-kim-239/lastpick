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
import kim.nikita.controller.HeroController;
import kim.nikita.model.Hero;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@WebServlet("/result")
public class IndexServlet extends HttpServlet{

      private ConfigurableApplicationContext springContext;
      private HeroController heroController;
      
      
      private static final String SELECT_ENEMIES_QUERY = "select count(*) from victimship  where predator=? and victim=?";
      private static final Logger log = Logger.getLogger(IndexServlet.class);

      
      @Override
      public void init(){
            springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
            heroController=springContext.getBean(HeroController.class);
      }
      
      @Override
        public void destroy() {
            springContext.close();
            super.destroy();
        }
      
      
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<String> friends=new ArrayList<>();
        List<String> enemies=new ArrayList<>();
        List<Result> results=new ArrayList<>();
               
        String  enemy1=request.getParameter("enemy1");
        String  enemy2=request.getParameter("enemy2");
        String  enemy3=request.getParameter("enemy3");
        String  enemy4=request.getParameter("enemy4");
        String  enemy5=request.getParameter("enemy5");
        String  ally1=request.getParameter("ally1");
        String  ally2=request.getParameter("ally2");
        String  ally3=request.getParameter("ally3");
        String  ally4=request.getParameter("ally4");
        
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        friends.add(ally1);
        friends.add(ally2);
        friends.add(ally3);
        friends.add(ally4);
        
        List <Hero> heroes = heroController.getAllHeroes();
        
        for (Hero hero:heroes)
            {
                if ((!friends.contains(hero.getName()))&&(!enemies.contains(hero.getName())))
                    {
                        log.info("counting result for "+hero.getName());
                        Result result = new Result(hero.getName(),heroController.getResult(hero.getName(),friends,enemies));
                        results.add(result);
                    }
            }
        
        
        results.sort(Comparator.comparing(o->o.getScore()));
        Collections.reverse(results);
        request.setAttribute("results",results);
        log.info("redirect to results");
        getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
    }

}

