package internetMarket.model;


import java.time.LocalDate;

public class User {
    private int user_id;
    private String name;
    private String address;
    private String email;
    private String gender;
    private LocalDate dateOfBirth;

    public User(int user_id, String name, String address, String email, String gender, LocalDate dateOfBirth) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getUser_id() {
        return user_id;
    }
}
