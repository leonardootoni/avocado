package ca.humber.echo.team.avocado.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.humber.echo.team.avocado.R;
import ca.humber.echo.team.avocado.repository.database.AvocadoDataBase;
import ca.humber.echo.team.avocado.repository.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String message = "";
        try{
            User user = AvocadoDataBase.getInstance(this).userDAO().getUserByEmail("leo@leo.com");
            message = user.getLastName();
        }catch(Exception ex){
            message = ex.getMessage();
        }

        int a = 0;

    }

}
