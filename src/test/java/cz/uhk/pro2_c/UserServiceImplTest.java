package cz.uhk.pro2_c;

import cz.uhk.pro2_c.model.User;
import cz.uhk.pro2_c.repository.UserRepository;
import cz.uhk.pro2_c.security.MyUserDetails;
import cz.uhk.pro2_c.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setUsername("testuser");
        testUser.setPassword("password123");
    }

    @Test
    public void testGetUsers() {
        // Představíme uživatele, které vrátí mockovaný UserRepository
        when(userRepository.findAll()).thenReturn(List.of(testUser));

        // Zavoláme metodu a ověříme výsledek
        var users = userService.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(testUser, users.get(0));

        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testSaveUser() {
        // Mockování chování passwordEncoder
        when(passwordEncoder.encode(testUser.getPassword())).thenReturn("encodedPassword");

        // Zavolání metody
        userService.saveUser(testUser);

        // Ověření, že password bylo zakódováno
        verify(passwordEncoder, times(1)).encode(testUser.getPassword());

        // Ověření, že metoda save byla zavolána na repository
        verify(userRepository, times(1)).save(testUser);
    }

    @Test
    public void testGetUser() {
        // Mockování chování repository
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        // Zavolání metody a ověření výstupu
        User foundUser = userService.getUser(1L);
        assertNotNull(foundUser);
        assertEquals(testUser.getId(), foundUser.getId());

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteUser() {
        // Zavolání metody
        userService.deleteUser(1L);

        // Ověření, že deleteById bylo zavoláno
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testLoadUserByUsername_UserFound() {
        // Mockování chování repository
        when(userRepository.findByUsername("testuser")).thenReturn(testUser);

        // Zavolání metody
        UserDetails userDetails = userService.loadUserByUsername("testuser");

        // Ověření, že vrácený objekt je instance MyUserDetails
        assertNotNull(userDetails);
        assertTrue(userDetails instanceof MyUserDetails);

        // Ověření, že byl volán userRepository findByUsername
        verify(userRepository, times(1)).findByUsername("testuser");
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Mockování chování repository, aby vrátilo null
        when(userRepository.findByUsername("testuser")).thenReturn(null);

        // Zavolání metody a ověření, že vyhodí UsernameNotFoundException
        assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserByUsername("testuser");
        });

        verify(userRepository, times(1)).findByUsername("testuser");
    }
}
