package com.example.l4_3_datepickertimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edDate, edTime;
    private Button btDate, btTime;
    private int mDay, mMonth, mYear, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btDate.setOnClickListener(this);
        btTime.setOnClickListener(this);
    }

    public void initView(){
        edDate = findViewById(R.id.txtDate);
        edTime = findViewById(R.id.txtTime);
        btDate = findViewById(R.id.btnDate);
        btTime = findViewById(R.id.btnTime);
    }
    @Override
    public void onClick(View v) {
        if(v == btDate){
            Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    edDate.setText(i2 + "/" + (i1+1) + "/" + i);
                }
            }, mYear, mMonth, mDay);
            dialog.show();
        }
        if (v == btTime){
            Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR);
            mMinute = c.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    edTime.setText(i + ":" + i1);
                }
            },mHour, mMinute, true);
            dialog.show();
        }
    }
}