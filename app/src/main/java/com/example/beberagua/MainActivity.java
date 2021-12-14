package com.example.beberagua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private Button btnNotify;
    private EditText edittext;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btn_notify);
        edittext = findViewById(R.id.edit_text_number);
        timePicker = findViewById(R.id.time_picker);

        timePicker.setIs24HourView(true);
    }

}