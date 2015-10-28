package com.keybellsoft.binaryhexapowermachine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Fabi on 26/10/2015.
 */
public class Hexadecimal extends AppCompatActivity implements
        View.OnClickListener{

    private TextView labelSumHexa;
    private EditText EditTextNumbersHexa;
    private TextView labelResultHexa;

    private Button btn0Hexa;
    private Button btn1Hexa;
    private Button btn2Hexa;
    private Button btn3Hexa;
    private Button btn4Hexa;
    private Button btn5Hexa;
    private Button btn6Hexa;
    private Button btn7Hexa;
    private Button btn8Hexa;
    private Button btn9Hexa;
    private Button btnAHexa;
    private Button btnBHexa;
    private Button btnCHexa;
    private Button btnDHexa;
    private Button btnEHexa;
    private Button btnFHexa;
    private Button btnChangeBinary;
    private Button btnResultHexa;
    private Button btnPlusHexa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexadecimal);
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

        if (v == btn0Hexa) {
        }
    }
}
