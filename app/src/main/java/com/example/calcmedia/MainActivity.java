package com.example.calcmedia;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNota01, edtNota02;
    private Button btCalc, btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        edtNota01 = findViewById(R.id.edtNota01);
        edtNota02 = findViewById(R.id.edtNota02);
        btCalc = findViewById(R.id.btCalc);
        btLimpar = findViewById(R.id.btLimpar);

        // Set onClick listener for Calcular button
        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });

        // Set onClick listener for Limpar button
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    // Method to calculate the average of the two grades
    private void calculateAverage() {
        String nota1Str = edtNota01.getText().toString();
        String nota2Str = edtNota02.getText().toString();

        if (TextUtils.isEmpty(nota1Str) || TextUtils.isEmpty(nota2Str)) {
            Toast.makeText(this, "Por favor, insira ambas as notas.", Toast.LENGTH_SHORT).show();
            return;
        }

        double nota1 = Double.parseDouble(nota1Str);
        double nota2 = Double.parseDouble(nota2Str);

        double media = (nota1 + nota2) / 2;

        Toast.makeText(this, "Média: " + media, Toast.LENGTH_LONG).show();
    }

    // Method to clear the input fields
    private void clearFields() {
        edtNota01.setText("");
        edtNota02.setText("");
        Toast.makeText(this, "Campos limpos.", Toast.LENGTH_SHORT).show();
    }
}