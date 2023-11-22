package com.example.mymeow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymeow.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    final static String KEY2 = "key2";
    final static String REQUESTCODE = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMain2Binding binding = ActivityMain2Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        String str = getIntent().getStringExtra(MainActivity.KEY);

//        binding.TV.setText(str);

        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY2, "A2");
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        binding.A32.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
//                intent.putExtra(KEY2, binding.ET.getText().toString());
                startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
//                showToast();
            }
        });
        }

    public void showToast(){
        Toast toast = Toast.makeText(getApplicationContext(), this.REQUESTCODE, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Integer.parseInt(REQUESTCODE) && resultCode == RESULT_OK){
            String str = data.getStringExtra("key2");
            showToast();
        }
    };

}