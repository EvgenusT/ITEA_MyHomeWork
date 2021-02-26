package tdd_Users;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();
    User user = new User(1, "Yarik", 25, Sex.MALE);
    User user1 = new User(2, "Olga", 50, Sex.FEMALE);
    User user2 = new User(3, "Alla", 24, Sex.FEMALE);
    User user3 = new User(4, "Petro", 29, Sex.MALE);

    List<User> listUsers = new ArrayList<>();

    @Test
    public void shouldCreatingNewUser() {
        listUsers.add(user);
        List<User> actualList = userRepository.addUser(user);
        assertEquals(listUsers, actualList);
    }

    //
    @Test
    public void shouldCreatingListNewUsers() {
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        List<User> actualList = userRepository.addAllUsers(listUsers);
        assertEquals(listUsers, actualList);
    }

    @Test
    public void shouldGetListAllUsers() {
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);
        List<String> expectedlistAllUsers = new ArrayList<>();
        expectedlistAllUsers.add("Yarik");
        expectedlistAllUsers.add("Olga");
        expectedlistAllUsers.add("Alla");
        expectedlistAllUsers.add("Petro");

        List<String> actuallistAllUsers = userRepository.getAllUsers();

        assertEquals(expectedlistAllUsers, actuallistAllUsers);
    }

    @Test
    public void shouldGetListAllUsersBySexMale() {
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);
        List<String> expectedlistMaleUsers = new ArrayList<>();
        expectedlistMaleUsers.add("Yarik");
        expectedlistMaleUsers.add("Petro");
        List<String> actuallistAllMaleUsers = userRepository.getAllUsers(Sex.MALE);
        assertEquals(expectedlistMaleUsers, actuallistAllMaleUsers);
    }

    @Test
    public void shouldGetHowManyUsers() {
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);
        int expectedAmount = 4;
        int actualAmount = userRepository.getHowManyUsers();
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void shouldGetHowManyUsersToSex() {
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);

        long expectedAmountBySex = 2;
        long actualAmountBySex = userRepository.getHowManyUsers(Sex.MALE);
        assertEquals(expectedAmountBySex, actualAmountBySex);
    }

    @Test
    public void shouldGetAllAgeUsers() {
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);
        long expectedAllAgeUsers = 128;
        long actualAllAgeUsers = userRepository.getAllAgeUsers();
        assertEquals(expectedAllAgeUsers, actualAllAgeUsers);
    }

    @Test
    public void shouldGetAllAgeUsersBySex() {
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);
        long expectedAllAgeUsers = 74;
        long actualAllAgeUsers = userRepository.getAllAgeUsers(Sex.FEMALE);
        assertEquals(expectedAllAgeUsers, actualAllAgeUsers);
    }

    @Test
    public void shouldGetAverageAgeOfAllUsers(){
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);

        double expectedAllAverageAge = 32.00;
        double actualAllAgeUsers = userRepository.getAverageAgeOfAllUsers();
        assertEquals(expectedAllAverageAge, actualAllAgeUsers, 0);
    }

    @Test
    public void shouldGetAverageAgeOfAllUsersBySex(){
        listUsers.add(user);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        userRepository.addAllUsers(listUsers);

        double expectedAllAverageAge = 27.00;
        double actualAllAgeUsers = userRepository.getAverageAgeOfAllUsers(Sex.MALE);
        assertEquals(expectedAllAverageAge, actualAllAgeUsers, 0);
    }

}