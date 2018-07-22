package ca.humber.echo.team.avocado.database.pojos;


import android.util.Log;

import java.text.DecimalFormat;

/**
 * Auxiliar POJO used to fetch the total expense for a give category and compare this total
 * to the budget limit.
 * @author leonardootoni
 */
public class TotalExpensesByBudget {

    private Double totalExpenses;
    private Double totalBudget;
    private Double percentLimit;
    private Double percentAchieved;
    private String categoryName;

    public TotalExpensesByBudget(Double totalExpenses, Double totalBudget, Double percentLimit,
                                 Double percentAchieved, String categoryName){

        this.totalExpenses = totalExpenses;
        this.totalBudget = totalBudget;
        this.percentLimit = percentLimit;
        this.percentAchieved = percentAchieved;
        this.categoryName = categoryName;

    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public Double getTotalBudget() {
        return totalBudget;
    }

    public Double getPercentLimit() {
        return percentLimit;
    }

    public Double getPercentAchieved() {
        return percentAchieved;
    }

    public String getCategoryName() { return categoryName; }

    public boolean isBustedBudget() {
        return percentAchieved == null ? false : (percentAchieved > 100);
    }

    public boolean isBudgetInAlertRange(){
        return percentAchieved == null || percentLimit == null ? false :
                (percentAchieved > percentLimit);
    }

    public String getPercentAchievedToString(){

        if(percentAchieved != null){

            try{
                DecimalFormat df = new DecimalFormat("#,###.00");
                return df.format(percentAchieved) + "%";
            }catch(NumberFormatException e){
                Log.d("NumberFormat Exception", e.getMessage());
            }


        }

        return "";
    }

    public String getTotalBudgetToString(){

        if(totalBudget != null){

            try{
                DecimalFormat df = new DecimalFormat("$#,###.00");
                return df.format(totalBudget);
            }catch (NumberFormatException e){
                Log.d("NumberFormat Exception", e.getMessage());
            }
        }

        return "";
    }

    public String getTotalExpensesToString(){

        if(totalExpenses != null){

            try{
                DecimalFormat df = new DecimalFormat("$#,###.00");
                return df.format(totalExpenses);
            }catch (NumberFormatException e){
                Log.d("NumberFormat Exception", e.getMessage());
            }
        }

        return "";
    }

}
