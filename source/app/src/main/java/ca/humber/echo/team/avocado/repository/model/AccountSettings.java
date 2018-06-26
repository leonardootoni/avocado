package ca.humber.echo.team.avocado.repository.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Entity Java Bean class
 */
@Entity(tableName = "ACCOUNT_SETTINGS",
        foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id")},
        indices = { @Index(name = "IDX_FK_ACCOUNT_SETTINGS_USER_ID", value = {"user_id"})})
public class AccountSettings {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @NonNull
    @ColumnInfo(name = "user_id")
    private long userId;

    @NonNull
    @ColumnInfo(name = "alert_budget_percent_limit")
    private double alertBudgetPercentLimit;

    @ColumnInfo(name = "alert_daily_notifications_limit")
    private long alertDailyNotifications;

    @ColumnInfo(name = "alert_monthly_notifications_limit")
    private long alertMonthlyNotifications;


    public AccountSettings(@NonNull long id, @NonNull long userId, @NonNull double alertBudgetPercentLimit, long alertDailyNotifications, long alertMonthlyNotifications) {
        this.id = id;
        this.userId = userId;
        this.alertBudgetPercentLimit = alertBudgetPercentLimit;
        this.alertDailyNotifications = alertDailyNotifications;
        this.alertMonthlyNotifications = alertMonthlyNotifications;
    }

    @NonNull
    public long getId() {
        return id;
    }

    @NonNull
    public long getUserId() {
        return userId;
    }

    @NonNull
    public double getAlertBudgetPercentLimit() {
        return alertBudgetPercentLimit;
    }

    public long getAlertDailyNotifications() {
        return alertDailyNotifications;
    }

    public long getAlertMonthlyNotifications() {
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