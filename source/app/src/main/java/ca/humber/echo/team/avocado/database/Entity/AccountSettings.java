package ca.humber.echo.team.avocado.database.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Entity Java Bean class
 * @author leonardootoni
 */
@Entity(tableName = "ACCOUNT_SETTINGS",
        foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id")},
        indices = { @Index(name = "IDX_FK_ACCOUNT_SETTINGS_USER_ID", value = {"user_id"})})
public class AccountSettings {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @NonNull
    @ColumnInfo(name = "user_id")
    private Long userId;

    @NonNull
    @ColumnInfo(name = "alert_budget_percent_limit")
    private Double alertBudgetPercentLimit;

    @ColumnInfo(name = "alert_daily_notifications_limit")
    private Long alertDailyNotifications;

    @ColumnInfo(name = "alert_monthly_notifications_limit")
    private Long alertMonthlyNotifications;


    public AccountSettings(@NonNull Long id, @NonNull Long userId, @NonNull Double alertBudgetPercentLimit, Long alertDailyNotifications, Long alertMonthlyNotifications) {
        this.id = id;
        this.userId = userId;
        this.alertBudgetPercentLimit = alertBudgetPercentLimit;
        this.alertDailyNotifications = alertDailyNotifications;
        this.alertMonthlyNotifications = alertMonthlyNotifications;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    @NonNull
    public Double getAlertBudgetPercentLimit() {
        return alertBudgetPercentLimit;
    }

    public Long getAlertDailyNotifications() {
        return alertDailyNotifications;
    }

    public Long getAlertMonthlyNotifications() {
        return alertMonthlyNotifications;
    }

    @Override
    public String toString() {
        return "AccountSettings{" +
                "id=" + id +
                ", userId=" + userId +
                ", alertBudgetPercentLimit=" + alertBudgetPercentLimit +
                ", alertDailyNotifications=" + alertDailyNotifications +
                ", alertMonthlyNotifications=" + alertMonthlyNotifications +
                '}';
    }
}