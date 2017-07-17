package com.kowalczyk.workouter.mapper.exercise;

import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.exercise.Workout;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutDTO;
import com.kowalczyk.workouter.services.exercise.UserExerciseService;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class WorkoutMapper extends ModelMapperImpl<Workout, WorkoutDTO> {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserExerciseService userExerciseService;

    @Override
    protected Workout buildBO(WorkoutDTO objectDTO) {
        Workout workout = new Workout();
        workout.setDate(objectDTO.getDate());
        workout.setUser(userDetailsService.getObject(objectDTO.getUserId()));
        if (objectDTO.getUserExercises() != null) {
            workout.setUserExercises(objectDTO.getUserExercises().stream().map(aLong -> userExerciseService.getObject(aLong)).collect(Collectors.toList()));
        }
        return workout;
    }

    @Override
    protected WorkoutDTO buildDTO(Workout modelObject) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setDate(modelObject.getDate());
        workoutDTO.setUserId(modelObject.getUser().getId());
        workoutDTO.setUserExercises(modelObject.getUserExercises().stream().map(ModelObject::getId).collect(Collectors.toList()));
        return workoutDTO;
    }
}