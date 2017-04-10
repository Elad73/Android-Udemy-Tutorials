package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class App55_LandscapeUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app55_landscape_ui);

        final TextView txtInclude = (TextView) findViewById(R.id.txtInclude_app55);
        Button btnInclude   = (Button) findViewById(R.id.btnInclude_app55);
        final CheckBox chxInclude = (CheckBox) findViewById(R.id.chxInclude_app55);

        btnInclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInclude.setText("The Text is Changed");
                chxInclude.setChecked(true);
                chxInclude.setText("The Value of This checkBox is True");
            }
        });

    }

}
