package info.fahri.aplikasicurhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNamaUser;
    SharedPreferences sharedPref;
    static String KEY_USER = "nama_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNamaUser = findViewById(R.id.edtNama);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String namaUser = sharedPref.getString(MainActivity.KEY_USER, null);
        if (namaUser != null){
            startActivity(new Intent(this, DashboardActivity.class));
        }
    }

    public void login(View v){
        String namaUser = edtNamaUser.getText().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY_USER, namaUser);
        editor.commit();

        startActivity(new Intent(this, DashboardActivity.class));
    }
}
