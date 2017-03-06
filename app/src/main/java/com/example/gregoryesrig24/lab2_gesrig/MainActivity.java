package com.example.gregoryesrig24.lab2_gesrig;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.gregoryesrig24.lab2_gesrig.R.id.FinalScore;
import static com.example.gregoryesrig24.lab2_gesrig.R.id.scheduleListView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // String[] teamnames = {"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech","North Virginia", "Chicago Sate"};
        //String[] gamedates = {"Feb.11", "Feb. 14th", "Feb. 18th", "Feb 26th", "March. 1", "March 4th", "March 7th", "March 16th"};

//        String[] OSU = {Integer.toString(R.drawable.osubuckeys), "Ohio State", "Feb. 11", "82-86", "American Airlines Center, Columbus OH", "10-10", "Buckeyes"};
//        String[] FSU = {Integer.toString(R.drawable.fsuseminoles), "Florida State", "Feb. 14th", "69-68", "Thunder Dome, Tallahasse FL", "10-10", "seminoles"};
//        String[] WF = {Integer.toString(R.drawable.wakeforest),"Wake Forest", "Feb. 18th", "75-67", "Pauley Pavilion, Durham NC", "10-10", "Devils"};
//        String[] BC = {Integer.toString(R.drawable.bostcollege), "Boston College", "Feb. 26th", "88-87 OT", "Patriots Stadium, Bostom MA", "10-10", "Eagles"};
//        String[] NCSU = {Integer.toString(R.drawable.ncstate), "NCSU" , "March 1st", "76-59", "North Carolina Pavilion, Charlottesvile NC", "10-10", "Yellow Jackets"};
//        String[] GT = {Integer.toString(R.drawable.gtech), "Georgia Tech", "March 4th", "88-79", "Purcell Pavilion, IN", "10-10", "Yellow Jackets"};
//        String[] NV = {Integer.toString(R.drawable.nova), "NOVO", "March 7th", "54-88", "Community Center Church, Washington DC", "10-10", "Wolverines"};
//        String[] CSU = {Integer.toString(R.drawable.chicagostate), "Chicago State", "March 16th", "69-0", "This isn't a real school", "10-10", "Dragons"};

          //final ArrayList<Team> gameinfo = new ArrayList<Team>();
//        Team team1 = new Team(new String[]{"osubuckeys", "Ohio State", "Feb. 11", "82-86", "American Airlines Center, Columbus OH", "10-10", "Buckeyes"});
//        Team team2 = new Team(new String[] {"fsuseminoles", "Florida State", "Feb. 14th", "69-68", "Thunder Dome, Tallahasse FL", "10-10", "seminoles"});
//        Team team3 = new Team(new String [] {"wakeforest","Wake Forest", "Feb. 18th", "75-67", "Pauley Pavilion, Durham NC", "10-10", "Devils"});
//        Team team4 = new Team(new String [] {"bostcollege", "Boston College", "Feb. 26th", "88-87 OT", "Patriots Stadium, Bostom MA", "10-10", "Eagles"});
//        Team team5 = new Team(new String[] {"ncstate", "NCSU" , "March 1st", "76-59", "North Carolina Pavilion, Charlottesvile NC", "10-10", "Yellow Jackets"});
//        Team team6 = new Team(new String [] {"gtech", "Georgia Tech", "March 4th", "88-79", "Purcell Pavilion, IN", "10-10", "Yellow Jackets"});
//        Team team7 = new Team(new String [] {"nova", "NOVO", "March 7th", "54-88", "Community Center Church, Washington DC", "10-10", "Wolverines"});
//        Team team8 = new Team(new String [] {"chicagostate", "Chicago State", "March 16th", "69-0", "This isn't a real school", "10-10", "Dragons"});
//        gameinfo.add(team1);
//        gameinfo.add(team2);
//        gameinfo.add(team3);
//        gameinfo.add(team4);
//        gameinfo.add(team5);
//        gameinfo.add(team6);
//        gameinfo.add(team7);
//        gameinfo.add(team8);

//Integer.toString(R.drawable.chicagostate)

        MyCsvFileReader reader = new MyCsvFileReader(getApplicationContext());
        final ArrayList<Team> gameinfo = reader.readCsvFile(R.raw.schedule);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, gameinfo);
        final ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(scheduleAdapter);



        ListView.OnItemClickListener clickListener = new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this , DetailActivity.class);
                Bundle bundle = new Bundle();
                Team objects = gameinfo.get(position);
                bundle.putSerializable("gameinfo", objects);
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, DetailActivity.class);
                startActivity(intent);

            }
        };


        scheduleListView.setOnItemClickListener(clickListener);



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
