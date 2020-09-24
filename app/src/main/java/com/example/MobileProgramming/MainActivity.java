package com.example.MobileProgramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int count = 0;
    private TextView numberText;
    private Button increment;
    private Button decrement;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.incrementBtn:
                    increment();
                    break;
                case R.id.decrementBtn:
                    decrement();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberText = (TextView)findViewById(R.id.numberText);
        increment = (Button)findViewById(R.id.incrementBtn);
        increment.setOnClickListener(clickListener);
        decrement = (Button)findViewById(R.id.decrementBtn);
        decrement.setOnClickListener(clickListener);


    }

    public static int getCounter() {
        return count;
    }


    public void increment(){
        count++;
        numberText.setText(count + "");
    }

    public void decrement() {
        if (count <= 0) count = 0;
        else
            count--;
            numberText.setText(count + "");
    }
}