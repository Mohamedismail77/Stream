package com.example.mohamed.stream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<ChannelDetails> channels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ChannelDetails channel_1 = new ChannelDetails();
        ChannelDetails channel_2 = new ChannelDetails();
        ChannelDetails channel_3 = new ChannelDetails();

        channel_1.setmTitle("Apple TV");
        channel_1.setmChannelLink("http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8");

        channel_2.setmTitle("Big Buck Bunny");
        channel_2.setmChannelLink("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");

        channel_3.setmTitle("Cyber Tech Media");
        channel_3.setmChannelLink("http://www.cybertechmedia.com/samples/raycharles.wmv");

        channels.add(channel_1);
        channels.add(channel_2);
        channels.add(channel_3);

        ListAdapter adapter = new ListAdapter(this,R.layout.channel_list,channels);
        ListView mListView = (ListView) findViewById(R.id.channel_list);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, PlayerActiviy.class);
                intent.putExtra("details", channels);
                intent.putExtra("index", i);
                startActivity(intent);

            }
        });


        mListView.setAdapter(adapter);




    }
}
