package com.flavio.estudos.spring.hr.hruser.hruser.tests.controllers;

import com.flavio.estudos.spring.hr.hruser.hruser.controllers.UserController;
import com.flavio.estudos.spring.hr.hruser.hruser.entities.Role;
import com.flavio.estudos.spring.hr.hruser.hruser.entities.User;
import com.flavio.estudos.spring.hr.hruser.hruser.repositories.UserRepository;
import com.flavio.estudos.spring.hr.hruser.hruser.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class HrUserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    void findUserById_withoutRoles() throws Exception {

        var userMock = new User(1l, "Test", "teste@test", "password");

        when(service.findById(1l))
                .thenReturn(userMock);

        var request = MockMvcRequestBuilders
                .get("/users/1")
                .accept(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:Test,email:teste@test,password:password,roles:[]}"))
                .andReturn();

        verify(service, times(1)).findById(1);
    }

    @Test
    void findUserById_withRoles() throws Exception {

        var userMock = new User(1l, "Test", "teste@test", "password");
        userMock.addRole(new Role(1l, "admin"));

        when(service.findById(1l))
                .thenReturn(userMock);

        var request = MockMvcRequestBuilders
                .get("/users/1")
                .accept(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:Test,email:teste@test,password:password,roles:[{id:1, roleName: 'admin'}]}"))
                .andReturn();

        verify(service, times(1)).findById(anyLong());
    }
}
