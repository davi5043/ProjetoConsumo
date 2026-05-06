package br.ulbra.projetoconsumo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCalcular;
    EditText edtNomeA, edtPotencia,edtHoras,edtPreco;
    TextView txtCalcu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtHoras = findViewById(R.id.edtHoras);
        edtNomeA = findViewById(R.id.edtNomeA);
        edtPotencia = findViewById(R.id.edtPotencia);
        edtPreco = findViewById(R.id.edtPreco);
        txtCalcu = findViewById(R.id.txtCalcu);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double potencia, preco, horas, CE , C;
                potencia = Double.parseDouble(edtPotencia.getText().toString());
                horas = Double.parseDouble(edtHoras.getText().toString());
                preco = Double.parseDouble(edtPreco.getText().toString());


                CE = potencia * horas / 1000;
                C = CE * preco;

                if (potencia <= 0 || horas <= 0 || preco <= 0) {
                    Toast.makeText(MainActivity.this, "Os valores devem ser maiores que zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String r =
                        "Aparelho: " + edtNomeA.getText().toString() +
                                "\nConsumo Diário: " + CE + "kWh" +
                                "\nCusto estimado: R$" + C;

                txtCalcu.setText(r);
            }
        });

    }
}