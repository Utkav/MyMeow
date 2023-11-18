package com.example.mymeow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymeow.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    final static String KEY = "key1";
    final static String REQUESTCODE = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.A2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(KEY, binding.ET.getText().toString());
                startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
            }
        });

        binding.A3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra(KEY, binding.ET.getText().toString());
                startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Integer.parseInt(REQUESTCODE) && resultCode == RESULT_OK){
            String str = data.getStringExtra("key2");
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    };
}