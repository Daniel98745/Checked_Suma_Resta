package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText cj1,cj2;
    private TextView tvResul;
    private Button btnOp;
    private CheckBox chS, chR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cargarR();
        estadoBoton();
    }
    public void cargarR(){
        cj1 = (EditText) findViewById(R.id.txt1);
        cj2 = (EditText) findViewById(R.id.txt2);
        tvResul = (TextView) findViewById(R.id.tvR);
        chR = (CheckBox) findViewById(R.id.chResta);
        chS = (CheckBox) findViewById(R.id.chSuma);
        btnOp = (Button) findViewById(R.id.btnOperar);
    }

    //procedimiento para los estados del evento onclick
    public void estadoBoton(){
        btnOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //operacion de suma and resta
                String valor1 = cj1.getText().toString();
                String valor2 = cj2.getText().toString();
                int nro1 = Integer.parseInt(valor1);
                int nro2 = Integer.parseInt(valor2);
                String resu = "";
                if (chS.isChecked() == true){
                    int suma = nro1 + nro2;
                    resu = "La suma es "+suma;
                }
                if (chR.isChecked() == true){
                    int resta = nro1 - nro2;
                    resu = "La resta es "+resta;
                }
                tvResul.setText(resu);
            }
        });
    }
}