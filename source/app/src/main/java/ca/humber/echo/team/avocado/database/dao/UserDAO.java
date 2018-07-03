package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import ca.humber.echo.team.avocado.database.Entity.User;

/**
 * User's DAO Class
 * @author leonardootoni
 */
@Dao
public interface UserDAO {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM USER LIMIT 1")
    LiveData<User> getUser();

    @Query("SELECT * FROM USER WHERE email=:email")
    LiveData<User> getUserByEmail(String email);

}
