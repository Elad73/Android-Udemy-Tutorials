package com.example.eladron.androidappdevforbeginners;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class App60_TipAndSavingCalculator extends AppCompatActivity {

    //private static final NumberFormat currencyFormatValue = NumberFormat.getCurrencyInstance();
    //private static final NumberFormat percentFormatValue = NumberFormat.getPercentInstance();

    private double billAmount = 0.0;
    private double tipPercent = 0.25;
    private TextView txtBillAmount;
    private TextView txtTipPercent;
    private TextView txtTip;
    private TextView txtTotalBillAmount;

    private double totalSalary = 0.0;
    private double savingPercent = 0.25;
    private TextView txtSavePercent;
    private TextView txtMoneySaved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app60_tip_and_saving_calculator);



        txtBillAmount = (TextView) findViewById(R.id.txtBillAmount_app60);
        txtTipPercent = (TextView) findViewById(R.id.txtTipPercent_app60);
        txtTip = (TextView) findViewById(R.id.txtTip_app60);
        txtTotalBillAmount = (TextView) findViewById(R.id.txtTotalBillAmount_app60);
        txtSavePercent = (TextView) findViewById(R.id.txtSavePercent_app60);
        txtMoneySaved = (TextView) findViewById(R.id.txtMoveySaved_app60);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            txtTip.setText(NumberFormat.getCurrencyInstance().format(0));
            txtTotalBillAmount.setText(NumberFormat.getCurrencyInstance().format(0));
            txtMoneySaved.setText(NumberFormat.getCurrencyInstance().format(0));
        }


        EditText edtMoneyAmount = (EditText) findViewById(R.id.edtMoneyAmount_app60);
        edtMoneyAmount.addTextChangedListener(tipEdtMoneyAmountTextWatcher);

        SeekBar seekBarPercent = (SeekBar) findViewById(R.id.seekBarPercent_app60);
        seekBarPercent.setMax(100);
        seekBarPercent.setOnSeekBarChangeListener(tipSeekBarChangeListener);

        EditText edtSalaryAmount = (EditText) findViewById(R.id.edtSalary_app60);
        edtSalaryAmount.addTextChangedListener(saveSalaryTextWatcher);

        SeekBar seekSavePercent = (SeekBar) findViewById(R.id.seekSavePercent_app60);
        seekSavePercent.setMax(100);
        seekSavePercent.setOnSeekBarChangeListener(saveSeekBarChangeListener);

    }

    private final TextWatcher tipEdtMoneyAmountTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                billAmount = Double.parseDouble(s.toString());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                {
                    txtBillAmount.setText(NumberFormat.getCurrencyInstance().format(billAmount));
                }
                else {
                    txtBillAmount.setText(String.format(String.valueOf(billAmount), "0.00") + "$");
                }

                calculateTip();

            } catch (NumberFormatException nfEx) {

                txtBillAmount.setText("");
                billAmount = 0.0;
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final SeekBar.OnSeekBarChangeListener tipSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            tipPercent = progress/100.0;
            calculateTip();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void calculateTip() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtTipPercent.setText(NumberFormat.getPercentInstance().format(tipPercent));
        }
        else {
            txtTipPercent.setText(String.format(String.valueOf(tipPercent*100), "0.00") + "$");
        }

        double tipValue = billAmount * tipPercent;
        double totalValue = billAmount + tipValue;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtTip.setText(NumberFormat.getCurrencyInstance().format(tipValue));
            txtTotalBillAmount.setText(NumberFormat.getCurrencyInstance().format(totalValue));
        }
        else {
            txtTip.setText(String.format(String.valueOf(tipValue), "0.00") + "$");
            txtTotalBillAmount.setText(String.format(String.valueOf(totalValue), "0.00") + "$");
        }
    }

    private final TextWatcher saveSalaryTextWatcher  = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                totalSalary = Double.parseDouble(s.toString());
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                {
                    txtMoneySaved.setText(NumberFormat.getCurrencyInstance().format(totalSalary));
                }
                else {
                   txtMoneySaved.setText(String.format(String.valueOf(totalSalary), "0.00") + "$");
                }
                calculateSavings();

            } catch (NumberFormatException nfEx) {

                txtMoneySaved.setText("");
                totalSalary = 0.0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final SeekBar.OnSeekBarChangeListener saveSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            savingPercent = progress / 100.0;
            calculateSavings();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void calculateSavings() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtSavePercent.setText(NumberFormat.getPercentInstance().format(savingPercent));
        }
        else {
            txtSavePercent.setText(String.format(String.valueOf(savingPercent*100), "0.00") + "$");
        }

        double saveMoney = totalSalary * savingPercent;
        double totalValue = totalSalary + saveMoney;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtMoneySaved.setText(NumberFormat.getCurrencyInstance().format(saveMoney));
            //txtTotalBillAmount.setText(NumberFormat.getCurrencyInstance().format(totalValue));
        }
        else {
            txtMoneySaved.setText(String.format(String.valueOf(saveMoney), "0.00") + "$");
            //txtTotalBillAmount.setText(String.format(String.valueOf(totalValue), "0.00") + "$");
        }
    }
}
