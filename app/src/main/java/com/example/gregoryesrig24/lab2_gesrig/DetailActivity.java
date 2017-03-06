package com.example.gregoryesrig24.lab2_gesrig;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        bundle = getIntent().getExtras();
        Team matchItem = (Team) bundle.getSerializable("gameinfo");


//        setContentView(R.layout.activity_detail);
//        Team matchItem = getIntent().getStringArrayExtra("gameinfo");


        //View activity_detail = activityInflater.inflate(R.layout.activity_detail, parent, false);



        MatchDate = (TextView) findViewById(R.id.MatchDate);
        MatchDate.setText(matchItem.getGameDate());
        MatchLocation = (TextView) findViewById(R.id.MatchLocation);
        MatchLocation.setText(matchItem.getTeamArena());
        awayTeam = (TextView) findViewById(R.id.awayTeam);
        awayTeam.setText(matchItem.getTeamName());
        awayMascot = (TextView) findViewById(R.id.awayMascot);
        awayMascot.setText(matchItem.getTeamMascot());
        awayRecord = (TextView) findViewById(R.id.awayRecord);
        awayRecord.setText(matchItem.getTeamRecord());
        finalScore = (TextView) findViewById(R.id.FinalScore);
        finalScore.setText(matchItem.getGameScore());
        NotreDame = (ImageView) findViewById(R.id.NotreDame);
        NotreDame.setImageResource(R.drawable.notredamefightingirish);

        ImageView teamLogo = (ImageView) findViewById(R.id.otherTeam);
        //String mDrawableName = matchItem.getTeamLogo();
        String mDrawableName = matchItem.getTeamLogo();
        Log.d("MyActivity", mDrawableName);
        int resID = getApplicationContext().getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
        //int resID = Integer.parseInt(mDrawableName);

        teamLogo.setImageResource(resID);

        final Button btnOk = (Button) findViewById(R.id.CameraButton);
        final View.OnClickListener clickListener = new View.OnClickListener() {
            static final int CAMERA_REQUEST = 1;

            @Override
            public void onClick(View v) {


                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
                File PictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureName = getPictureName();
                File imageFile = new File(PictureDirectory, pictureName);
                Uri pictureUri = Uri.fromFile(imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            };

            private String getPictureName() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String timestamp = sdf.format(new Date());
                return "BestMoments" + timestamp + ".jpg";
            }

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (resultCode == RESULT_OK) {
                    if (requestCode == CAMERA_REQUEST) {
                        Intent photoGalleryIntent = new Intent(Intent.ACTION_PICK);
                        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                        photoGalleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                        String pictureDirectoryPath = pictureDirectory.getPath();

                        Uri imageUri = Uri.parse(pictureDirectoryPath);

                        InputStream inputStream;
                        try {
                            inputStream = getContentResolver().openInputStream(imageUri);

                            Bitmap image = BitmapFactory.decodeStream(inputStream);
                            ImageView takenPhoto = (ImageView) findViewById(R.id.takenPhoto);
                            takenPhoto.setImageBitmap(image);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }


                    }
                }

            }
            };
        btnOk.setOnClickListener(clickListener);
        //btnOk.onActivityResult()


        }







}



