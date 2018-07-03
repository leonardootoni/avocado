package ca.humber.echo.team.avocado.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.humber.echo.team.avocado.R;
import ca.humber.echo.team.avocado.database.AppDataBase;
import ca.humber.echo.team.avocado.database.Entity.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
