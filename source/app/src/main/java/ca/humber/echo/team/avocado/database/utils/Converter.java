package ca.humber.echo.team.avocado.database.utils;

import android.arch.persistence.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Generic Data Converter Class to use with Room.
 * @author leonardootoni
 */
public class Converter {

    @TypeConverter
    public static Date fromTextToDate(String date) {

        Date newDate;
        try{
            newDate = DateFormat.getInstance().parse(date);
        } catch (ParseException ex){
            newDate = null;
        }
        return newDate;
    }

    @TypeConverter
    public static String fromDateToText(Date date){
        return date == null ? null : date.toString();
    }

}
