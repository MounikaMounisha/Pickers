package com.example.alertdialogue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int y,m,d;
    int h,min;
    TextView tv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
    }
    public void getalert(View view) {

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Alert");
        b.setIcon(R.drawable.alerticon);
        b.setMessage("Do you want to close the app");
        b.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });
        b.show();
    }

    public void getdate(View view) {
        Calendar c=Calendar.getInstance();
        y=c.get(Calendar.YEAR);
        m=c.get(Calendar.MONTH);
        d=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dp=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                tv.setText(""+i2+"-"+(i1+1)+"-"+i);

            }
        },y,m,d);
        dp.show();
    }

    public void gettime(View view)

    {
       Calendar c=Calendar.getInstance();
       h=c.get(Calendar.HOUR);
       min=c.get(Calendar.MINUTE);

       TimePickerDialog tp=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
           @Override
           public void onTimeSet(TimePicker view, int hourOfDay, int minute){

                   tv1.setText(hourOfDay+":"+minute);
           }

       },h,min,false);
       tp.show();
    }
}


