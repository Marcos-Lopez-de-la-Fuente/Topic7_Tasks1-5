package com.example.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    Button button1;

    EditText editText2;
    Button button2;

    EditText editText3;
    Button button3;

    EditText editText4;
    Spinner spinner;
    TextView phoneAndSpinner;

    Button goToMainActivity2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.editText1 = this.findViewById(R.id.editText1);
        this.button1 = this.findViewById(R.id.buttonShow1);

        this.editText2 = this.findViewById(R.id.editText2);
        this.button2 = this.findViewById(R.id.buttonShow2);

        this.editText3 = this.findViewById(R.id.editText3);
        this.button3 = this.findViewById(R.id.buttonShow3);

        this.editText4 = this.findViewById(R.id.editText4);
        this.spinner = this.findViewById(R.id.spinnerPhone);
        this.phoneAndSpinner = this.findViewById(R.id.phoneAndSpinner);

        this.goToMainActivity2 = this.findViewById(R.id.goToMainActivity2);


        this.button1.setOnClickListener(view -> {
            if (this.editText1.getText().length() > 0) {
                Toast.makeText(this, editText1.getText(), Toast.LENGTH_SHORT).show();
                editText1.setText("");
            }
        });

        this.button2.setOnClickListener(view -> {
            if (this.editText2.getText().length() > 0) {
                Toast.makeText(this, editText2.getText(), Toast.LENGTH_SHORT).show();
                editText2.setText("");
            }
        });

        this.button3.setOnClickListener(view -> {
            if (this.editText3.getText().length() > 0) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + this.editText3.getText()));
                startActivity(intent);
            }
        });

        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                if (editText4.getText().length() > 0) {
                    phoneAndSpinner.setText("Phone Number: " + editText4.getText() + " - " + text);
                    Toast.makeText(MainActivity.this, text + ": " + editText4.getText(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

        });
        
        this.goToMainActivity2.setOnClickListener(view ->
                this.startActivity(new Intent(this, MainActivity2.class))
        );

    }
}