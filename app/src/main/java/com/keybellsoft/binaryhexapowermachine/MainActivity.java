package com.keybellsoft.binaryhexapowermachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TooManyListenersException;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    private TextView labelSumBinary;
    private EditText EditTextNumbersBinary;
    private TextView labelResultBinary;
    private Button btn0Binary;
    private Button btn1Binary;
    private Button btnChangeHexadecimal;
    private Button btnResultBinary;
    private Button btnPlusBinary;
    private Button btnClearBinary;

    private void setView() {
        labelSumBinary = (TextView) findViewById(R.id.labelSumBinary);
        EditTextNumbersBinary = (EditText) findViewById(R.id.EditTextNumbersBinary);
        labelResultBinary = (TextView) findViewById(R.id.labelResultBinary);
        btn0Binary = (Button) findViewById(R.id.btn0Binary);
        btn1Binary = (Button) findViewById(R.id.btn1Binary);
        btnChangeHexadecimal = (Button) findViewById(R.id.btnChangeHexadecimal);
        btnResultBinary = (Button) findViewById(R.id.btnResultBinary);
        btnPlusBinary = (Button) findViewById(R.id.btnPlusBinary);
        btnClearBinary=(Button) findViewById(R.id.btnClearBinary);
        btn0Binary.setOnClickListener(this);
        btn1Binary.setOnClickListener(this);
        btnChangeHexadecimal.setOnClickListener(this);
        btnResultBinary.setOnClickListener(this);
        btnPlusBinary.setOnClickListener(this);
        btnClearBinary.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
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
        if (v == btn0Binary) {
            EditTextNumbersBinary.setText(EditTextNumbersBinary.getText().toString() + "0");
        }
        else if(v == btn1Binary) {
            EditTextNumbersBinary.setText(EditTextNumbersBinary.getText().toString() + "1");
        }
        else if(v == btnChangeHexadecimal) {
            Intent intent = new Intent(MainActivity.this, Hexadecimal.class);
            startActivity(intent);
        }
        else if(v == btnResultBinary) {
            labelResultBinary.setText(
                    sumBinary(labelSumBinary.getText().toString(), EditTextNumbersBinary.getText().toString())
            );
        }
        else if(v == btnPlusBinary) {
            labelSumBinary.setText(EditTextNumbersBinary.getText().toString());
            EditTextNumbersBinary.setText("");
        }else if(v==btnClearBinary){
            labelSumBinary.setText("");
            EditTextNumbersBinary.setText("");
            labelResultBinary.setText("");
        }
    }



    //Sum the binary numbers
    private String sumBinary(String num1,String num2) {
        //char array of number 1 and number 2
        char[] charArrayNum1 = num1.toCharArray();
        char[] charArrayNum2 = num2.toCharArray();

        int lenghtMinimumChar=0;
        int lenghtMaximumChar=0;
        if(charArrayNum1.length <= charArrayNum2.length)
        {
            lenghtMinimumChar = charArrayNum1.length-1;
            lenghtMaximumChar = charArrayNum2.length-1;
        }
        else
        {
            lenghtMinimumChar = charArrayNum2.length-1;
            lenghtMaximumChar = charArrayNum1.length-1;
        }

        int auxMaximChar=lenghtMaximumChar;
        String resultString="";
        String missing="";
       for(int x = lenghtMinimumChar; x >= 0; x--,auxMaximChar--)
        {
            Boolean firstNumber = false;
            Boolean secondNumber = false;
            if(charArrayNum1.length-1 == lenghtMinimumChar)
            {
                 firstNumber= Boolean.parseBoolean(String.valueOf(charArrayNum1[x]));
                 secondNumber= Boolean.parseBoolean(String.valueOf(charArrayNum2[auxMaximChar]));
            }else {
                firstNumber= Boolean.parseBoolean(String.valueOf(charArrayNum2[x]));
                secondNumber= Boolean.parseBoolean(String.valueOf(charArrayNum1[auxMaximChar]));
            }

            if((firstNumber.equals(true) && secondNumber.equals(false)) || (firstNumber.equals(false) && secondNumber.equals(true)))
            {
                if(missing.equals("1"))
                {
                    resultString = resultString + "0";
                    missing="1";
                }else
                {
                    resultString = resultString + "1";
                }

            }else if(firstNumber.equals(true) && secondNumber.equals(true)){

                if(missing.equals("1"))
                {
                    resultString = resultString + "1";
                }else
                {
                    resultString = resultString + "0";
                }

                missing="1";
            }else if(firstNumber.equals(false) && secondNumber.equals(false)){

                if(missing.equals("1"))
                {
                    resultString = resultString + "1";
                }else {
                    resultString = resultString + "0";
                }

                missing="";
            }

        }


        String finalNumber="";
        Boolean increase=false;
        for(int y = auxMaximChar; y >= 0; y--)
        {
            increase=true;
            if(charArrayNum1.length-1 == lenghtMinimumChar)
            {
                finalNumber= String.valueOf(charArrayNum2[y]);
            }else {
                finalNumber= String.valueOf(charArrayNum1[y]);
            }

            if(missing.equals("1"))
            {
                if(finalNumber.equals("1"))
                {
                    resultString = resultString + "0";
                    missing="1";
                }else if (finalNumber.equals("0"))
                {
                    resultString = resultString + "1";
                }
            }
            else
            {
                resultString = resultString + finalNumber;
            }
        }

        if(!increase){
            resultString = resultString + missing;
        }

        StringBuilder builder=new StringBuilder(resultString);
        String invertString=builder.reverse().toString();

        return invertString;
    }
}




























