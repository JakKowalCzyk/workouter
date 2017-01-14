package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

import java.sql.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserWeightDTO extends BaseModel {

    private Integer userId;

    private Integer weightKg;

    private Date date;

    public UserWeightDTO() {
    }

    public UserWeightDTO(Integer weight_id, Integer user_id, Integer weight_kg, Date date) {
        super(weight_id);
        this.userId = user_id;
        this.weightKg = weight_kg;
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
