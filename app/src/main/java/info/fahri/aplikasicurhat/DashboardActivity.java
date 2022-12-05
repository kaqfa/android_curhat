package info.fahri.aplikasicurhat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import info.fahri.aplikasicurhat.adapter.CurhatAdapter;
import info.fahri.aplikasicurhat.apiclient.Curhat;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
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

        sharedPref = getSharedPreferences(MainActivity.KEY_USER, Context.MODE_PRIVATE);
        String namaUser = sharedPref.getString(MainActivity.KEY_USER, null);
        Snackbar.make(toolbar, "Anda login sebagai: "+namaUser, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllCurhat();
    }

    private void getAllCurhat(){
        ArrayList<Curhat> listCurhat = new ArrayList<>();
        listCurhat.add(new Curhat(1, "Sembarang", "Contoh curhatan yang benar"));
        listCurhat.add(new Curhat(1, "Sembarang", "sesungguhnya semua curhatan adalah benar, kecuali yang salah."));
        listCurhat.add(new Curhat(1, "Sembarang", "Sudah contohnya cukup 3 aja"));
        adapter = new CurhatAdapter(listCurhat);
        recCurhat.setAdapter(adapter);
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
