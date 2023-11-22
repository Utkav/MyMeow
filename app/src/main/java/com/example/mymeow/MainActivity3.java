package com.example.mymeow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//import com.example.mymeow.databinding.ActivityMain2Binding;
import com.example.mymeow.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    final static String KEY3 = "key3";
    final static String REQUESTCODE = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMain3Binding binding = ActivityMain3Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        String str = getIntent().getStringExtra(MainActivity3.KEY3);

//        binding.TV.setText(str);

        binding.A23.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
//                intent.putExtra(KEY2, binding.ET.getText().toString());
                startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
//                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT)
                showToast();
            }
        });

        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY3, "A3");
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Integer.parseInt(REQUESTCODE) && resultCode == RESULT_OK){
            String str = data.getStringExtra("key3");
            showToast();
        }
    };

    public void showToast(){
        Toast toast = Toast.makeText(getApplicationContext(), this.REQUESTCODE, Toast.LENGTH_SHORT);
        toast.show();
    }

}