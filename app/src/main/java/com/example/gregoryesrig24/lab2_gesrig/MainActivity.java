package com.example.gregoryesrig24.lab2_gesrig;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
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
import java.util.List;

import static com.example.gregoryesrig24.lab2_gesrig.R.id.FinalScore;
import static com.example.gregoryesrig24.lab2_gesrig.R.id.scheduleListView;
import static com.example.gregoryesrig24.lab2_gesrig.R.id.settings;
import static com.example.gregoryesrig24.lab2_gesrig.R.id.toolbar;
import static com.example.gregoryesrig24.lab2_gesrig.R.menu.floating_contexual_menu;


public class MainActivity extends AppCompatActivity {

    public String gameSchedule(ArrayList<Team> schedule) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < schedule.size(); i++) {
                sb.append(schedule.get(i).getTeamName());
                sb.append(" on ");
                sb.append(schedule.get(i).getGameDate());
            }
            String finalstring = sb.toString();

            return finalstring;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar actionBarToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(actionBarToolbar);


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
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_contexual_menu, menu);

    }

    @Override

    public boolean onContextItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.wbb) {
            return true;
// to be implemented later
        }
        else if (item_id== R.id.mbb) {
            return true;
        }
        else if (item_id ==R.id.offcamp) {
            return true;
        }
        else if (item_id==R.id.oncamp) {
            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.share) {
// code for sharing the schedule
            MyCsvFileReader reader = new MyCsvFileReader(getApplicationContext());
            final ArrayList<Team> gameinfo = reader.readCsvFile(R.raw.schedule);


            Intent shareIntent = new Intent();
            shareIntent.setAction(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra("android.content.Intent.EXTRA_SUBJECT", "BasketBall Matches");
            shareIntent.putExtra("android.content.Intent.EXTRA_TEXT", gameSchedule(gameinfo));
            //startActivity(Intent.createChooser(shareIntent), "Share via");
        }

        else if (res_id == R.id.sync) {
// Snackbar with Try Again action
            final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Sync is not yet implemented", Snackbar.LENGTH_LONG);
            snackbar.setAction("Try Again", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(coordinatorLayout, "Wait for the next few labs. Thank you for your patience", Snackbar.LENGTH_LONG).show();
                }
            });
            snackbar.show();
        }


        else if (res_id == settings) {

            registerForContextMenu(((View) findViewById(R.id.settings)));
            openContextMenu(((View) findViewById(R.id.settings)));
            unregisterForContextMenu(((View) findViewById(R.id.settings)));


        }
        return true;
    }
}
