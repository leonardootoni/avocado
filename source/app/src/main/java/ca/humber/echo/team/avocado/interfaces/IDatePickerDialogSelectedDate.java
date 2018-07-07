package ca.humber.echo.team.avocado.interfaces;

import java.util.Date;

/**
 * Default interface to be used in an Activity when it makes use of DatePickerDialogFragment.
 * The Container Activity must implement this interface to receive data from the Fragment
 * author: leonardootoni
 */
public interface IDatePickerDialogSelectedDate {

    void onSelectedDate(Date date);

}
