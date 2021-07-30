package com.thienthai.timepiker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tvGio;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGio = (TextView) findViewById(R.id.tvGio);
        tvGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker();
            }
        });
    }
    private void timePicker(){
        calendar = Calendar.getInstance();
        int Gio = calendar.get(Calendar.HOUR_OF_DAY);
        int Phut =  calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(0,0,0, hourOfDay, minute);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                tvGio.setText(simpleDateFormat.format(calendar.getTime()));

            }
        },Gio, Phut,true );
        timePickerDialog.show();
    }
}