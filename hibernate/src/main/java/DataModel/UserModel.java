package DataModel;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    public UserModel()
    {

    }
    public UserModel(String firstName, String lastName, String username, String email)
    {
        this.fname = firstName;
        this.lname = lastName;
        this.username = username;
        this.email = email;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", username="+username+", email=" + email + "]";
    }
}
