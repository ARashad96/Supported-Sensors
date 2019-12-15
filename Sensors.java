package com.ARashad96.androidbeginnerdeveloperkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Sensors extends AppCompatActivity implements SensorEventListener {
    Button github;
    Button info;
    private SensorManager sensorManager;
    private Sensor accelerometer, mGyro, mHumi, mLight, mMagno, mPressure, mProx, mTemp;
    TextView x1, y1, z1, x2, y2, z2, x3, y3, z3;
    TextView humidity, light, pressure, prox, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sensors);

        //calling all sensors
        Accelerometer();
        Gyroscope();
        Humidity();
        Light();
        Magnitude();
        Pressure();
        Proximity();
        Temperature();

        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/Supported-Sensors"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(Sensors.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app is showing all the supported sensors in the phone using sensors, textview and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        //Log.d(TAG, "onSensorChanged: X:" + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x1.setText("X Accelerometer Value: " + sensorEvent.values[0]);
            y1.setText("Y Accelerometer Value: " + sensorEvent.values[1]);
            z1.setText("Z Accelerometer Value: " + sensorEvent.values[2]);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            x2.setText("X Gyroscope Value: " + sensorEvent.values[0]);
            y2.setText("Y Gyroscope Value: " + sensorEvent.values[1]);
            z2.setText("Z Gyroscope Value: " + sensorEvent.values[2]);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            humidity.setText("Humidity: " + sensorEvent.values[0]);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            light.setText("Light: " + sensorEvent.values[0]);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            x3.setText("X Magnetic field Value: " + sensorEvent.values[0]);
            y3.setText("Y Magnetic field Value: " + sensorEvent.values[1]);
            z3.setText("Z Magnetic field Value: " + sensorEvent.values[2]);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PRESSURE) {
            pressure.setText("Pressure: " + sensorEvent.values[0]);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            prox.setText("Proximity: " + sensorEvent.values[0]);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            temp.setText("Temperature: " + sensorEvent.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void Accelerometer(){
        x1 = findViewById(R.id.x1);
        y1 = findViewById(R.id.y1);
        z1 = findViewById(R.id.z1);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //check if my mobile support this sensor
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            x1.setText("Accelerometer not supported");
            y1.setText("Accelerometer not supported");
            z1.setText("Accelerometer not supported");
        }
    }

    public void Gyroscope(){
        x2= findViewById(R.id.x2);
        y2= findViewById(R.id.y2);
        z2= findViewById(R.id.z2);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //check if my mobile support this sensor

        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGyro!=null){
            sensorManager.registerListener(this,mGyro,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            x2.setText("Gyro not supported");
            y2.setText("Gyro not supported");
            z2.setText("Gyro not supported");
        }
    }

    public void Humidity(){

        humidity = findViewById(R.id.hum);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //check if my mobile support this sensor

        mHumi= sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (mHumi!=null){
            sensorManager.registerListener(this,mHumi,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            humidity.setText("Humidity not supported");
        }
    }

    public void Light(){

        light = findViewById(R.id.light);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //check if my mobile support this sensor

        mLight= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight!=null){
            sensorManager.registerListener(this,mLight,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            light.setText("Light not supported");
        }
    }

    public void Magnitude(){
        x3= findViewById(R.id.x3);
        y3= findViewById(R.id.y3);
        z3= findViewById(R.id.z3);


        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //check if my mobile support this sensor

        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mMagno!=null){
            sensorManager.registerListener(this,mMagno,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            x3.setText("Magno not supported");
            y3.setText("Magno not supported");
            z3.setText("Magno not supported");
        }
    }

    public void Pressure(){

        pressure = findViewById(R.id.pressure);

        mPressure= sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mPressure!=null){
            sensorManager.registerListener(this,mPressure,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            pressure.setText("Pressure not supported");
        }
    }

    public void Proximity(){

        prox = findViewById(R.id.prox);

        mProx= sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (mProx!=null){
            sensorManager.registerListener(this,mProx,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            prox.setText("Proximity not supported");
        }
    }

    public void Temperature(){

        temp = findViewById(R.id.temp);

        mTemp= sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (mTemp!=null){
            sensorManager.registerListener(this,mTemp,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            temp.setText("Temp not supported");
        }
    }
}
