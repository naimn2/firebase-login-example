package muflihun.naim.myfirstloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        auth = FirebaseAuth.getInstance();

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                login();
//            }
//        });

    }

    public void login(View v) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // firebase login
        auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // login berhasil
                    Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                    // TODO tugas nu pindah ke activity beranda
                } else {
                    // login gagal
                    Toast.makeText(MainActivity.this, "Gagal login", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}