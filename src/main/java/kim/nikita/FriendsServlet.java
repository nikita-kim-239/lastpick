/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kim.nikita.controller.HeroController;
import kim.nikita.model.Friendship;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/friendship")
public class FriendsServlet extends HttpServlet{
    private static final Logger log = Logger.getLogger(FriendsServlet.class);
    
      
      private HeroController heroController;
    
    
     @Override
      public void init(){
            WebApplicationContext springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
            heroController=springContext.getBean(HeroController.class);
      }
      
      
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        List <Friendship> friendship = heroController.getAllFriends();
        request.setAttribute("friends",friendship);
        log.info("redirect to friends");
        getServletContext().getRequestDispatcher("/friends.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        String hero1_id=request.getParameter("hero1");
        String hero2_id=request.getParameter("hero2");
     
        heroController.createFriendship(Integer.parseInt(hero1_id),Integer.parseInt(hero2_id));
        log.info("redirect to friends");
        response.sendRedirect(request.getContextPath() + "/friendship");
    }
}
