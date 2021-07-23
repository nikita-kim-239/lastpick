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
import kim.nikita.controller.HeroController;
import kim.nikita.model.Victimship;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@WebServlet("/victimship")
public class VictimServlet extends HttpServlet{
    
   
    
    private ConfigurableApplicationContext springContext;
      private HeroController heroController;
    
    private static final Logger log = Logger.getLogger(VictimServlet.class);
    
    @Override
      public void init(){
            springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/spring-db.xml");
            heroController=springContext.getBean(HeroController.class);
      }
      
      @Override
        public void destroy() {
            springContext.close();
            super.destroy();
        }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        
        List <Victimship> victimship=heroController.getAllVictims();
        
        
        request.setAttribute("victims",victimship);
        getServletContext().getRequestDispatcher("/victims.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        String predator_id=request.getParameter("predator");
        String victim_id=request.getParameter("victim");
        
        heroController.createVictimship(Integer.parseInt(predator_id),Integer.parseInt(victim_id));
        log.info("redirect to victims");
        response.sendRedirect(request.getContextPath() + "/victimship");
        
    }
    
}
