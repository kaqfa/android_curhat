package info.fahri.aplikasicurhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtRegEmail, edtRegPassword, edtRegNama, edtRegConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegNama = findViewById(R.id.edtRegNama);
        edtRegPassword = findViewById(R.id.edtRegPassword);
        edtRegConfirm = findViewById(R.id.edtRegConfirm);
    }

    public void register(View v){
        String email, nama, password, confirm;
        email = edtRegEmail.getText().toString();
        nama = edtRegNama.getText().toString();
        password = edtRegPassword.getText().toString();
        confirm = edtRegConfirm.getText().toString();

        if(password.equals(confirm)){
            startActivity(new Intent(this, DashboardActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        } else {
            Toast.makeText(this,"Password dan Konfirmasi tidak sama", Toast.LENGTH_LONG).show();
        }
    }

    public void toLogin(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}