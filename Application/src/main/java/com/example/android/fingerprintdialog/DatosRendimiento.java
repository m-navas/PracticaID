package com.example.android.fingerprintdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat("#.00");
        fta = (float)(MainActivity.numErroresAdq / MainActivity.totalIntentos) * 100f;
        frr = (float)(MainActivity.numFN / MainActivity.totalIntentos) * 100f;
        far = (float)(MainActivity.numFP / MainActivity.totalIntentos) * 100f;

        tv_total.setText("Número total de intentos de acceso: "+ (int)MainActivity.totalIntentos);
        tv_numFN.setText("Número de Falsos Negativos: "+(int)MainActivity.numFN);
        tv_numFP.setText("Número de Falsos Positivos: "+(int)MainActivity.numFP);
        tv_numErr.setText("Número de Errores de Adquisición: "+(int)MainActivity.numErroresAdq);
        if(MainActivity.totalIntentos == 0){
            tv_FRR.setText("Tasa FRR: 0.00 %");
            tv_FAR.setText("Tasa FAR: 0.00 %");
            tv_FTA.setText("Tasa FTA: 0.00 %");
        }else {
            tv_FRR.setText("Tasa FRR: "+ (float)Math.round(frr * 100f) / 100f +" %");
            tv_FAR.setText("Tasa FAR: "+ (float)Math.round(far * 100f) / 100f +" %");
            tv_FTA.setText("Tasa FTA: "+ (float)Math.round(fta * 100f) / 100f + " %");
        }

    }
}
