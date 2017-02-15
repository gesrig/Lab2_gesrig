package com.example.gregoryesrig24.lab2_gesrig;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // String[] teamnames = {"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech","North Virginia", "Chicago Sate"};
        //String[] gamedates = {"Feb.11", "Feb. 14th", "Feb. 18th", "Feb 26th", "March. 1", "March 4th", "March 7th", "March 16th"};

        String[] OSU = {Integer.toString(R.drawable.osubuckeys), "Ohio State", "Feb. 11"};
        String[] FSU = {Integer.toString(R.drawable.fsuseminoles), "Florida State", "Feb. 14th"};
        String[] WF = {Integer.toString(R.drawable.wakeforest),"Wake Forest", "Feb. 18th"};
        String[] BC = {Integer.toString(R.drawable.bostcollege), "Boston College", "Feb. 26th"};
        String[] NCSU = {Integer.toString(R.drawable.ncstate), "NCSU" , "March 1st"};
        String[] GT = {Integer.toString(R.drawable.gtech), "Georgia Tech", "March 4th"};
        String[] NV = {Integer.toString(R.drawable.nova), "NOVO", "March 7th"};
        String[] CSU = {Integer.toString(R.drawable.chicagostate), "Chicago State", "March 16th"};

        ArrayList gameinfo = new ArrayList();
        gameinfo.add(OSU);
        gameinfo.add(FSU);
        gameinfo.add(WF);
        gameinfo.add(BC);
        gameinfo.add(NCSU);
        gameinfo.add(GT);
        gameinfo.add(NV);
        gameinfo.add(CSU);




        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, gameinfo);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(scheduleAdapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
