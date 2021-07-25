/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita;

import kim.nikita.model.Result;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kim.nikita.controller.HeroController;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@WebServlet("/index")
public class IndexServlet extends HttpServlet{

      private ConfigurableApplicationContext springContext;
      private HeroController heroController;
      
      
      private static final String SELECT_ENEMIES_QUERY = "select count(*) from victimship  where predator=? and victim=?";
      private static final Logger log = Logger.getLogger(IndexServlet.class);

      
      @Override
      public void init(){
            WebApplicationContext springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
            heroController=springContext.getBean(HeroController.class);
      }
      
      
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        
        
        List<Integer> friends=new ArrayList<>();
        List<Integer> enemies=new ArrayList<>();
        
               
        int  enemy1_id=Integer.parseInt(request.getParameter("enemy1"));
        int  enemy2_id=Integer.parseInt(request.getParameter("enemy2"));
        int  enemy3_id=Integer.parseInt(request.getParameter("enemy3"));
        int  enemy4_id=Integer.parseInt(request.getParameter("enemy4"));
        int  enemy5_id=Integer.parseInt(request.getParameter("enemy5"));
        int  ally1_id=Integer.parseInt(request.getParameter("ally1"));
        int  ally2_id=Integer.parseInt(request.getParameter("ally2"));
        int  ally3_id=Integer.parseInt(request.getParameter("ally3"));
        int  ally4_id=Integer.parseInt(request.getParameter("ally4"));
        
        
        enemies.add(enemy1_id);
        enemies.add(enemy2_id);
        enemies.add(enemy3_id);
        enemies.add(enemy4_id);
        enemies.add(enemy5_id);
        friends.add(ally1_id);
        friends.add(ally2_id);
        friends.add(ally3_id);
        friends.add(ally4_id);
        
        System.out.println("enemies: "+enemies);
        System.out.println("friends: "+friends);
        
        List <Result> results=heroController.getResult(friends, enemies);
        
        
        request.setAttribute("results",results);
        log.info("redirect to results");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        
        
        log.info("redirect to index");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
}

