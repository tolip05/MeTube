package metube.domein.enteties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Table()
public class User extends BaseEntity{
    private String username;

    private String email;

    private String password;

    private List<Tube> tubes;

    public User() {
    }


    @Column(name = "username",nullable = false,unique = true)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email",nullable = false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(targetEntity = Tube.class,mappedBy = "uploader")
    public List<Tube> getTubes() {
        return this.tubes;
    }

    public void setTubes(List<Tube> tubes) {
        this.tubes = tubes;
    }
}
