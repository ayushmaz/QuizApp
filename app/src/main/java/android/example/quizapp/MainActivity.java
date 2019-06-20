package android.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean question1_checked;
    boolean question1_answer;
    boolean question2_checked;
    boolean question2_answer;
    boolean question3_checked;
    boolean question3_answer;
    boolean question4_checked;
    boolean question4_answer;
    boolean question5_answer;
    boolean question6_answer;
    boolean isAgreementCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onQuestion1RadioButtonClicked(View view){
        question1_checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.north_korea:
                question1_answer = true;
                break;
            case R.id.spain:
                question1_answer = false;
                break;
            case R.id.mexico:
                question1_answer = false;
                break;
            case R.id.china:
                question1_answer = false;
                break;
        }
    }

    public void onQuestion2RadioButtonClicked(View view){
        question2_checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.roma:
                question2_answer = false;
                break;
            case R.id.milan:
                question2_answer = false;
                break;
            case R.id.inter:
                question2_answer = false;
                break;
            case R.id.juventus:
                question2_answer = true;
                break;
        }
    }

    public void onQuestion3RadioButtonClicked(View view){
        question3_checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.marseille:
                question3_answer = false;
                break;
            case R.id.saint:
                question3_answer = false;
                break;
            case R.id.psg:
                question3_answer = false;
                break;
            case R.id.monaco:
                question3_answer = true;
                break;
        }
    }

    public void onQuestion4RadioButtonClicked(View view){
        question4_checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.wolfsburg:
                question4_answer = true;
                break;
            case R.id.dortmund:
                question4_answer = false;
                break;
            case R.id.bayern:
                question4_answer = false;
                break;
            case R.id.freiburg:
                question4_answer = false;
                break;
        }
    }

    public void onQuestion5CheckboxClicked(View view){
        CheckBox cristiano_checkbox = (CheckBox) findViewById(R.id.cristiano_checkbox);
        CheckBox messi_checkbox = (CheckBox) findViewById(R.id.messi_checkbox);
        CheckBox neymar_checkbox = (CheckBox) findViewById(R.id.neymar_checkbox);
        CheckBox zizou_checkbox = (CheckBox) findViewById(R.id.zizou_checkbox);



        boolean isCristiano = cristiano_checkbox.isChecked();
        boolean isMessi = messi_checkbox.isChecked();
        boolean isNeymar = neymar_checkbox.isChecked();
        boolean isZizou = zizou_checkbox.isChecked();


        if(isCristiano && isMessi && !isNeymar  && !isZizou){
            question5_answer = true;
        }

        else
            question5_answer = false;
    }




    public void onAgreementCheckboxClicked(View view){
        isAgreementCheckbox = ((CheckBox) view).isChecked();
    }

    public void onSubmit(View view){
        EditText question6textView = (EditText) findViewById(R.id.question6_answer_view);
        String text = question6textView.getText().toString();

        if(text.toUpperCase().equals("FRANCE"))
            question6_answer = true;
        else
            question6_answer =false;

        if(isAgreementCheckbox){
            int countCorrect = 0;
            if(question1_answer)
                countCorrect++;
            if (question2_answer)
                countCorrect++;
            if (question3_answer)
                countCorrect++;
            if (question4_answer)
                countCorrect++;
            if (question5_answer)
                countCorrect++;
            if (question6_answer)
                countCorrect++;



            String resultText = countCorrect + " out of 6 are correct";
            int duration = Toast.LENGTH_LONG;
            Toast.makeText(getApplicationContext() , resultText , duration).show();
        }
        else {
            String warningText = "Please accept the terms and condition";
            Toast.makeText(getApplicationContext() , warningText , Toast.LENGTH_LONG).show();
        }





    }


}
