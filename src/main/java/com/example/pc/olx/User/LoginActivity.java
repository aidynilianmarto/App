package com.example.pc.olx.User;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.olx.MessageActivity;
import com.example.pc.olx.Offer.AddOfferActivity;
import com.example.pc.olx.SendMessageActivity;
import com.example.pc.olx.Shop.HomeActivity;
import com.example.pc.olx.R;
import com.example.pc.olx.Shop.SettingsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.editTxtUsernameLog);
        password = (EditText) findViewById(R.id.editTxtPasswordLog);
        login = (Button) findViewById(R.id.buttonLogin);
        register = (Button) findViewById(R.id.btnRegister);

        String user = null;
        String pass = null;

        String json = this.getSharedPreferences("OLX",MODE_PRIVATE).getString("loggedUser", "No logged user");
        Log.e("peshko", json);
        if(!json.equals("No logged user")) {
            try {
                JSONArray logU = new JSONArray(json);
                JSONObject j1 = logU.getJSONObject(0);
                Log.e("peshko", j1.toString());

                user = j1.getString("username");
                Log.e("peshko", user);
                pass = j1.getString("password");
                Log.e("peshko", pass);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            username.setText(user);
            password.setText(pass);
        }


        prefs = this.getSharedPreferences("OLX",MODE_PRIVATE);
        editor = prefs.edit();

        final Intent intent = getIntent();
        final String logged = intent.getStringExtra("login");



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().isEmpty()){
                    username.setError("Please enter your username");
                    username.requestFocus();
                    return;
                }
                if(password.getText().toString().isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                    return;
                }

                if (!UserManager.getInstance(LoginActivity.this).isLogin(username.getText().toString(), password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Sorry, user with that username and password doesn't exist!", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                    return;
                }

                switch (logged){
                    case "message":
                        Intent intent1 = new Intent(LoginActivity.this,MessageActivity.class);
                        intent1.putExtra("login",username.getText().toString());
                        startActivity(intent1);
                        finish();
                        return;
                    case "addOffer":
                        Intent intent2 = new Intent(LoginActivity.this,AddOfferActivity.class);
                        intent2.putExtra("login",username.getText().toString());
                        startActivity(intent2);
                        finish();
                        return;
                    case "settings":
                        Intent intent3 = new Intent(LoginActivity.this,SettingsActivity.class);
                        intent3.putExtra("login",username.getText().toString());
                        startActivity(intent3);
                        finish();
                        return;
                    case "writeMessage":
                        String receiver = intent.getStringExtra("receiver");
                        String offersTitle = intent.getStringExtra("title");
                        Intent intent4 = new Intent(LoginActivity.this,SendMessageActivity.class);
                        intent4.putExtra("sender",username.getText().toString());
                        intent4.putExtra("receiver" , receiver);
                        intent4.putExtra("title" ,offersTitle);
                        startActivity(intent4);
                        finish();
                        return;
                }
                Intent intent = new Intent(LoginActivity.this,UserHomeActivity.class);
                intent.putExtra("login",username.getText().toString());
                JSONArray jar = new JSONArray();
                JSONObject user = new JSONObject();
                try {
                    user.put("username", username.getText().toString());
                    user.put("password", password.getText().toString());
                    jar.put(user);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                editor.putString("loggedUser", jar.toString());

                editor.commit();
                startActivity(intent);
                finish();


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                username.setError(null);
                password.setError(null);
                startActivity(intent2);
            }
        });


    }
}

