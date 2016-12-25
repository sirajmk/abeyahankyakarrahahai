package com.amigosphire_poc.demo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.amigosphire_poc.R;
import com.amigosphire_poc.demo.utils.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    private String TAG = "RegistrationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupCitySpinner();
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("JP Nagar");
        categories.add("RT Nagar");
        categories.add("RajajiNagar");
        categories.add("Hebbal");
        categories.add("Mosque Road");
        setupAreaSpinner(categories);
        setupProfessionSpinner();
        setupSpecializationSpinner();

        Button createAccountButton = (Button) findViewById(R.id.create_account);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(RegistrationActivity.this,AmigoLandingActivity.class);
                //startActivity(intent);
                userRegistrationRequest();
                //finish();
            }
        });
    }

    void setupCitySpinner() {
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.city);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Bangalore");
        categories.add("Mysore");
        categories.add("Chennai");
        categories.add("Mumbai");
        categories.add("Hyderabad");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    void setupAreaSpinner(List<String> areaList) {
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.area);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("JP Nagar");
        categories.add("RT Nagar");
        categories.add("RajajiNagar");
        categories.add("Hebbal");
        categories.add("Mosque Road");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    void setupProfessionSpinner() {
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.profession);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Doctor");
        categories.add("Lawyer");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    void setupSpecializationSpinner() {
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.specialization);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Dentist");
        categories.add("Pediatrician");
        categories.add("General Physician");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    private void userRegistrationRequest() {
        //TODO url format to be updated for user registration
        String url = "http://7amigos.000webhostapp.com/interapi.php/dmolnyde";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG,"*** response success" + response);

                        //showProgress(false);
                        /*if(response != null) {
                        if(REGISTRATION_SUCCESSFUL.equals(response) || USER_REGISTERED_ALREADY.equals(response)) {
                            Toast.makeText(getApplication(), response, Toast.LENGTH_LONG).show();
                            Intent I = new Intent(RegistrationActivity.this,LoginActivity.class);
                            startActivity(I);

                            finish();
                        }

                        if(WEAK_PASSWORD.equals(response)) {
                            mPasswordView.setError(getString(R.string.weak_password));
                            mPasswordView.requestFocus();
                        }

                        if(INVALID_EMAIL.equals(response)) {
                            mEmailView.setError(getString(R.string.weak_password));
                            mEmailView.requestFocus();
                        } */
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,"*** response failure " + error.getMessage());
                // TODO Auto-generated method stub
                //showProgress(false);
                Toast.makeText(getApplicationContext(),"invalid username or password",Toast.LENGTH_LONG).show();
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}