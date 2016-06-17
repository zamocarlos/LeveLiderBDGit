package xyz.levelider.leveliderbd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //atributos
    Button btnEnviar;
    ListView lista;
    EditText eTNombre;
    EditText eTCota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        //elementos interface
        btnEnviar = (Button)findViewById(R.id.btn_enviar);
        lista = (ListView)findViewById(R.id.list_view);
        eTNombre = (EditText)findViewById(R.id.et_nombre);
        eTCota = (EditText)findViewById(R.id.et_cota);

    }
    //eventos click
    public void onClick(View v) {
        if (v.getId()==R.id.btn_enviar) {
            //Click en enviar


        }
    }


}


