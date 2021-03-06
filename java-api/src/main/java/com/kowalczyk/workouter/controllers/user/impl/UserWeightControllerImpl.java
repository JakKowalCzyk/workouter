package com.kowalczyk.workouter.controllers.user.impl;

import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.controllers.user.UserWeightController;
import com.kowalczyk.workouter.mapper.user.impl.UserWeightMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class UserWeightControllerImpl extends ModelControllerImpl<UserWeight, UserWeightDTO> implements UserWeightController {

    @Autowired
    public UserWeightControllerImpl(UserWeightService modelService, UserWeightMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public UserWeightDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public UserWeightDTO updateObject(@RequestBody UserWeightDTO model) {
        return super.updateObject(model);
    }

    @Override
    public UserWeightDTO addObject(@RequestBody UserWeightDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<UserWeightDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }

    @Override
    public boolean isExist(@PathVariable Long id) {
        return super.isExist(id);
    }

    @Override
    public List<UserWeightDTO> getWeightByUserId(@PathVariable Long id) {
        return ((UserWeightService) getModelService()).getWeightByUserId(id).stream().map(userWeight -> getModelMapper().mapToDTO(userWeight)).collect(Collectors.toList());
    }

    @Override
    public UserWeightDTO getWeightByDate(@PathVariable Long id, @PathVariable Date date) {
        return getModelMapper().mapToDTO(((UserWeightService) getModelService()).getByUserIdAndDate(id, date));
    }

    @Override
    public UserWeightDTO getActualWeight(@PathVariable Long id) {
        return getModelMapper().mapToDTO(((UserWeightService) getModelService()).getActualWeight(id));
    }
}
