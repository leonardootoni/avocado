package ca.humber.echo.team.avocado.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import ca.humber.echo.team.avocado.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_all_expenses:
                    mTextMessage.setText(R.string.main_menu_expenses);
                    return true;
                case R.id.navigation_goals:
                    mTextMessage.setText(R.string.main_menu_goals);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.main_menu_dashboard);
                    Intent intent = new Intent(getApplicationContext(), ExpenseEntryActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.main_menu_notifications);
                    return true;
                case R.id.navigation_reports:
                    mTextMessage.setText(R.string.main_menu_reports);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
