package com.example.myintent_antok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int REQUEST_CODE = 100;
    private TextView tvResult;
    private Button btnDialNumber;
    private Button btnMoveActivity;
    private Button btnMoveWithData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithData = (Button)findViewById(R.id.btn_move_with_data);
        btnMoveWithData.setOnClickListener(this);

        btnDialNumber = (Button) findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_with_result);
        btnMoveForResult.setOnClickListener(this);


        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_with_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "KAMPUS STIMATA");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_dial_number:
                String dialNumber = "08155557346";
                Intent dialNUmberIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel : "+dialNumber));
                startActivity(dialNUmberIntent);
                break;
            case R.id.btn_move_with_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data

    ) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil " + selectedValue);
            }
        }
    }
}