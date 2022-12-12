package info.fahri.aplikasicurhat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormCurhatActivity extends AppCompatActivity {

    EditText edtCurhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_curhat);
        edtCurhat = findViewById(R.id.edtCurhat);
    }

    public void postCurhat(View v){
        finish();
    }
}
