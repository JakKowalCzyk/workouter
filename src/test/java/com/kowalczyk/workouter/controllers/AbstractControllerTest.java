package com.kowalczyk.workouter.controllers;

import com.kowalczyk.workouter.AbstractTestHelper;
import com.kowalczyk.workouter.controllers.security.RoleController;
import com.kowalczyk.workouter.controllers.user.UserDetailsController;
import com.kowalczyk.workouter.controllers.user.UserInfoController;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNoteDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import com.kowalczyk.workouter.services.user.UserInfoService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;

/**
 * Created by JK on 2017-02-01.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractControllerTest extends AbstractTestHelper {

    protected Long userDetailsId1;
    protected Long userDetailsId2;
    @Autowired
    protected UserDetailsController userDetailsController;
    @Autowired
    protected UserInfoController userInfoController;
    @Autowired
    protected RoleController roleController;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Before
    public void setUp() throws Exception {
        roleController.addObject(buildRoleDTOTest(RoleType.USER));
        addUserDetailsUserInfo1();
        addUserDetailsUserInfo2();
    }

    @After
    public void tearDown() throws Exception {
        List<UserDetailsDTO> userDetailsDTOS = userDetailsController.findAll();
        new ArrayList<>(userDetailsDTOS).forEach(userDetailsDTO -> {
            userDetailsController.deleteObject(userDetailsDTO.getId());
            assertFalse(userDetailsController.isExist(userDetailsDTO.getId()));
        });
        List<RoleDTO> roleDTOS = roleController.findAll();
        new ArrayList<>(roleDTOS).forEach(roleDTO -> {
            roleController.deleteObject(roleDTO.getId());
            assertFalse(roleController.isExist(roleDTO.getId()));
        });
        userDetailsId1 = null;
        userDetailsId2 = null;
    }

    private void addUserDetailsUserInfo1() {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest("log1", "n1", "la1");
        userDetailsDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDetailsDTO = userDetailsController.addObject(userDetailsDTO);
        userDetailsId1 = userDetailsDTO.getId();
    }

    private void addUserDetailsUserInfo2() {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest("log2", "n2", "la2");
        userDetailsDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDetailsDTO = userDetailsController.addObject(userDetailsDTO);
        userDetailsId2 = userDetailsDTO.getId();
    }

    protected UserInfoDTO getUserInfoDTO(Long userId) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(userId);
        return userInfoDTO;
    }

    protected UserWeightDTO getUserWeightDTOTest(int weight, GregorianCalendar date) {
        UserWeightDTO userWeightDTO = new UserWeightDTO();
        userWeightDTO.setDate(date.getTime());
        userWeightDTO.setWeightKg(weight);
        userWeightDTO.setUserId(userDetailsId1);
        return userWeightDTO;
    }

    protected UserNoteDTO createUserNotesTest(Date date, String note, Long userDetailsId) {
        UserNoteDTO userNoteDTO = new UserNoteDTO();
        userNoteDTO.setDate(date);
        userNoteDTO.setNote(note);
        userNoteDTO.setUserId(userDetailsId);
        return userNoteDTO;
    }

    protected ExerciseDTO createExerciseDTOTest(String name, String description, ExerciseType exerciseType) {
        ExerciseDTO exerciseDTO = new ExerciseDTO();
        exerciseDTO.setName(name);
        exerciseDTO.setDescription(description);
        exerciseDTO.setExerciseType(exerciseType);
        return exerciseDTO;
    }

    protected WorkoutDTO createWorkoutDTOTest(Date date, Long userId) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setDate(date);
        workoutDTO.setUserId(userId);
        return workoutDTO;
    }

    protected WorkoutExerciseDTO createWorkoutExerciseDTOTest(WorkoutDTO workoutDTO, ExerciseDTO exerciseDTO, int repeat, int series) {
        WorkoutExerciseDTO workoutExerciseDTO = new WorkoutExerciseDTO();
        workoutExerciseDTO.setWorkoutId(workoutDTO.getId());
        workoutExerciseDTO.setExerciseId(exerciseDTO.getId());
        workoutExerciseDTO.setRepeat(repeat);
        workoutExerciseDTO.setSeries(series);
        return workoutExerciseDTO;
    }
}