package ca.humber.echo.team.avocado.database.utils;

import android.arch.persistence.room.TypeConverter;
import java.util.Date;

/**
 * Generic Data Converter Class to use with Room.
 * @author leonardootoni
 */
public class Converter {

    @TypeConverter
    public static Date fromTextToDate(String date){
        return date == null ? null : new Date(date);
    }

    @TypeConverter
    public static String fromDateToText(Date date){
        return date == null ? null : date.toString();
    }

}
