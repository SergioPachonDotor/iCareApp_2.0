package co.edu.unab.icareapp20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class LoggedInActivity extends AppCompatActivity {

    public static final String imc = "";
    public static final String mbs = "";

    EditText edad;
    EditText peso;
    EditText altura;
    Spinner genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        
        Button estimateBtn = findViewById(R.id.boton_calculo);
        estimateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imc_final = calcularimc();
                String mbasal_final = calcularmbasal();
                Intent intent = new Intent(LoggedInActivity.this, ResultsActivity.class);
                intent.putExtra(imc, imc_final);
                intent.putExtra(mbs,mbasal_final);
                startActivity(intent);
                finish();
            }
        });
    }

    public void sendResults(View view) {
        String imc_final = calcularimc();
        String mbasal_final = calcularmbasal();
        Intent intent = new Intent(LoggedInActivity.this, ResultsActivity.class);
        intent.putExtra(imc, imc_final);
        intent.putExtra(mbs,mbasal_final);
        startActivity(intent);
        finish();
    }

    public String calcularimc(){
        try {
            double peso_d = Double.parseDouble(peso.getText().toString());
            double altura_d = Double.parseDouble(altura.getText().toString());
            double imc_d  = peso_d / altura_d * altura_d;
            String resultado = "Su IMC es: "+imc_d;
            return resultado;
        }
        catch (Exception exception){
            String message = "Por favor ingresa los datos";
            return message;
        }

    }

    public String calcularmbasal(){
        String resultado = null;
        String gender = null;
        try {
            gender = genero.getSelectedItem().toString();
            double peso_d = Double.parseDouble(peso.getText().toString());
            double altura_d = Double.parseDouble(altura.getText().toString());
            double edad_d = Double.parseDouble(edad.getText().toString());
            double mbasal_hombre = ( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)+5;
            double mbasal_mujer =( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)-161;
            if (gender.equals("Masculino")){
                resultado = "Su metabolismo basal es: "+mbasal_hombre;
            }
            else if (gender.equals("Femenino")){
                resultado = "Su metabolismo basal es: "+mbasal_mujer;
            }
        }
        catch (Exception exception){
            String message = "Por favor ingresa los datos";
            return message;
        }
        return resultado;
    }
}