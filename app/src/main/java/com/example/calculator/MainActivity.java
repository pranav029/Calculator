package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b_eq,b_add,b_sub,b_mul,b_mod,b_cls,b00,b_div,b_back,b_dot;
    private EditText editText;
    private TextView textView;
    private String display="";
    private char prev='+';
    private double sum=0;
    private double mul=0;
    private double divide=1.0;
    private boolean current=false;
    void str_update()
    {
        switch(prev)
        {
            case '+':sum+=mul; return;
            case '-':sum-=mul; return;
            case 'x':sum*=mul; return;
            case '/':sum/=mul; return;
            case '%':sum%=mul; return;
        }
    }
    void show()
    {
        if(display.length()>0)textView.setText(display);
        else textView.setText("0");
    }
    void reset()
    {
        prev='+';
        mul=0.0;
        sum=0.0;
        display="";
        current=false;
    }
    boolean sign(char a)
    {
        if(a=='+')return true;
        if(a=='-')return true;
        if(a=='x')return true;
        if(a=='/')return true;
        if(a=='%')return true;
        return false;
    }

    void calculate()
    {
        mul=0.0;
        sum=0.0;
        divide=1.0;
        prev='+';
        boolean deci=false;
       for(int i=0;i<display.length();i++)
       {
           char a=display.charAt(i);
           if(sign(a)==true){
               str_update();
               mul=0.0;
               prev=a;
               divide=1.0;
               deci=false;
           }
           else if(a=='.'){
               divide=10.0;
               deci=true;
           }
           else {
               String s="";
               s+=a;
               double temp=Double.parseDouble(s);
               if(deci==false)mul*=10;
               mul+=(temp/divide);
               if(deci==true)divide*=10.0;
           }
       }
       str_update();
       if(sum==(long)sum){
           long temp=(long)sum;
           display=Long.toString(temp);
       }else display=String.format("%.4f",sum);
       mul=0;
       divide=1.0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        textView=findViewById(R.id.textView);
        b0=findViewById(R.id.button29);
        b1=findViewById(R.id.button25);
        b2=findViewById(R.id.button27);
        b3=findViewById(R.id.button26);
        b4=findViewById(R.id.button21);
        b5=findViewById(R.id.button22);
        b6=findViewById(R.id.button23);
        b7=findViewById(R.id.button20);
        b8=findViewById(R.id.button19);
        b9=findViewById(R.id.button18);
        b_eq=findViewById(R.id.button32);
        b_add=findViewById(R.id.button28);
        b_sub=findViewById(R.id.button24);
        b_mul=findViewById(R.id.button17);
        b_mod=findViewById(R.id.button14);
        b_cls=findViewById(R.id.button13);
        b00=findViewById(R.id.button31);
        b_div=findViewById(R.id.button16);
        b_back=findViewById(R.id.button15);
        b_dot=findViewById(R.id.button30);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
               display+='0';
                show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='1';
                show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='2';
                show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='3';
                show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='4';
                show();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='5';
                show();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='6';
                show();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='7';
                show();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='8';
                show();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current==true)reset();
                display+='9';
                show();
            }
        });
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display+="00";
                show();}
        });
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.length()>0){
                    display+='+';
                    show();
                    if(current==true){
                        prev='+';
                        current=false;
                    }
                }

            }
        });
        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.length()>0){
                    display+='-';
                    show();
                    if(current==true){
                        prev='-';
                        current=false;
                    }
                }

            }
        });
        b_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.length()>0){
                    display+='x';
                    show();
                    if(current==true){
                        prev='x';
                        current=false;
                    }
                }

            }
        });
        b_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.length()>0){
                    display+='/';
                    show();
                    if(current==true){
                        prev='/';
                        current=false;
                    }
                }

            }
        });
        b_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.length()>0){
                    display+='%';
                    show();
                    if(current==true){
                        prev='%';
                        current=false;
                    }
                }

            }
        });
        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.length()>0){
                    display+='.';
                    show();
                }

            }
        });
        b_cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display="";
                reset();
                show();
            }
        });
        b_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(current==false){
                   //calculate function here
                   calculate();
                   current=true;
                   show();
               }
            }
        });
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.length()>0)
                {
                    String str=display.substring(0,display.length()-1);
                    display=str;
                }
                show();
            }
        });
    }
}