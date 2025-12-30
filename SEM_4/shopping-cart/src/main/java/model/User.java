package model;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String name;
    private String password;
    private LocalDateTime createAt;

    public User() {}

    public User(int id, String name, String password,LocalDateTime createAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
