package gabilam.com.loginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends AppCompatActivity {

    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseRef = new Firebase(ExampleApplication.FIREBASE_URL);

        final EditText emailView = (EditText)findViewById(R.id.email);
        final EditText passwordView = (EditText)findViewById(R.id.password);

        findViewById(R.id.sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseRef.authWithPassword(emailView.getText().toString(), passwordView.getText().toString(), new AuthResultHandler());
            }
        });

        findViewById(R.id.sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     * Firebase Authentication result class
     */
    private class AuthResultHandler implements Firebase.AuthResultHandler {

        public AuthResultHandler() {

        }

        @Override
        public void onAuthenticated(AuthData authData) {

            if (authData.getProvider().toLowerCase().equals("password")) {

                Intent i = new Intent(MainActivity.this, ChangeEmailActivity.class);
                startActivity(i);
            }
        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {

            Log.d("LOGIN","Firebase Error: " + firebaseError.getMessage());
        }
    }
}
