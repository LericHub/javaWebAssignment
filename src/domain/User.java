package domain;

public class User {
    private int id ;
    private String username;
    private String password;
    private int age;
    private String gender;
    private String birthplace;
    private String qq;
    private String mail;

    public User(String username, String password, int age, String gender, String birthplace, String qq, String mail) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.birthplace = birthplace;
        this.qq = qq;
        this.mail = mail;
    }

    public User(int id,String username, String password, int age, String gender, String birthplace, String qq, String mail) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.birthplace = birthplace;
        this.qq = qq;
        this.mail = mail;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", qq='" + qq + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

