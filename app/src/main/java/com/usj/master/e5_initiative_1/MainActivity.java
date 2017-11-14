package com.usj.master.e5_initiative_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.usj.master.e5_initiative_1.core.IParameters;

public class MainActivity extends AppCompatActivity {
    private EditText name, pass, mail;
    private RadioGroup radioGroup;
    private RadioButton checkedRadioButton;
    private Spinner spinner;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Meto opciones de país al spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] opciones = {"España", "Venezuela", "Cuba", "Puerto Rico", "República Dominicana"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        name = findViewById(R.id.tName);
        pass = findViewById(R.id.tPass);
        mail = findViewById(R.id.tMail);


        toggleButton = findViewById(R.id.tb1);
        radioGroup = findViewById(R.id.radioGroup);

    }

    public void sendForm(View v) {
        if(isValidEmail(mail.getText().toString())) {
            Intent i = new Intent(this, SecondActivity.class);

            i.putExtra(IParameters.NAME, name.getText().toString());
            i.putExtra(IParameters.PASSWORD, pass.getText().toString());
            i.putExtra(IParameters.MAIL, mail.getText().toString());

            int radioButtonID = radioGroup.getCheckedRadioButtonId();
            View radioButton = radioGroup.findViewById(radioButtonID);
            int idx = radioGroup.indexOfChild(radioButton);
            checkedRadioButton = (RadioButton) radioGroup.getChildAt(idx);

            i.putExtra(IParameters.GENDER, checkedRadioButton.getText().toString());
            i.putExtra(IParameters.COUNTRY, spinner.getSelectedItem().toString());
            i.putExtra(IParameters.ADVERTS, toggleButton.isChecked());

            startActivity(i);
        } else {
            Toast.makeText(this, "Por favor, introduzca una dirección de email válida.", Toast.LENGTH_LONG).show();
        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
