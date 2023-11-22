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
    final static String REQUESTCODE = "1";

    public static String sign1 = null;
    public static String sign2 = null;
    public static String sign3 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.A2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                intent.putExtra(KEY, binding.ET.getText().toString());
                startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
//                showToast();
            }
        });

        binding.A3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
//                intent.putExtra(KEY, binding.ET.getText().toString());
                startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
//                showToast();
            }
        });

        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sign3 == null && sign2 != null) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
                    Toast toastA1 = Toast.makeText(getApplicationContext(), MainActivity2.REQUESTCODE, Toast.LENGTH_SHORT);
                    toastA1.show();

                } else if (sign2 == null && sign3 != null) {
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivityForResult(intent, Integer.parseInt(REQUESTCODE));
                    Toast toastA1 = Toast.makeText(getApplicationContext(), MainActivity3.REQUESTCODE, Toast.LENGTH_SHORT);
                    toastA1.show();
                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Integer.parseInt(REQUESTCODE) && resultCode == RESULT_OK){
//            String str = data.getStringExtra("key1");
            sign1 = data.getStringExtra(KEY);
            sign2 = data.getStringExtra(MainActivity2.KEY2);
            sign3 = data.getStringExtra(MainActivity3.KEY3);

            if (sign2 != null && sign3 == null){
                Intent intent = new Intent();
                intent.putExtra(MainActivity2.KEY2, "A2");
//                Toast toast_err = Toast.makeText(getApplicationContext(), "Nice bro", Toast.LENGTH_SHORT);
//                toast_err.show();
            } else if (sign2 == null && sign3 != null) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity3.KEY3, "A3");
//                Toast toast_err = Toast.makeText(getApplicationContext(), "Nice sister", Toast.LENGTH_SHORT);
//                toast_err.show();
            }
            showToast();
        }
    };

    public void showToast(){
        Toast toast = Toast.makeText(getApplicationContext(), this.REQUESTCODE, Toast.LENGTH_SHORT);
        toast.show();
    }
}