package ca.humber.echo.team.avocado.database.utils;

import android.arch.persistence.room.TypeConverter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Generic Data Converter Class to use with Room.
 * @author leonardootoni
 */
public class Converter {

    @TypeConverter
    public static Date fromTextToDate(String date) {

        Date newDate;
        try {
            newDate = DateFormat.getInstance().parse(date);
        } catch (ParseException ex){
            newDate = null;
        }
        return newDate;
    }

    @TypeConverter
    public static String fromDateToText(Date date){

        if(date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            return sdf.format(date);
        } else {
            return null;
        }

    }

}
