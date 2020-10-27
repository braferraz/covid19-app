package br.braian.android.teste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EstadoAtual extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Menu de navegação
        setContentView(R.layout.activity_estado_atual);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), Dicas.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        WebView web = findViewById(R.id.webView);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new Callback());
        web.loadUrl("https://covid.saude.gov.br");
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}