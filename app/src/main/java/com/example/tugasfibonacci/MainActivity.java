package com.example.tugasfibonacci;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int hitungIncre = 0;
    private int hitungFibo = 0;
    private TextView tampilincre;
    private TextView tampilFibo;
    private Button buttonToast;
    private Button buttonHitung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tampilincre = (TextView) findViewById(R.id.textViewNumber);
        tampilFibo = (TextView) findViewById(R.id.textViewFibo);
        buttonToast = (Button) findViewById(R.id.button_toast);
        buttonHitung = (Button) findViewById(R.id.button_hitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { hitungIncrement(view); }
        });
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { showToast(view); }
        });
    }

    public void showToast(View view){
        Toast toast = Toast.makeText(this, R.string.toast_pesan, Toast.LENGTH_SHORT);
        toast.show();
    }


    public void hitungIncrement(View view){
        hitungIncre++;
        int fibo = hitungFibonacci(hitungIncre);
        hitungFibo= fibo;
        if (tampilincre != null &&  tampilFibo!= null){
            tampilincre.setText(Integer.toString(hitungFibo));
        }
    }

    public int hitungFibonacci(int n){
        if (n <= 1){
            return n;
        }
        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++){
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }
}
