package tdd_Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public List<User> addUser(User user) {
        userList.add(user);
        return userList;
    }

    public List<User> addAllUsers(List<User> users) {
        userList.addAll(users);
        return userList;
    }

    public List<String> getAllUsers() {
        List<String> listAllUsers = new ArrayList<>();
        for (User user : userList) {
            listAllUsers.add(user.getName());
        }
        return listAllUsers;
    }

    public List<String> getAllUsers(Sex sex) {
      return userList.stream().filter(s-> s.getSex().equals(sex)).map(User::getName).collect(Collectors.toList());
    }

    public int getHowManyUsers() {
        return userList.size();
    }

    public long getHowManyUsers(Sex sex) {
        return userList.stream().filter(s -> s.getSex().equals(sex)).count();
    }

    public int getAllAgeUsers() {
        return userList.stream().mapToInt(User::getAge).sum();
    }

    public int getAllAgeUsers(Sex sex) {
        return userList.stream().filter(s -> s.getSex().equals(sex)).mapToInt(User::getAge).sum();
    }

    public double getAverageAgeOfAllUsers() {
        return userList.stream().collect(Collectors.averagingLong(User::getAge));
    }

    public double getAverageAgeOfAllUsers(Sex sex) {
        return userList.stream().filter(s -> s.getSex().equals(sex)).collect(Collectors.averagingLong(User::getAge));
    }
}
