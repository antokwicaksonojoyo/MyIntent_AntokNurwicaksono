package com.example.myintent_antok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveWithData = findViewById(R.id.btn_move_with_data);
        btnMoveWithData.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity :
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_with_data :
                  Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                  moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"KAMPUS STIMATA");
                  moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
                  startActivity(moveWithDataIntent);
                  break;
        }
    }
}