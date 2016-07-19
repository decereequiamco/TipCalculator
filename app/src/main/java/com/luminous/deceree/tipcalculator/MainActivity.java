package com.luminous.deceree.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare variables
    private EditText mEtBill;
    private EditText mEtNumofPep;
    private TextView seekNum;
    private SeekBar seekBar; //Your SeekBar
    private TextView TvTip;
    private TextView TvPer;
    private TextView mTvResult;  //The TextView which will display the result
    private float start = 0;
    private float end = 100;

    private int tipPercentValue = 0;
    private int tipsForNumberOfPeople = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mEtBill = (EditText) findViewById(R.id.mEtBill);
            seekBar = (SeekBar) findViewById(R.id.seekBar);
            mEtNumofPep = (EditText) findViewById(R.id.mEtNumofPep);
            TvPer = (TextView) findViewById(R.id.TvPer);
            TvTip = (TextView) findViewById(R.id.TvTip);
            seekNum = (TextView) findViewById(R.id.seekNum);


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                    public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser) {
                    try {
                        tipPercentValue = progress;

                        double totalBillInput = Double.parseDouble(mEtBill.getText().toString());
                        double percentageOfTip = Double.parseDouble(mEtNumofPep.getText().toString());

                        double percentTip = (totalBillInput * tipPercentValue / 100) / percentageOfTip;
                        double totalAmountForTheBill = percentTip * percentageOfTip;

                        TvPer.setText((String.valueOf(String.format("%.2f", totalAmountForTheBill))));

                        TvTip.setText((String.valueOf(String.format("%.2f", percentTip))));
//                    if (TvPer.getText().toString().equals("") || TvTip.getText().toString().isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "All Input field must be filled", Toast.LENGTH_LONG).show();
//                    return;
//                }
                        totalBillInput = Double.parseDouble(TvPer.getText().toString());
                        if (tipPercentValue == 0 || tipsForNumberOfPeople == 0) {
                            Toast.makeText(getApplicationContext(), "Please set values", Toast.LENGTH_LONG).show();
                            return;


                        }
                    } catch (NumberFormatException e)

                    {
                        Toast.makeText(getApplicationContext(), "Set values!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    seekNum.setText("" + seekBar.getProgress() + "%");
                }


            });




        mEtNumofPep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}

