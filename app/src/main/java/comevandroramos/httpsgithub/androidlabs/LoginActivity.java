package comevandroramos.httpsgithub.androidlabs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";

    EditText userInput, passwordInput;
    Button buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        userInput = (EditText) findViewById(R.id.LogIn);
        passwordInput = (EditText) findViewById(R.id.textPassword);
        buttonClick = (Button) findViewById(R.id.buttonLogIn);

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(
                        "myPreferences",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("defaultEmail", userInput.getText().toString());
                edit.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(
                "myPreferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        userInput.setText(sharedPreferences.getString("defaultEmail", "ramo0045@algonquinlive.com"));
        edit.commit();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
