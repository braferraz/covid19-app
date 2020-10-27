package br.braian.android.teste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class questionario extends AppCompatActivity {


    private Boolean verifica;
    private Button button;
    private EditText edNome, edSobrenome, edTelefone, edEmail;
    private CheckBox checkFebre, checkOlfato, checkRespiracao, checkDorGarganta, checkFala, checkDorCabeca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionario);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                ,EstadoAtual.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), Dicas.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });

        //Verificação dos campos requeridos
        //EditText's
        edNome = findViewById(R.id.edNome);
        edSobrenome = findViewById(R.id.edSobrenome);
        edEmail = findViewById(R.id.edEmail);
        edTelefone = findViewById(R.id.edTelefone);
        //CheckBox's
        checkFebre = findViewById(R.id.checkFebre);
        checkDorCabeca = findViewById(R.id.checkDorCabeca);
        checkDorGarganta = findViewById(R.id.checkDorGarganta);
        checkFala = findViewById(R.id.checkFala);
        checkOlfato = findViewById(R.id.checkOlfato);
        checkRespiracao = findViewById(R.id.checkRespiracao);

        button = findViewById(R.id.btnEnviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifica = true;
                if (edNome.getText().toString().trim().equals("")){
                    edNome.setError("O campo nome precisa ser preenchido");
                    verifica = false;
                }

                if (edSobrenome.getText().toString().trim().equals("")){
                    edSobrenome.setError("O campo sobrenome precisa ser preenchido");
                    verifica = false;
                }

                if (edTelefone.getText().toString().trim().equals("")){
                    edTelefone.setError("O campo telefone precisa ser preenchido");
                    verifica = false;
                }

                if (edEmail.getText().toString().trim().equals("")){
                    edEmail.setError("O campo email precisa ser preenchido");
                    verifica = false;
                }
                if (verifica && !checkDorCabeca.isChecked() && !checkDorGarganta.isChecked() && !checkFala.isChecked() && !checkFebre.isChecked() && !checkOlfato.isChecked() && !checkRespiracao.isChecked()){
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(questionario.this);
                    builder.setTitle("Erro!");
                    builder.setMessage("Marque ao menos uma opção");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                    verifica = false;
                }

                if (verifica) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(questionario.this);
                    builder.setTitle("Obrigado!");
                    builder.setMessage("Agradecemos pelas informações");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    builder.show();
                }
            }
        });


    }
}