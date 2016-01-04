package gabilam.com.loginexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseRef = new Firebase(ExampleApplication.FIREBASE_URL);

        final EditText emailView = (EditText)findViewById(R.id.email);
        final EditText passwordView = (EditText)findViewById(R.id.password);

        findViewById(R.id.sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseRef.createUser(emailView.getText().toString(), passwordView.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        Toast.makeText(SignUpActivity.this, "User Created Please Log in", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Toast.makeText(SignUpActivity.this,firebaseError.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
