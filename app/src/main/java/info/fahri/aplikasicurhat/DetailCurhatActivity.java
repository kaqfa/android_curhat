package info.fahri.aplikasicurhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import info.fahri.aplikasicurhat.apiclient.Curhat;

public class DetailCurhatActivity extends AppCompatActivity {

    TextView txtDetailNama, txtDetailKonten;
    Curhat curhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_curhar);
        txtDetailKonten = findViewById(R.id.txtDetailKonten);
        txtDetailNama = findViewById(R.id.txtNamaDetail);

        Intent it = getIntent();
        curhat = (Curhat) it.getSerializableExtra("current_curhat");
        txtDetailKonten.setText(curhat.getKonten());
        txtDetailNama.setText(curhat.getNama());
    }

    public void close(View v){
        finish();
    }

    public void deleteCurhat(View v){
        // harusnya dihapus dulu yang di sini
        finish();
    }
}
