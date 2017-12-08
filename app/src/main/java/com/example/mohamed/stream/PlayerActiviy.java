package com.example.mohamed.stream;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.VideoView;

import java.util.ArrayList;

public class PlayerActiviy extends AppCompatActivity {

    private ArrayList<ChannelDetails> mChannels ;
    private int  index ;

    public VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activiy);

        mChannels = new ArrayList<>();

        mChannels = this.getIntent().getParcelableArrayListExtra("details");
        index = this.getIntent().getIntExtra("index",0);

         mVideoView = (VideoView) findViewById(R.id.video_player);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        android.widget.RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) mVideoView.getLayoutParams();
        params.width =  metrics.widthPixels;
        params.height = metrics.heightPixels;
        params.leftMargin = 0;
        mVideoView.setLayoutParams(params);

        mVideoView.setVideoURI(Uri.parse(mChannels.get(index).getmChannelLink()));
        mVideoView.start();
    }

    public void Previous(View view) {
        index = index - 1;
        if(index < 0 ) {
            index = mChannels.size() - 1;
        }

        mVideoView.setVideoURI(Uri.parse(mChannels.get(index).getmChannelLink()));
        mVideoView.start();
    }

    public void Next(View view) {
        index = index + 1;
        if(index >= mChannels.size()) {
            index = 0;
        }
        mVideoView.setVideoURI(Uri.parse(mChannels.get(index).getmChannelLink()));
        mVideoView.start();

    }
}
