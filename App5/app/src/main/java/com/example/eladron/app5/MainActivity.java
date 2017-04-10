package com.example.eladron.app5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Vehicle vehicle = new Vehicle(80, true, 4);
        vehicle.ride();

        Car car = new Car(160, true, 4);
        car.ride();

        Motorcycle motorcycle = new Motorcycle(60, true, 2);
        motorcycle.ride();

        TextView txtVehicle = (TextView) findViewById(R.id.txtVehicle);
        TextView txtCar = (TextView) findViewById(R.id.txtCar);
        TextView txtMotorcycle = (TextView) findViewById(R.id.txtMotorcycle);
        final TextView txtResult = (TextView) findViewById(R.id.txtResult);

        Button btnGo = (Button) findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 txtResult.setText("Button Clicked " + count);
                 ++count;

             }
         });

        txtVehicle.setText(vehicle.toString());
        txtCar.setText(car.toString());
        txtMotorcycle.setText(motorcycle.toString());


    }


}
