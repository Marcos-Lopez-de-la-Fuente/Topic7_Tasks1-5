# **Topic7_Tasks1-5**

<details>

**<summary>Application Images</summary>**

<img src="./resForReadme/mobile.gif">

</details>

### **Code**

<ul>

#### <li>**Java files**

<ul>

<li>

<details>

**<summary>`MainActivity.java`</summary>**

```java
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
```

</details>

</li>

<li>

<details>

**<summary>`MainActivity2.java`</summary>**

```java
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
```

</details>

</li>

</ul>

</li>

### <li>**XML files**

<ul>

<li>

<details>

**<summary>`activity_main.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp">


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/editText1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Text Cap Sentences"
            android:inputType="textCapSentences" />

        <Button
            android:id="@+id/buttonShow1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="SHOW" />


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/editText2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Text Email Address"
            android:inputType="textEmailAddress" />

        <Button
            android:id="@+id/buttonShow2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="SHOW" />


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/editText3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Phone"
            android:inputType="phone" />

        <Button
            android:id="@+id/buttonShow3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="CALL" />


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/editText4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Phone and Spinner"
            android:inputType="phone" />

        <Spinner
            android:id="@+id/spinnerPhone"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:entries="@array/phone_and_spinner" />


    </LinearLayout>

    <TextView
        android:id="@+id/phoneAndSpinner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Phone Number:" />

    <Button
        android:id="@+id/goToMainActivity2"
        android:layout_gravity="center"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Go To Main Activity 2"/>

</LinearLayout>
```

</details>

</li>

<li>

<details>

**<summary>`activity_main2.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Alert" />

    <TextView
        android:id="@+id/choiceButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Choose the date and time:" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/buttonDate"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="DATE"
            android:layout_marginRight="10dp"/>

        <Button
            android:id="@+id/buttonTime"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="TIME" />

    </LinearLayout>
</LinearLayout>
```

</details>

</li>

</li>

</ul>

</ul>
