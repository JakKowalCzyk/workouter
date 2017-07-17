package com.kowalczyk.workouter.model.BO.user.impl;

import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.BO.user.AbstractUserObject;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserInfo extends AbstractUserObject {

    private UserWeight actualWeight;

    private Exercise exerciseFavouriteId;

    public UserInfo() {
    }

    @PrePersist
    public void prePersist() {
        getUser().getUserInfoList().add(this);
    }

    @PreRemove
    public void preRemove() {
        if (getUser() != null) {
            getUser().getUserInfoList().remove(this);
        }
    }
    @OneToOne
    @JoinColumn(name = "weight_id")
    public UserWeight getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(UserWeight actualWeight) {
        this.actualWeight = actualWeight;
    }

    @OneToOne
    @JoinColumn(name = "exercise_id")
    public Exercise getExerciseFavouriteId() {
        return exerciseFavouriteId;
    }

    public void setExerciseFavouriteId(Exercise exerciseFavouriteId) {
        this.exerciseFavouriteId = exerciseFavouriteId;
    }


}