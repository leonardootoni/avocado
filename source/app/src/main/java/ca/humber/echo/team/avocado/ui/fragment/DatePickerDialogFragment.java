package ca.humber.echo.team.avocado.ui.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import ca.humber.echo.team.avocado.interfaces.IDatePickerDialogSelectedDate;

/**
 * Reusable DatePicker fragment that shows a modal dialog to pick a date.
 * An client Activity must implement the local interface
 */
public class DatePickerDialogFragment extends DialogFragment {

    IDatePickerDialogSelectedDate mListener;

    /**
     * Method that checks if a caller Activity implements the local interface. Otherwise, throws an
     * exception.
     * @param context - The application Context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (IDatePickerDialogSelectedDate) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnDatePickerDialogSelectecDate");
        }
    }


    /**
     * Sets the default date to be exhibit when the dialog box is instantiated.
     * @param savedInstanceState - the bundle object from the ancestor class
     * @return - a dialog box with the current date set.
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }


    /***
     * Method the intercepts the event onDateSet and call the interface method. This way, the
     * Activity the implementation is invoked and the Date object is passed from the fragment.
     */
    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int month, int day) {

                Calendar cal = Calendar.getInstance();
                cal.set(year, month, day);
                Date dt = cal.getTime();

                mListener.onSelectedDate(dt);
            }
    };

}
