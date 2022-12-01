package com.example.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    Button button1;
    TextView choiceButton1;

    Button buttonDate;
    Button buttonTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        this.button1 = this.findViewById(R.id.button1);
        this.choiceButton1 = this.findViewById(R.id.choiceButton1);

        this.buttonDate = this.findViewById(R.id.buttonDate);
        this.buttonTime = this.findViewById(R.id.buttonTime);

        this.button1.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Alert");
            builder.setMessage("Click OK to continue, or Cancel to stop:");

            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    choiceButton1.setText("You pressed CANCEL");
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    choiceButton1.setText("You pressed OK");
                }
            });

            builder.create().show();
        });


        this.buttonDate.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (finalView, finalYear, finalMonth, finalDay) ->

                    Toast.makeText(MainActivity2.this, finalDay + "/" + (finalMonth + 1) + "/" + finalYear, Toast.LENGTH_SHORT).show(),

                    Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);


            datePickerDialog.show();
        });


        this.buttonTime.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    Toast.makeText(MainActivity2.this, hour + "h " + minute + "m", Toast.LENGTH_SHORT).show();
                }

            }, Calendar.HOUR_OF_DAY, Calendar.MINUTE, DateFormat.is24HourFormat(this));


            timePickerDialog.show();
        });

    }
}