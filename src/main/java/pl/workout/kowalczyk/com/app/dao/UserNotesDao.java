package pl.workout.kowalczyk.com.app.dao;

import pl.workout.kowalczyk.com.app.model.BO.UserNotes;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserNotesDao extends BaseDao<UserNotes> {
    List<UserNotes> getUserNotesByUserId(int userId);

    UserNotes getSingleNoteByDate(int userId, Date date);
}