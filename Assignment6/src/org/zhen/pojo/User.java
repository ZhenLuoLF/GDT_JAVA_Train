package org.zhen.pojo;

public class User {
    private String userName;
    private String password;
    private String emailId;
    private int userId;
    private int[] newBook;
    private int[] favoriteBook;
    private int[] completedBook;

    public User() {

    }
    public User(String userName, String password, String emailId, int userId) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.userId = userId;
        this.newBook = new int[0];
        this.favoriteBook = new int[0];
        this.completedBook = new int[0];
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public int getUserId() {
        return userId;
    }

    public int[] getNewBook() {
        return newBook;
    }
    public void setNewBook(int[] newBook) {
        this.newBook = newBook;
    }
    public int[] getFavoriteBook() {
        return favoriteBook;
    }
    public void setFavoriteBook(int[] favoriteBook) {
        this.favoriteBook = favoriteBook;
    }
    public int[] getCompletedBook() {
        return completedBook;
    }
    public void setCompletedBook(int[] commentBook) {
        this.completedBook = commentBook;
    }
}
