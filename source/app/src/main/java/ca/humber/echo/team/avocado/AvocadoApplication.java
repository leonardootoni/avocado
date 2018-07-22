package ca.humber.echo.team.avocado;

import android.app.Application;
import android.content.Context;

/**
 * Context Application to be accessed through all project.
 * @author leonardootoni
 */
public class AvocadoApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        AvocadoApplication.context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }


}
