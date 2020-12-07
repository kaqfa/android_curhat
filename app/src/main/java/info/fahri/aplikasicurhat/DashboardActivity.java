package info.fahri.aplikasicurhat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import info.fahri.aplikasicurhat.adapter.CurhatAdapter;
import info.fahri.aplikasicurhat.apiclient.APIClient;
import info.fahri.aplikasicurhat.apiclient.Curhat;
import info.fahri.aplikasicurhat.apiclient.CurhatInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    CurhatInterface curhatInterface;
    RecyclerView recCurhat;
    CurhatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initFab();

        recCurhat = findViewById(R.id.rec_curhat);
        recCurhat.setLayoutManager(new LinearLayoutManager(this));

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String namaUser = sharedPref.getString(MainActivity.KEY_USER, null);

        curhatInterface = APIClient.getClient().create(CurhatInterface.class);

        Snackbar.make(toolbar, "Anda login sebagai: "+namaUser, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllCurhat();
    }

    private void getAllCurhat(){
        Call<List<Curhat>> getCurhat = curhatInterface.getCurhat();
        getCurhat.enqueue(new Callback<List<Curhat>>() {
            @Override
            public void onResponse(Call<List<Curhat>> call, Response<List<Curhat>> response) {
                ArrayList<Curhat> listCurhat = (ArrayList<Curhat>) response.body();
                Log.d("list_curhat: ", response.raw().toString());
                Log.d("list_curhat: ", listCurhat.toString());

                adapter = new CurhatAdapter(listCurhat);
                recCurhat.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Curhat>> call, Throwable t) {
                Log.e("error_curhat: ", t.getMessage());
            }
        });
    }

    private void initFab(){
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), FormCurhatActivity.class));
            }
        });

        FloatingActionButton fabLogOff = findViewById(R.id.fabLogoff);
        fabLogOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.remove(MainActivity.KEY_USER);
                editor.apply();
                finish();
            }
        });
    }

}
