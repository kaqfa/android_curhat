package info.fahri.aplikasicurhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import info.fahri.aplikasicurhat.apiclient.APIClient;
import info.fahri.aplikasicurhat.apiclient.Curhat;
import info.fahri.aplikasicurhat.apiclient.CurhatInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailCurhatActivity extends AppCompatActivity {

    TextView txtDetailNama, txtDetailKonten;
    Curhat curhat;

    CurhatInterface curhatInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_curhat);
        txtDetailKonten = findViewById(R.id.txtDetailKonten);
        txtDetailNama = findViewById(R.id.txtNamaDetail);

        Intent it = getIntent();
        curhat = (Curhat) it.getSerializableExtra("current_curhat");
        txtDetailNama.setText(curhat.getNama());
        txtDetailKonten.setText(curhat.getKonten());
    }

    public void close(View v){
        finish();
    }

    public void deleteCurhat(View v){
        curhatInterface = APIClient.getClient().create(CurhatInterface.class);
        Call<Curhat> delCurhat = curhatInterface.delCurhat(curhat.getId());
        delCurhat.enqueue(new Callback<Curhat>() {
            @Override
            public void onResponse(Call<Curhat> call, Response<Curhat> response) {
                Log.d("delete_curhat: ", response.toString());
            }

            @Override
            public void onFailure(Call<Curhat> call, Throwable t) {
                Log.e("error_curhat: ", t.getMessage());
            }
        });
        finish();
    }
}
