package com.java.course.com.przykladyNowe;

public class NewUserAccount {
    private String userName;
    private String userSurname;
    private int userAge;

    public NewUserAccount(String userName, String userSurname, int userAge) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAge = userAge;
    }

    /*public static NewUserAccount newUserAccount() {
        return Optional.ofNullable()
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToString
    }

     */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "NewUserAccount{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
