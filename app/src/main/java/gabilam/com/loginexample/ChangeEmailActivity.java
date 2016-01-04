package gabilam.com.loginexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class ChangeEmailActivity extends AppCompatActivity {

    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        mFirebaseRef = new Firebase(ExampleApplication.FIREBASE_URL);

        final EditText oldEmailView = (EditText)findViewById(R.id.old_email);
        final EditText newEmailView = (EditText)findViewById(R.id.new_email);
        final EditText passwordView = (EditText)findViewById(R.id.password);

        findViewById(R.id.change_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mFirebaseRef.changeEmail(oldEmailView.getText().toString(), newEmailView.getText().toString(), passwordView.getText().toString(), new Firebase.ResultHandler() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(ChangeEmailActivity.this,"Email Changed",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Toast.makeText(ChangeEmailActivity.this,firebaseError.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


}
