package com.example.ortiz.ProyectoIntegrador;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.ortiz.ProyectoIntegrador.Models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        // Configurar comportamientos de los mocks si es necesario
    }

    @Test
    public void testGetAllUsers() {
        // Configurar datos de prueba
        List<User> users = new ArrayList<>();
        users.add(new User("1", "username1", "email1"));
        users.add(new User("2", "username2", "email2"));

        // Configurar comportamiento del mock
        when(userRepository.findAll()).thenReturn(users);

        // Ejecutar método a probar
        List<User> result = userService.getAllUsers();

        // Verificar resultados
        assertEquals(2, result.size());
        // Agrega más aserciones según tus necesidades
    }
    @Test
    public void testCreateUser() {
        // Configurar datos de prueba
        User newUser = new User("1", "newUser", "newuser@example.com");

        // Configurar comportamiento del mock
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        // Ejecutar método a probar
        User createdUser = userService.createUser(newUser);

        // Verificar resultados
        assertNotNull(createdUser);
        assertEquals(newUser.getUsername(), createdUser.getUsername());
        assertEquals(newUser.getEmail(), createdUser.getEmail());
    }
    @Test
    public void testGetUserById() {
        // Configurar datos de prueba
        String userId = "1";
        User user = new User(userId, "testUser", "testuser@example.com");

        // Configurar comportamiento del mock
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Ejecutar método a probar
        User retrievedUser = userService.getUserById(userId);

        // Verificar resultados
        assertNotNull(retrievedUser);
        assertEquals(userId, retrievedUser.getId());
        assertEquals(user.getUsername(), retrievedUser.getUsername());
        assertEquals(user.getEmail(), retrievedUser.getEmail());
    }
    @Test
    public void testDeleteUser() {
        // Configurar datos de prueba
        String userId = "1";

        // Ejecutar método a probar
        userService.deleteUser(userId);

        // Verificar que el método deleteById del repositorio fue invocado con el ID correcto
        verify(userRepository, times(1)).deleteById(userId);
    }
    @Test
    public void testGetAllUsers() {
        // Configurar datos de prueba
        List<User> users = new ArrayList<>();
        users.add(new User("1", "user1", "user1@example.com"));
        users.add(new User("2", "user2", "user2@example.com"));

        // Configurar comportamiento del mock
        when(userRepository.findAll()).thenReturn(users);

        // Ejecutar método a probar
        List<User> result = userService.getAllUsers();

        // Verificar resultados
        assertNotNull(result);
        assertEquals(users.size(), result.size());
        // Agregar más aserciones según tus necesidades
    }


}
