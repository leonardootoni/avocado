package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;

import android.arch.persistence.room.Query;

import ca.humber.echo.team.avocado.database.Entity.User;

/**
 * User's DAO Class
 * @author leonardootoni
 */
@Dao
public interface UserDao extends BaseDao<User> {

    @Query("SELECT * FROM USER LIMIT 1")
    LiveData<User> getUser();

    @Query("SELECT * FROM USER WHERE email=:email")
    LiveData<User> getUserByEmail(String email);

}
