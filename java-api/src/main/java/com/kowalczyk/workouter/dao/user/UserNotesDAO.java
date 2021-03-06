package com.kowalczyk.workouter.dao.user;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.model.BO.user.impl.UserNote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserNotesDAO extends BaseDAO<UserNote> {

    @Query("SELECT o FROM UserNote o  join o.user as userid where userid.id = :userId")
    List<UserNote> getUserNotesByUserId(@Param("userId") Long userId);

    @Query("SELECT o FROM UserNote o join o.user as userid where userid.id = :userId and o.date = :date")
    List<UserNote> getSingleNoteByDate(@Param("userId") Long userId, @Param("date") Date date);
}
