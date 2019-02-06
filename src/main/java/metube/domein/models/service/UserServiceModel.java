package metube.domein.models.service;

import java.util.List;

public class UserServiceModel {
    private String id;

    private String username;

    private String email;

    private String password;

    private List<TubeServiceModel> tubes;

    public UserServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TubeServiceModel> getTubes() {
        return this.tubes;
    }

    public void setTubes(List<TubeServiceModel> tubes) {
        this.tubes = tubes;
    }
}
