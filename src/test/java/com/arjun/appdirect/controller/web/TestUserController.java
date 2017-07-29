package com.arjun.appdirect.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.arjun.appdirect.Application;
import com.arjun.appdirect.fixture.AuthenticationFixtures;
import com.arjun.appdirect.model.web.UserProfile;
import com.arjun.appdirect.service.UserService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@DirtiesContext
public class TestUserController {
	@Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Mock
    UserService userService;

    @Autowired
    UserController controller;

    List<UserProfile> users;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        ReflectionTestUtils.setField(controller, "userService", userService);

        users = new ArrayList<>();
        UserProfile user1 = new UserProfile();
        user1.setId(1L);
        user1.setFirstName("Arjun");
        user1.setLastName("Karnwal");
        user1.setEmail("arjunk@lol.com");
        users.add(user1);
    }

    @Test
    public void testUsers() throws Exception {
        when(userService.getAll()).thenReturn(users);

        mockMvc.perform(get("/appDirectUsers")).andExpect(content().string(containsString("Arjun")));
    }

    @Test
    public void testNoUsers() throws Exception {
        mockMvc.perform(get("/appDirectUsers"))
            .andExpect(content().string(containsString("No User")));
    }
    
    @Test
    public void testLogoutDisplaysWhenAuthenticated() throws Exception {
        mockMvc.perform(get("/").principal(AuthenticationFixtures.authenticatedOpenIdToken()))
                                  .andExpect(content().string(containsString("logout")));
    }

    @Test
    public void testLogoutNotDisplaysWhenAuthenticated() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(content().string(not(containsString("logout"))));
    }
    
    @Test
    public void testUnauthenticated() throws Exception {

        mockMvc.perform(get("/"))
               .andExpect(model().attribute("authenticated", false));
    }

    @Test
    public void testAuthenticated() throws Exception {

        mockMvc.perform(get("/").principal(AuthenticationFixtures.authenticatedOpenIdToken()))
               .andExpect(model().attribute("authenticated", true));
    }

}
