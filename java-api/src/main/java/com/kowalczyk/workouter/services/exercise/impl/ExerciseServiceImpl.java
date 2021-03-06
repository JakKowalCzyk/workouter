package com.kowalczyk.workouter.services.exercise.impl;

import com.kowalczyk.workouter.dao.exercise.ExerciseDAO;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.exception.DeleteException;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class ExerciseServiceImpl extends ModelServiceImpl<Exercise> implements ExerciseService {

    @Autowired
    public ExerciseServiceImpl(ExerciseDAO baseDao) {
        super(baseDao);
    }

    public List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType) {
        return ((ExerciseDAO) getBaseDAO()).getExercisesForBodyPart(exerciseType);
    }

    @Override
    public List<Exercise> searchExercise(String tag) {
        return ((ExerciseDAO) getBaseDAO()).findByNameContainingIgnoreCase(tag.toLowerCase());
    }

    @Override
    public void deleteObject(Long id) {
        try {
            super.deleteObject(id);
        } catch (Exception e) {
            throw new DeleteException(id);
        }
    }
}
