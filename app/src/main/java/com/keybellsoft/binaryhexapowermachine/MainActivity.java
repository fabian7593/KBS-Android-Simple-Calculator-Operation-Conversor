package com.keybellsoft.binaryhexapowermachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private TextView labelSum;
    private TextView EditTextNumbers;
    private TextView labelResult;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;
    private Button btnResult;
    private Button btnPlus;
    private Button btnClear;
    private Operations operations;


    private RadioGroup radioOperationGroup;
    private RadioButton radioOperationButton;

    private void setView() {
        labelSum = (TextView) findViewById(R.id.labelSum);
        EditTextNumbers = (TextView) findViewById(R.id.EditTextNumbers);
        labelResult = (TextView) findViewById(R.id.labelResult);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnClear = (Button) findViewById(R.id.btnClear);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);

        btnResult.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        radioOperationGroup = (RadioGroup) findViewById(R.id.radioOperation);
        radioOperationGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioOperationButton = (RadioButton) findViewById(checkedId);
                if (radioOperationButton.getId() == R.id.radioBinary) {
                    enableBinary();
                    clean(false);

                    if (labelResult.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "This operation not have result value. Please first make the operation", Toast.LENGTH_LONG).show();

                        radioOperationButton = (RadioButton) findViewById(R.id.radioBinary);
                        radioOperationButton.setChecked(true);
                    } else {
                        labelResult.setText(operations.hexToBin(labelResult.getText().toString()).toUpperCase());
                    }

                } else if (radioOperationButton.getId() == R.id.radioHexa) {
                    enableHexadecimal();
                    clean(false);

                    if (labelResult.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "This operation not have result value. Please first make the operation", Toast.LENGTH_LONG).show();
                        radioOperationButton = (RadioButton) findViewById(R.id.radioHexa);
                        radioOperationButton.setChecked(true);
                    } else {
                        labelResult.setText(operations.convertToHexa(labelResult.getText().toString()).toUpperCase());
                    }
                }
            }
        });
    }


    //TODO chequear codigo mas adelante sobre click listeners
/*private void setClicksListeners() {
    // a layout is a ViewGroup
    ViewGroup mainLayout = (ViewGroup) findViewById(R.id.mainlayout);

    for (int i = 0; i < mainLayout.getChildCount(); i++) {
        View view = mainLayout.getChildAt(i);
        if (view instanceof Button) {
            view.setOnClickListener(this);
        }
    }
}*/

    private void enableBinary() {
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
    }


    private void enableHexadecimal() {
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operations = new Operations();
        setView();
        // setClicksListeners();
        enableBinary();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == btn0) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "0");
        } else if (v == btn1) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "1");
        } else if (v == btn2) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "2");
        } else if (v == btn3) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "3");
        } else if (v == btn4) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "4");
        } else if (v == btn5) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "5");
        } else if (v == btn6) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "6");
        } else if (v == btn7) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "7");
        } else if (v == btn8) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "8");
        } else if (v == btn9) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "9");
        } else if (v == btnA) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "A");
        } else if (v == btnB) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "B");
        } else if (v == btnC) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "C");
        } else if (v == btnD) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "D");
        } else if (v == btnE) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "E");
        } else if (v == btnF) {
            EditTextNumbers.setText(EditTextNumbers.getText().toString() + "F");
        } else if (v == btnResult) {

            labelResult.setText(
                    operations.sum(labelSum.getText().toString(), EditTextNumbers.getText().toString())
            );

        } else if (v == btnPlus) {
            if (labelSum.getText().toString().trim().equals("")) {
                labelSum.setText(EditTextNumbers.getText().toString());
                EditTextNumbers.setText("");
            } else {
                // get selected radio button from radioGroup
                int selectedId = radioOperationGroup.getCheckedRadioButtonId();
                radioOperationButton = (RadioButton) findViewById(selectedId);

                if (radioOperationButton.getId() == R.id.radioBinary) {
                    labelSum.setText(
                            operations.sum(labelSum.getText().toString(), EditTextNumbers.getText().toString())
                    );
                    EditTextNumbers.setText("");
                } else if (radioOperationButton.getId() == R.id.radioHexa) {

                    String sumBinary = operations.sum(
                            operations.hexToBin(labelSum.getText().toString()),
                            operations.hexToBin(EditTextNumbers.getText().toString())
                    );

                    labelSum.setText(
                            operations.convertToHexa(sumBinary)
                    );
                    EditTextNumbers.setText("");

                }

            }
        } else if (v == btnClear) {
            clean(true);
        }
    }


    private void clean(Boolean cleanResult) {
        labelSum.setText("");
        EditTextNumbers.setText("");
        if (cleanResult) {
            labelResult.setText("");
        }
    }


}
