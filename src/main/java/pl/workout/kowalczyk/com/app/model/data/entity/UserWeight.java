package pl.workout.kowalczyk.com.app.model.data.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userWeight")
public class UserWeight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uweight_id;

    @ManyToOne
    private User user_id;

    private int weight_kg;

    private Date data;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserInfo userInfo_id;

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public int getUweight_id() {
        return uweight_id;
    }

    public void setUweight_id(int uweight_id) {
        this.uweight_id = uweight_id;
    }

    public int getWeight_kg() {
        return weight_kg;
    }

    public void setWeight_kg(int weight_kg) {
        this.weight_kg = weight_kg;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date date) {
        this.data = date;
    }

    public UserInfo getUserInfo_id() {
        return userInfo_id;
    }

    public void setUserInfo_id(UserInfo userInfo_id) {
        this.userInfo_id = userInfo_id;
    }
}