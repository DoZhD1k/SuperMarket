package Class;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private int age;

    public Customer(Integer id, int age) {
        this.id = id;
        this.age = age;
    }

    public Customer() {
    }

    public Customer(Integer id, String name, String surname, String login, String password, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "name='" + name + ", surname='" + surname + ", login='" + login + ", password='" + password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
