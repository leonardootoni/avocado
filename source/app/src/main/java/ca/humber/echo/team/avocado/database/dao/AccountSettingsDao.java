package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;



import ca.humber.echo.team.avocado.database.Entity.AccountSettings;

/**
 * Account Settings DAO
 * @author leonardootoni
 */
@Dao
public interface AccountSettingsDao extends BaseDao<AccountSettings> {

    @Query("SELECT * FROM ACCOUNT_SETTINGS LIMIT 1")
    LiveData<AccountSettings> getAccountSettings();

}
