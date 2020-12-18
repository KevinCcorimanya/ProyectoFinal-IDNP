package com.example.laboratorio6.fragemtns;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.laboratorio6.R;


public class TrainingFragment extends FragmentActivity {
    Button play_pause;
    MediaStore.Audio.Media mp;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        play_pause=(Button)findViewById(R.id.play_pause);
        mp= MediaPlayer.create(this,R.raw.musica);
        play_pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if(mp.isPlaying()){
                    mp.pause();
                    play_pause.setBackgroundResource(R.drawable.play);
                    toast.makeText(TrainingFragment.this,"Pausa",Toast.LENGTH_SHORT.show());
                }
                else{
                    mp.start();
                    play_pause.setBackgroundResource(R.drawable.pausar);
                    toast.makeText(TrainingFragment.this,"Play",Toast.LENGTH_SHORT.show());
                }
            }
        });
    }

}