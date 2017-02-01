package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.security.UserDetailsDao;
import pl.workout.kowalczyk.com.app.dao.user.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Autowired
    private UserWeightService userWeightService;

    @Autowired
    private ExerciseService exerciseService;

    @Override
    public UserInfoDTO mapUserInfoBoToDto(UserInfo userInfo) {
        return new UserInfoDTO(userInfo.getId(), userInfo.getUserId().getId(), userInfo.getActualWeight().getId(), userInfo.getExerciseFavouriteId().getId());
    }

    @Override
    public UserInfo mapUserInfoDtoToBo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo(userInfoDTO.getId());
        userInfo.setUserId(userDetailsDao.findOne(userInfoDTO.getUserId()));
        userInfo.setExerciseFavouriteId(exerciseService.getExerciseById(userInfoDTO.getFavouriteExerciseId()));
        userInfo.setActualWeight(userWeightService.getUserWeightById(userInfoDTO.getActualWeightId()));
        return userInfo;
    }

    public void saveUserInfo(UserInfoDTO userInfoDTO) {
        userInfoDao.save(mapUserInfoDtoToBo(userInfoDTO));
    }


    public UserInfoDTO getUserInfoDTOByUserId(int userId) {
        return mapUserInfoBoToDto(userInfoDao.getUserInfoByUserId(userId));
    }

    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }


    @Override
    public void updateUserInfoWithUserWeight(UserWeight userWeight) {
        userInfoDao.updateUserWeight(userWeight.getUserId().getId(), userWeight);
    }
}
