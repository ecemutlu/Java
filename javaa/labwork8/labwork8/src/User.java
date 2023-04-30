
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alper
 */
public abstract class User {

    private String name;
    private String surname;
    private String email;
    private Login logindetails;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.email = this.name + "." + this.surname + "@sampleuniversity.edu";
        this.logindetails = new Login(this.email, generateRandomPassword());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Login getLogindetails() {
        return logindetails;
    }

    public String getEtMail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", e-Mail=" + email + ", logindetails=" + logindetails + '}';
    }

    private String generateRandomPassword() {
     String chars = "abcdefghijklmnopqrstuvwxyz";
     String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     String NUMS = "1234567890";
     String SPEC = "@#$%^&+=";
     int index;
    String pass = "";
    Random rnd = new Random();
    
    // 2 random chars from 'chars'
    index = rnd.nextInt(chars.length());
    pass += chars.charAt(index);
    index = rnd.nextInt(chars.length());
    pass += chars.charAt(index);

    // 2 random chars from 'CHARS'
    index = rnd.nextInt(CHARS.length());
    pass += CHARS.charAt(index);
    index = rnd.nextInt(CHARS.length());
    pass += CHARS.charAt(index);

    // 2 random chars from 'NUMS'
    index = rnd.nextInt(NUMS.length());
    pass += NUMS.charAt(index);
    index = rnd.nextInt(NUMS.length());
    pass += NUMS.charAt(index);

    // 2 random chars from 'SPEC'
    index = rnd.nextInt(SPEC.length());
    pass += SPEC.charAt(index);
    index = rnd.nextInt(SPEC.length());
    pass += SPEC.charAt(index);

    return pass;

}

}
