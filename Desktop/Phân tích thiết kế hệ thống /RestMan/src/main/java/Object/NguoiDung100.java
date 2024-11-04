package Object;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anhphuc
 */
public class NguoiDung100 {
    private int userId;
    private String username;
    private String password;
    private String email;

    public NguoiDung100() {
    }
    public NguoiDung100(NguoiDung100 user) {
        this.username = user.getUsername();
        this.userId = user.getUserId();
        this.email = user.getEmail();
    }
    
    public NguoiDung100(int userId,String username,String email){
        this.username = username;
        this.userId = userId;
        this.email = email;
    }
    public NguoiDung100(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public NguoiDung100(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override public String toString(){
        return "NguoiDung : " + this.username +  "\nEmail : " + this.email;
    }
}

