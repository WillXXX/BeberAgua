package com.example.beberagua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.net.InterfaceAddress;

public class MainActivity extends AppCompatActivity {

    private Button btnNotify;
    private EditText editMinutes;
    private TimePicker timePicker;

    private int hour;
    private int minute;
    private int interval;

    //logica booleana para fazer o botão voltar, pois o mesmo depois de ativado não volta ao estado normal, depois aplicar (if else) linha 56
    private boolean activated = false;

    //Classe de preferecias compartilhadas; declarar variavel
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btn_notify);
        editMinutes = findViewById(R.id.edit_text_number);
        timePicker = findViewById(R.id.time_picker);

        timePicker.setIs24HourView(true);
        //Atribuir valor
        preferences = getSharedPreferences("db", Context.MODE_PRIVATE);

        activated = preferences.getBoolean("activated", false);

        if (activated) {
            btnNotify.setText(R.string.pause);
            int color = ContextCompat.getColor(this, android.R.color.black);
            btnNotify.setBackgroundColor(color);

            int interval = preferences.getInt("interval", 0);
            int hour = preferences.getInt("hour", timePicker.getCurrentHour());
            int minute = preferences.getInt("minute", timePicker.getCurrentMinute());

            editMinutes.setText(String.valueOf(interval));
            timePicker.setCurrentHour(hour);
            timePicker.setCurrentMinute(minute);
        }
    }

    //evento de click via xml
    public void notifyClick(View view) {
        String sInterval = editMinutes.getText().toString();

        //Função para corrigir o erro de fechamento do botão notificar quando vazio
        if (sInterval.isEmpty()) {
            Toast.makeText(this, R.string.error_msg, Toast.LENGTH_LONG).show();
            return;
        }

        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        interval = Integer.parseInt(sInterval);


        if (!activated) {
//aqui foi criado arquivo de string "pausar" detro da chave "pausa"
            btnNotify.setText(R.string.pause);
            int color = ContextCompat.getColor(this, android.R.color.black);
            btnNotify.setBackgroundColor(color);
            activated = true;

            //Editor para guardar as variaveis das horas
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("activated", true);
            editor.putInt("interval", interval);
            editor.putInt("hour", hour);
            editor.putInt("minute", minute);
//efetivar escrita no banco de dados
            editor.apply();

        } else {
            btnNotify.setText(R.string.notify);
            int color = ContextCompat.getColor(this, R.color.colorAccent);
            btnNotify.setBackgroundColor(color);
            activated = false;

//Logica inversa/ Editor para zerar as variaveis das horas; remover identificadores
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("activated", false);
            editor.remove("interval");
            editor.remove("hour");
            editor.remove("minute");
            editor.apply();

        }

        Log.d("Teste", "Hora:" + hour + "minuto" + minute + "intervalo" + interval);
    }


//        //Evento de click com objeto anonimo
//        btnNotify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String sInterval = editMinutes.getText().toString();

////Função para corrigir o erro de fechamento do botão notificar quando vazio
//
//                if(sInterval.isEmpty())
//
//    {
////Toast serve para mostrar informações rápidas no Android
//        Toast.makeText(getApplicationContext(), R.string.error_msg, Toast.LENGTH_LONG).show();
//        return;
//    }
//
//    hour =timePicker.getCurrentHour();
//    minute =timePicker.getCurrentMinute();
//    interval =Integer.parseInt(sInterval);
//
//                btnNotify.setText(R.string.pause);
//    int color;
//    color =(ContextCompat.getColor(this,android.R.color.black);
//                btnNotify.setBackgroundColor(color);
//
//                Log.d("Teste"," Hora: "+hour +" minute: "+minute +" intervalo: "+interval);
//}
//        });
//                }

}