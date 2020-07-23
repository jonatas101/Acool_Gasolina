package com.jvapp.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtInput_alcool, txtInput_gasolina;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput_alcool = findViewById(R.id.txtInput_Alcool);
        txtInput_gasolina = findViewById(R.id.txtInput_gasolina);
        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void calcular(View view) {

        String preco_alcool = txtInput_alcool.getText().toString();
        String preco_gasolina = txtInput_gasolina.getText().toString();

        Boolean camposValidados = validarCampos(preco_alcool, preco_gasolina);

        if (camposValidados) {
            double alcool = Double.parseDouble(preco_alcool);
            double gasolina = Double.parseDouble(preco_gasolina);

            if (alcool / gasolina >= 0.7) {
                txtResultado.setText("Melhor utilizar Gasolina");
            } else {
                txtResultado.setText("Melhor utilizar Álcool");
            }
        } else {
            txtResultado.setText("Preencha os campos primeiro!");
        }


    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}