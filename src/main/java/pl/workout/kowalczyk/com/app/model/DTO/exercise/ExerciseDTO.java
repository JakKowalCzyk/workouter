package pl.workout.kowalczyk.com.app.model.DTO.exercise;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

/**
 * Created by JK on 2016-11-18.
 */
public class ExerciseDTO extends BaseModel {

    private String name;

    private String description;

    private ExerciseType exerciseType;


    public ExerciseDTO() {
    }

    public ExerciseDTO(Integer exercise_id, String name, String description, ExerciseType exerciseType) {
        super(exercise_id);
        this.name = name;
        this.description = description;
        this.exerciseType = exerciseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

}
