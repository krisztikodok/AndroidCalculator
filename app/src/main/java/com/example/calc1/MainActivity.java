package com.example.calc1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.io.IOError;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result_tv, solution_tv;

    //buttons
    MaterialButton button_a, button_b, button_c, button_d,
            button_e, button_f, button_g, button_h,
            button_i, button_j, button_k, button_l,
            button_m, button_n, button_o, button_p,
            button_q, button_r, button_s, button_t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign textviews
        result_tv = findViewById(R.id.result);
        solution_tv = findViewById(R.id.solution);
        //assign buttons with IDs
        //1st row
        assignID(button_a, R.id.button_a);
        assignID(button_b, R.id.button_b);
        assignID(button_c, R.id.button_c);
        assignID(button_d, R.id.button_d);
        //2nd row
        assignID(button_e, R.id.button_e);
        assignID(button_f, R.id.button_f);
        assignID(button_g, R.id.button_g);
        assignID(button_h, R.id.button_h);
        //3rd row
        assignID(button_i, R.id.button_i);
        assignID(button_j, R.id.button_j);
        assignID(button_k, R.id.button_k);
        assignID(button_l, R.id.button_l);
        //4th row
        assignID(button_m, R.id.button_m);
        assignID(button_n, R.id.button_n);
        assignID(button_o, R.id.button_o);
        assignID(button_p, R.id.button_p);
        //5th row
        assignID(button_q, R.id.button_q);
        assignID(button_r, R.id.button_r);
        assignID(button_s, R.id.button_s);
        assignID(button_t, R.id.button_t);

    }

    //method to assign buttons with IDs
    void assignID(MaterialButton mat_b, int id) {
        mat_b = findViewById(id);
        mat_b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton bt = (MaterialButton) v;

        //getting the text
        String bt_text = bt.getText().toString();
        String toCalc=solution_tv.getText().toString();

        // AC clears textviews
        if(bt_text.equals("AC")){
            solution_tv.setText("");
            result_tv.setText("0");
            return;
        }

        // =
        if(bt_text.equals("=")){
            //calculate result
            solution_tv.setText(result_tv.getText());
            return;
        }

        // clear last button input

            if (bt_text.equals("C")) {
                toCalc = toCalc.substring(0, toCalc.length() - 1); //trim the last character
            }


        else{ toCalc=toCalc+bt_text;} //concatenate input

        //getting result
        solution_tv.setText(toCalc);



        String finalSum=sum(toCalc);

        if(!finalSum.equals("Hiba")){
            result_tv.setText(finalSum);
            }
    }

    // calculate result
    String sum(String input){
        try {
            Context xc=Context.enter();
            xc.setOptimizationLevel(-1);
            Scriptable sc = xc.initStandardObjects();
            String finalSum=xc.evaluateString(sc,input,"Javascript",1,null).toString();//calculate the string
            if(finalSum.endsWith(".0")){
                finalSum=finalSum.replace(".0","");
            }
            return finalSum;
        }catch (Exception e){
            //result_tv.setText("Error");
            return  "Hiba";
        }
    }
}