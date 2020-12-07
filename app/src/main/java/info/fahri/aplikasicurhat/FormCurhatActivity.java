package info.fahri.aplikasicurhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import info.fahri.aplikasicurhat.apiclient.APIClient;
import info.fahri.aplikasicurhat.apiclient.Curhat;
import info.fahri.aplikasicurhat.apiclient.CurhatInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormCurhatActivity extends AppCompatActivity {

    EditText edtCurhat;
    SharedPreferences sharedPref;
    CurhatInterface curhatInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_curhat);

        edtCurhat = findViewById(R.id.edtCurhat);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        curhatInterface = APIClient.getClient().create(CurhatInterface.class);
    }

    public void postCurhat(View v){
        String konten = edtCurhat.getText().toString();
        String namaUser = sharedPref.getString(MainActivity.KEY_USER, "");
        Call<Curhat> postCurhat = curhatInterface.postCurhat(namaUser, konten);

        postCurhat.enqueue(new Callback<Curhat>() {
            @Override
            public void onResponse(Call<Curhat> call, Response<Curhat> response) {
                Log.d("post_curhat: ", response.toString());
            }

            @Override
            public void onFailure(Call<Curhat> call, Throwable t) {
                Log.e("error_curhat: ", t.getMessage());
            }
        });

        finish();
    }
}
