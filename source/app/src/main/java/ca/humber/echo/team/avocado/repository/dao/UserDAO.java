package ca.humber.echo.team.avocado.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import ca.humber.echo.team.avocado.repository.model.User;

@Dao
public interface UserDAO {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM USER LIMIT 1")
    User getUser();

    @Query("SELECT * FROM USER WHERE email=:email")
    User getUserByEmail(String email);

}
