public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_email() {
        return email;
    }

    public void set_email(String email) {
        this.email = email;
    }

    public String get_password() {
        return password;
    }

    public void set_password(String password) {
        this.password = password;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}
