package mx.ipn.escom.matefacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    Button btnContinue;

    public void btnContinueOnClick(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnContinue = (Button) findViewById(R.id.btnContinue);
    }

}