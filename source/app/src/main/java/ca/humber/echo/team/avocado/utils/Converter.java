package ca.humber.echo.team.avocado.utils;

import android.arch.persistence.room.TypeConverter;
import java.util.Date;

/**
 * Class to convert datatypes.
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
