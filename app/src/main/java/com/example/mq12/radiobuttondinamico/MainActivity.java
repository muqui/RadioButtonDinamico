package com.example.mq12.radiobuttondinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linearMain;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button boton;
    ArrayList<String> local = new ArrayList<String>();
    ArrayList<String> visita = new ArrayList<String>();
    List<RadioGroup> listRadioGroup = new ArrayList<RadioGroup>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearMain = (LinearLayout) findViewById(R.id.linearMain);
        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(this);

        local.add("Morelia");
        local.add("Tijuana");
        local.add("Lobos BUAP");
        local.add("Tigres");
        local.add("Leon");
        local.add("America");
        local.add("Guadalajara");
        local.add("UNAM");
        local.add("Veracruz");

        visita.add("Monterrey");
        visita.add("Cruz Azul");
        visita.add("Santos");
        visita.add("Puebla");
        visita.add("Atlas");
        visita.add("Queretaro");
        visita.add("Toluca");
        visita.add("Pachuca");
        visita.add("NEcaxa");
        for (int i = 0; i < local.size(); i++) {
            radioGroup = new RadioGroup(this);
            listRadioGroup.add(radioGroup);
            radioGroup.setOrientation(LinearLayout.HORIZONTAL);
            radioGroup.setId(i);
            linearMain.addView(radioGroup);

            radioButton = new RadioButton(this);
            radioButton.setText(local.get(i));
            radioGroup.addView(radioButton);
            radioButton.setChecked(true);

            radioButton = new RadioButton(this);
            radioButton.setText("Empate");
            radioGroup.addView(radioButton);


            radioButton = new RadioButton(this);
            radioButton.setText(visita.get(i));
            radioGroup.addView(radioButton);





        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                enviar();
                break;
        }
    }

    private void enviar() {
        String checked = "";
        for(RadioGroup grupo : listRadioGroup){
        int seleccion = grupo.getCheckedRadioButtonId();
            RadioButton radioButton =(RadioButton) findViewById(seleccion);
            Log.d("ON_CLICK", "CheckBoxINTz ID:" +   seleccion);
            checked += radioButton.getText()+ " \n";
        }



        Toast.makeText(this, checked, Toast.LENGTH_SHORT).show();

    }
}
