package com.example.eladron.app7;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView txtStart = (TextView) findViewById(R.id.txtStart);
        final TextView txtI = (TextView) findViewById(R.id.txtI);
        final TextView txtSwitch = (TextView) findViewById(R.id.txtSwitch);
        final Button btnLoop = (Button) findViewById(R.id.btnLoop);
        Button btnSwitch = (Button) findViewById(R.id.btnSwitch);
        final EditText edtSwitch = (EditText) findViewById(R.id.edtSwitch);



        btnLoop.setOnClickListener(new View.OnClickListener()
        {
            short colorSwitch = 0;

            @Override
            public void onClick(View v)
            {


                if(colorSwitch%2 == 0)
                    btnLoop.setBackgroundColor(Color.BLUE);
                else
                    btnLoop.setBackgroundColor(Color.GREEN);

                int i=0;
                for(; i <= 10; ++i)
                {
                    Log.i("LOG", i + "");

                    try {
                        //Thread.sleep(100);
                        txtStart.setText(i + "");

                    }
                    catch(Exception e)
                    {
                        txtStart.setText(e.toString());
                    }
                }
                txtI.setText(i + "");
                ++colorSwitch;
            }
        });


        btnSwitch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String nameString = edtSwitch.getText().toString();

                switch(nameString.toLowerCase()) {

                    case "dog":
                        txtSwitch.setText("Our anumal name is Dog");
                        break;
                    case "cat":
                        txtSwitch.setText("Our anumal name is Cat");
                        break;
                    default:
                        txtSwitch.setText("Our anumal name is default");
                        break;
                }

            }
        });

    }
}
