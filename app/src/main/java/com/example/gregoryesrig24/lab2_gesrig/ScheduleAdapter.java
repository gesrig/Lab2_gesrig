package com.example.gregoryesrig24.lab2_gesrig;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by gregoryesrig24 on 2/8/17.
 */

public class ScheduleAdapter extends ArrayAdapter<String[]> {
    ScheduleAdapter (Context context, ArrayList<String[]> schedule) {
        super(context, R.layout.activity_detail, schedule);
    }
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);

        String[] matchItem = getItem(position);
        TextView teamName = (TextView) scheduleView.findViewById(R.id.TeamName);
        TextView gameDate = (TextView) scheduleView.findViewById(R.id.GameDate);
        teamName.setText(matchItem[1]);
        gameDate.setText(matchItem[2]);

        ImageView teamLogo = (ImageView) scheduleView.findViewById(R.id.teamLogo);
        String mDrawableName = matchItem[0];
        //int resID = getContext().getResources().getIdentifier(mDrawableName, "drawable", getContext().getPackageName());
        int resID = Integer.parseInt(mDrawableName);

        teamLogo.setImageResource(resID);


        return scheduleView;


    }
}
