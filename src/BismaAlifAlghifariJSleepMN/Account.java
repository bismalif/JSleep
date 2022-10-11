package BismaAlifAlghifariJSleepMN;


public class Account extends Serializable implements FileParser {
    public String name;
    public String email;
    public String password;

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

    @Override
    public Object write() {
        return null;
    }

    public boolean read(String content) {
        return false;
    }
}



