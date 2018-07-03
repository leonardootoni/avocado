package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import ca.humber.echo.team.avocado.database.Entity.AccountSettings;

/**
 * Account Settings DAO
 * @author leonardootoni
 */
@Dao
public interface AccountSettingsDAO {

    @Insert
    void insert(AccountSettings accountSettingsItems);

    @Query("SELECT * FROM ACCOUNT_SETTINGS LIMIT 1")
    LiveData<AccountSettings> getAccountSettings();

    @Update
    void update(AccountSettings accountSettings);

    @Delete
    void delete(AccountSettings accountSettings);
}
