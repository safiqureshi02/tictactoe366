package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean iswinner=false;
    int imageClicked = -1;
    int player=1;
    int [][]winningstates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gamestates={-1,-1,-1,-1,-1,-1,-1,-1,-1};
public void load (View view){

        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        imageClicked=gamestates[tag];
    if(iswinner==false && imageClicked==-1) {
        if (player == 1) {
            v.setImageResource(R.drawable.cross);
            gamestates[tag] = player;
            Toast.makeText(this, tag + " " + "cross", Toast.LENGTH_SHORT).show();
            player = 0;
        } else {
            v.setImageResource(R.drawable.zero);
            gamestates[tag] = player;
            Toast.makeText(this, tag + "" + "zero", Toast.LENGTH_SHORT).show();
            player = 1;
        }
        for (int i = 0; i < winningstates.length; i++) {
            if (gamestates[winningstates[i][0]] == gamestates[winningstates[i][1]] && gamestates[winningstates[i][1]] == gamestates[winningstates[i][2]] && gamestates[winningstates[i][0]] > -1)

            {
                Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                iswinner=true;
            }

        }
    }
}
      public void reset(View view){
          androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridlayout);


          int total_images=gridLayout.getChildCount();
          for(int i =0 ;i<total_images;i++){
              ImageView v = (ImageView) gridLayout.getChildAt(i);
              v.setImageDrawable(null);
          }
          iswinner=false;
          imageClicked=-1;
          player=1;
          for(int i = 0;i<gamestates.length;i++){
              gamestates[i]=-1;
          }
      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}