package com.example.beberagua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.net.InterfaceAddress;

public class MainActivity extends AppCompatActivity {

    //declaração de variaveies
    private Button btnNotify;
    private EditText editMinutes;
    private TimePicker timePicker;

    private int hour;
    private int minute;
    private int interval;

    private boolean activated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retorno das funções
        btnNotify = findViewById(R.id.btn_notify);
        editMinutes = findViewById(R.id.edit_text_number);
        timePicker = findViewById(R.id.time_picker);

        timePicker.setIs24HourView(true);
    }

    public void notifyClick(View view) {
        editMinutes
    }


//        //Evento de click com objeto anonimo
//        btnNotify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String sInterval = editMinutes.getText().toString();
//
////Função para corrigir o erro de fechamento do botão notificar quando vazio
//
//                if (sInterval.isEmpty()) {
////Toast serve para mostrar informações rápidas no Android
//                    Toast.makeText(getApplicationContext(), R.string.error_msg, Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                hour = timePicker.getCurrentHour();
//                minute = timePicker.getCurrentMinute();
//                interval = Integer.parseInt(sInterval);
//
//                btnNotify.setText(R.string.pause);
//                int color;
//                color = (ContextCompat.getColor(this, android.R.color.black);
//                btnNotify.setBackgroundColor(color);
//
//                Log.d("Teste", " Hora: " + hour + " minute: " + minute + " intervalo: " + interval);
//            }
//        });
//    }


}