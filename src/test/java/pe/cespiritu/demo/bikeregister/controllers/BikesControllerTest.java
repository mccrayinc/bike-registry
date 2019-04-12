package pe.cespiritu.demo.bikeregister.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BikesController.class)
@AutoConfigureMockMvc(secure = false)
public class BikesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bikes"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
//                .andExpect(MockMvcResultMatchers.view().name("bikes"))
                ;
    }

    @Test
    public void create() {
    }

    @Test
    public void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bikes/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
//                .andExpect(MockMvcResultMatchers.view().name("bikes"))
        ;
    }
}
