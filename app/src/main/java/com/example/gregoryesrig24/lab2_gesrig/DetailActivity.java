package com.example.gregoryesrig24.lab2_gesrig;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.gregoryesrig24.lab2_gesrig.R.layout.activity_detail;

/**
 * Created by gregoryesrig24 on 2/15/17.
 */



public class DetailActivity extends Activity {
    //@Override
   // Bundle gameinfo = this.getIntent().getExtras();
    //String[] matchItem = (String []) gameinfo.getStringArray("gameinfo");
    TextView MatchDate;
    TextView MatchLocation;
    TextView awayTeam;
    TextView awayMascot;
    TextView awayRecord;
    TextView finalScore;
    ImageView teamLogo;
    ImageView NotreDame;



    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_detail);
        String[] matchItem = getIntent().getStringArrayExtra("gameinfo");


        //View activity_detail = activityInflater.inflate(R.layout.activity_detail, parent, false);



        MatchDate = (TextView) findViewById(R.id.MatchDate);
        MatchDate.setText(matchItem[2]);
        MatchLocation = (TextView) findViewById(R.id.MatchLocation);
        MatchLocation.setText(matchItem[4]);
        awayTeam = (TextView) findViewById(R.id.awayTeam);
        awayTeam.setText(matchItem[1]);
        awayMascot = (TextView) findViewById(R.id.awayMascot);
        awayMascot.setText(matchItem[6]);
        awayRecord = (TextView) findViewById(R.id.awayRecord);
        awayRecord.setText(matchItem[5]);
        finalScore = (TextView) findViewById(R.id.FinalScore);
        finalScore.setText(matchItem[3]);
        NotreDame = (ImageView) findViewById(R.id.NotreDame);
        NotreDame.setImageResource(R.drawable.notredamefightingirish);
 /*
        TextView MatchDate = (TextView) activity_detail.findViewById(R.id.MatchDate);
        TextView MatchLocation = (TextView) activity_detail.findViewById(R.id.MatchLocation);
        TextView awayTeam = (TextView) activity_detail.findViewById(R.id.awayTeam);
        TextView awayMascot = (TextView) activity_detail.findViewById(R.id.awayMascot);
        TextView awayRecord = (TextView) activity_detail.findViewById(R.id.awayRecord) ;
        TextView finalScore = (TextView) activity_detail.findViewById(R.id.FinalScore) ;
        MatchDate.setText(matchItem[2]);
        MatchLocation.setText(matchItem[4]);
        awayTeam.setText(matchItem[1]);
        awayMascot.setText(matchItem[6]);
        awayRecord.setText(matchItem[5]);
        finalScore.setText(matchItem[3]);
*/
        ImageView teamLogo = (ImageView) findViewById(R.id.otherTeam);
        String mDrawableName = matchItem[0];
        //int resID = getContext().getResources().getIdentifier(mDrawableName, "drawable", getContext().getPackageName());
        int resID = Integer.parseInt(mDrawableName);

        teamLogo.setImageResource(resID);

        Button btnOk = (Button) findViewById(R.id.CameraButton);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(newIntent);


            }
        };

        btnOk.setOnClickListener(clickListener);





    }



}