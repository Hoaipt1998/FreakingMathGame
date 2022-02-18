package com.android30112021.freakingmathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button mbuttonTrue, mbuttonFalse;
    TextView mtextViewResult, mtextViewScore, mtextViewNumber1,mtextViewNumber2,mtextViewPhepToan;
    int Score = 0;
    String result1 ="";
    String result ="";
    int SizePT = 4;
    int SizeNo1 = 9;
    int SizeNo2 = 9;
    String Number1="";
    String Number2="";
    String pheptoan="";
    boolean bool;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbuttonFalse = findViewById(R.id.buttonFalse);
        mbuttonTrue = findViewById(R.id.buttonTrue);
        mtextViewNumber1 = findViewById(R.id.number1);
        mtextViewNumber2 = findViewById(R.id.number2);
        mtextViewResult = findViewById(R.id.result);
        mtextViewScore = findViewById(R.id.textviewScore);
        mtextViewPhepToan = findViewById(R.id.pheptoan);
        createPhepToan();



        mbuttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bool)
                {
                    Score = Score+1;
                }
                mtextViewScore.setText(Score+"");
                createPhepToan();

            }
        });
        mbuttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result1 != result)
                {
                    Score = Score+1;
                }
                mtextViewScore.setText(Score+"");
                createPhepToan();

            }
        });
        mtextViewScore.setText(Score+"");




    }

    private void createPhepToan() {
        Random rd = new Random();   // khai báo 1 đối tượng Random

        // trả về 1 biến bool có giá trị là true hoặc false.
        bool = rd.nextBoolean();
        ArrayList<Integer> listPT = new ArrayList<Integer>(SizePT);
        for(int i = 1; i <= SizePT; i++) {
            listPT.add(i);
        }

        ArrayList<Integer> listNo1 = new ArrayList<Integer>(SizeNo1);
        for(int i = 1; i <= SizeNo1; i++) {
            listNo1.add(i);
        }

        ArrayList<Integer> listNo2 = new ArrayList<Integer>(SizeNo2);
        for(int i = 1; i <= SizeNo2; i++) {
            listNo2.add(i);
        }



        Log.d("BBB", "bool" + bool);


        Random Rand1 = new Random();
        //Rand1.nextInt(10); -- Add phần tử tự động.
        int indexNo1  = Rand1.nextInt(listNo1.size());
        Number1 = (String.valueOf(listNo1.get(indexNo1)));
        mtextViewNumber1.setText(Number1);

        Log.d("BBB", "no1" + Number1);




        Random Rand2 = new Random();
        int indexNo2  = Rand2.nextInt(listNo2.size());
        Number2 = (String.valueOf(listNo2.get(indexNo2)));
        mtextViewNumber2.setText(Number2);

        Log.d("BBB", "no2" + Number2);



        Random Rand = new Random();
        int indexPT  = Rand.nextInt(listPT.size());
        int NumberPT = listPT.get(indexPT);
        Log.d("BBB", "PPT" + NumberPT);
        if(listPT.get(indexPT)==1)
        {
            pheptoan="+";
            result = String.valueOf( Integer.valueOf(Number1) + Integer.valueOf(Number2));
            mtextViewPhepToan.setText("+");
        }
        else if (listPT.get(indexPT)==2)
        {
            pheptoan="-";
            result = String.valueOf( Integer.valueOf(Number1) - Integer.valueOf(Number2));
            mtextViewPhepToan.setText("-");
        }
        else if (listPT.get(indexPT)==3)
        {
            pheptoan="*";
            result = String.valueOf( Integer.valueOf(Number1) * Integer.valueOf(Number2));
            mtextViewPhepToan.setText("*");
        }
        else
        {
            pheptoan="/";
            result = String.format("%.02f",(Float.valueOf(Number1) / Float.valueOf(Number2)));
            mtextViewPhepToan.setText("/");
        }

        if(bool == true)
        {
            result1 = result;
            mtextViewResult.setText(String.valueOf(result1));
        }
        else
        {

            Random Rand3 = new Random();
            Float resultTemp = 0.f;
            resultTemp = Float.valueOf(result) + Rand3.nextInt(5)+1;
            result1 = String.valueOf(resultTemp);
            mtextViewResult.setText(result1);
        }
    }
}