package pl.workout.kowalczyk.com.app.model.BO.security;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;
import pl.workout.kowalczyk.com.app.model.BO.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JK on 2016-12-12.
 */
@Entity
@Table(name = "saw_user_details")
public class UserDetails extends AbstractModel{
    private Integer id;
    private String login;
    private String password;
    private Boolean enabled;
    private Set<UserRole> userRoles = new HashSet<>();
//    private User user;

    public UserDetails(String login, String password, Boolean enabled, Set<UserRole> userRoleSet) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.userRoles = userRoleSet;
    }

    public UserDetails() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_details_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userDetails")
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoleSet) {
        this.userRoles = userRoleSet;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

//    public User getUser() {
//        return user;
//    }
//    @OneToOne(mappedBy = "userDetails")
//    public void setUser(User user) {
//        this.user = user;
//    }
}
