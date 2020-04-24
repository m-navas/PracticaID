package com.example.android.fingerprintdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DatosRendimiento extends AppCompatActivity {

    TextView tv_total, tv_numFP, tv_numFN, tv_numErr, tv_FRR, tv_FAR, tv_FTA;
    Float fta, frr, far;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_rendimiento);

        tv_total = (TextView)findViewById(R.id.tv_total);
        tv_numFP = (TextView)findViewById(R.id.tv_num_fp);
        tv_numFN = (TextView)findViewById(R.id.tv_num_fn);
        tv_numErr = (TextView)findViewById(R.id.tv_num_err);
        tv_FRR = (TextView)findViewById(R.id.tv_frr);
        tv_FAR = (TextView)findViewById(R.id.tv_far);
        tv_FTA = (TextView)findViewById(R.id.tv_fta);

        actualizarDatos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarDatos();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        actualizarDatos();
    }

    private void actualizarDatos() {
        fta = (float)(MainActivity.numErroresAdq / MainActivity.totalIntentos) * 100f;
        frr = (float)(MainActivity.numFN / MainActivity.totalIntentos) * 100f;
        far = (float)(MainActivity.numFP / MainActivity.totalIntentos) * 100f;

        tv_total.setText("Número total de intentos de acceso: "+ (int)MainActivity.totalIntentos);
        tv_numFN.setText("Número de Falsos Negativos: "+(int)MainActivity.numFN);
        tv_numFP.setText("Número de Falsos Positivos: "+(int)MainActivity.numFP);
        tv_numErr.setText("Número de Errores de Adquisición: "+(int)MainActivity.numErroresAdq);
        tv_FRR.setText("Tasa FRR: "+ frr +" %");
        tv_FAR.setText("Tasa FAR: "+ far +" %");
        tv_FTA.setText("Tasa FTA: "+ fta + " %");
    }
}
