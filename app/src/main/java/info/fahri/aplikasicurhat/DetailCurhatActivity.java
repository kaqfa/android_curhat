package info.fahri.aplikasicurhat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailCurhatActivity extends AppCompatActivity {

    TextView txtDetailNama, txtDetailKonten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_curhar);
        txtDetailKonten = findViewById(R.id.txtDetailKonten);
        txtDetailNama = findViewById(R.id.txtNamaDetail);
    }

    public void close(View v){
        finish();
    }

    public void deleteCurhat(View v){
        // harusnya dihapus dulu yang di sini
        finish();
    }
}
