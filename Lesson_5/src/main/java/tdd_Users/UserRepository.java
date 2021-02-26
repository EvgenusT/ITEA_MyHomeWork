package tdd_Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    public List<User> userList = new ArrayList<>();

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
        List<String> listAllUsersBySex = new ArrayList<>();
        for (User user : userList) {
            if (user.getSex().equals(sex))
                listAllUsersBySex.add(user.getName());
        }
        return listAllUsersBySex;
    }

    public int getHowManyUsers() {
        return userList.size();
    }

    public long getHowManyUsers(Sex sex) {
        return userList.stream().filter(s -> s.getSex().equals(sex)).collect(Collectors.counting());
    }

    public long getAllAgeUsers() {
        return userList.stream().collect(Collectors.summingLong(s -> s.getAge()));
    }

    public long getAllAgeUsers(Sex sex) {
        return userList.stream().filter(s -> s.getSex().equals(sex)).collect(Collectors.summingLong(s -> s.getAge()));
    }

    public double getAverageAgeOfAllUsers() {
        return userList.stream().collect(Collectors.averagingLong(s -> s.getAge()));
    }

    public double getAverageAgeOfAllUsers(Sex sex) {
        return userList.stream().filter(s -> s.getSex().equals(sex)).collect(Collectors.averagingLong(s -> s.getAge()));
    }
}
