package BismaAlifAlghifariJSleepMN;

import java.util.regex.*;

public class Account extends Serializable  {
    public String name;
    public String email;
    public String password;

    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z.]+\\.[a-zA-Z]+?$";

    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public Account (String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString(){
        return "Id : " + id +
                "\nName : " + name +
                "\nEmail : " + email +
                "\nPassword : " + password + "\n\n";
    }

    public boolean validate(){
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(email);
        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        return emailMatcher.find() && passwordMatcher.find();
    }

}



