package ca.humber.echo.team.avocado.Entities;

/**
 * Entity Java Bean class
 */
public class AccountSettings {

    private Long userId;
    private Double alertBudgetPercentLimit;
    private Long alertDailyNotifications;
    private Long alertMonthlyNotifications;

    public AccountSettings(Long userId, Double alertBudgetPercentLimit, Long alertDailyNotifications, Long alertMonthlyNotifications) {
        this.userId = userId;
        this.alertBudgetPercentLimit = alertBudgetPercentLimit;
        this.alertDailyNotifications = alertDailyNotifications;
        this.alertMonthlyNotifications = alertMonthlyNotifications;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAlertBudgetPercentLimit() {
        return alertBudgetPercentLimit;
    }

    public void setAlertBudgetPercentLimit(Double alertBudgetPercentLimit) {
        this.alertBudgetPercentLimit = alertBudgetPercentLimit;
    }

    public Long getAlertDailyNotifications() {
        return alertDailyNotifications;
    }

    public void setAlertDailyNotifications(Long alertDailyNotifications) {
        this.alertDailyNotifications = alertDailyNotifications;
    }

    public Long getAlertMonthlyNotifications() {
        return alertMonthlyNotifications;
    }

    public void setAlertMonthlyNotifications(Long alertMonthlyNotifications) {
        this.alertMonthlyNotifications = alertMonthlyNotifications;
    }
}
