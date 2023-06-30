package com.example.calc1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result,solution;

    //buttons
    MaterialButton button_a,button_b,button_c, button_d,
            button_e,button_f, button_g,button_h,
            button_i,button_j,button_k,button_l,
            button_m,button_n,button_o,button_p,
            button_q,button_r,button_s,button_t;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign textviews
        result=findViewById(R.id.result);
        solution=findViewById(R.id.solution);
        //assign buttons with IDs
        assignID(button_a,R.id.button_a);
        assignID(button_b,R.id.button_b);
        assignID(button_c,R.id.button_c);
        assignID(button_d,R.id.button_d);
        //
        assignID(button_e,R.id.button_e);
        assignID(button_f,R.id.button_f);
        assignID(button_g,R.id.button_g);
        assignID(button_h,R.id.button_h);
        //
        assignID(button_i,R.id.button_i);
        assignID(button_j,R.id.button_j);
        assignID(button_k,R.id.button_k);
        assignID(button_l,R.id.button_l);
        //
        assignID(button_m,R.id.button_m);
        assignID(button_n,R.id.button_n);
        assignID(button_o,R.id.button_o);
        assignID(button_p,R.id.button_p);
        //
        assignID(button_q,R.id.button_q);
        assignID(button_r,R.id.button_r);
        assignID(button_s,R.id.button_s);
        assignID(button_t,R.id.button_t);

    }

    //method to assign buttons with IDs
    void assignID(MaterialButton b, int id){
        b=findViewById(id);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}