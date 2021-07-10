package com.flavio.estudos.spring.hr.hruser.hruser.tests.services;

import com.flavio.estudos.spring.hr.hruser.hruser.entities.User;
import com.flavio.estudos.spring.hr.hruser.hruser.repositories.UserRepository;
import com.flavio.estudos.spring.hr.hruser.hruser.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService service;

    @Test
    void findUserById() {
        var userMock = new User(1L, "Teste", "teste@teste", "password");

        when(userRepository.findById(1L))
                .thenReturn(java.util.Optional.of(userMock));

        var result = service.findById(1);

        assertEquals(result.getId(), userMock.getId());
        assertEquals(result.getEmail(), userMock.getEmail());
        assertEquals(result.getPassword(), userMock.getPassword());
        assertEquals(result.getName(), userMock.getName());
        assertEquals(result.getRoles(), userMock.getRoles());

        verify(userRepository, times(1)).findById(1L);
    }

}
