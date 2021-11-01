package kim.nikita.controller;

import kim.nikita.model.User;
import org.junit.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RootControllerTest extends AbstractControllerTest{

    @Test
    public void getHeroes() throws Exception {

        perform(get("/heroes")
                .with(userAuth(new User("user","password"))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("heroes"))
                .andExpect(forwardedUrl("/heroes.jsp"));

    }

    @Test
    public void failedAuth() throws Exception{
        perform(get("/heroes"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/"));
    }





}
