package org.example.poo.statics;

public class User {

    public static final String DEFAULT_USER_GROUP = "customers";

    private static int counter = 0;

    protected int id;

    protected String name;

    {
        counter++;
    }
    public User() {
        this.id = counter;
    }

    public User(String name) {
        this.id = counter;
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
