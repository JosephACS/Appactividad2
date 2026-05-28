package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtAlumnos =findViewById(R.id.editTextTextMultiLine3);

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://xmcstjclxkefrdzbyynk.supabase.co/rest/v1/alumnos",
                null,
                response -> {
                    try {
                        StringBuilder texto = new StringBuilder();
                        for (int i = 0; i < response.length(); i++){
                            JSONObject jsonRegistro = response.getJSONObject(i);
                            texto.append((i+1) + ".- Nombres: " + jsonRegistro.optString("No.","") + "\n");
                            texto.append("Correo " + jsonRegistro.optString("CÉDULA","")+ "\n");
                            texto.append("Paralelo " + jsonRegistro.optString("APELLIDOS Y NOMBRES","")+ "\n");
                            texto.append("Periodo " + jsonRegistro.optString("CORREO INSTITUCIONAL","")+ "\n\n");
                            texto.append("Periodo " + jsonRegistro.optString("CORREO INSTITUCIONAL MICROSOFT","")+ "\n\n");
                        }
                        //texto.append(agregarAlumnosALista(data.getJSONObject(i), i+1));
                        txtAlumnos.setText(texto.toString());

                    } catch (Exception e) {
                        txtAlumnos.setText("Error procesando datos:\n" + e.getMessage());
                    }
                },
                //new ApiErrorListener(this)
                error -> txtAlumnos.setText("Error API:\n" + error.getMessage())
        )
        {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("apikey", "");
                return headers;
            }
        };

        queue.add(request);
    }

}