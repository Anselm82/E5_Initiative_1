package com.usj.master.e5_initiative_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.usj.master.e5_initiative_1.core.IParameters;

public class SecondActivity extends AppCompatActivity {

    private WebView wv1;
    private TextView tvName, tvPass, tvMail, tvGender, tvCountry, tvAds;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.rName);
        tvPass = findViewById(R.id.rPass);
        tvMail = findViewById(R.id.rMail);
        tvGender = findViewById(R.id.rGender);
        tvCountry = findViewById(R.id.rCountry);
        tvAds = findViewById(R.id.rAds);
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                float rating = ratingBar.getRating();
                Toast.makeText(ratingBar.getContext(), "Nos has votado con: " + rating +
                        ". Gracias por tu valoración!", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(IParameters.NAME);
        String pass = bundle.getString(IParameters.PASSWORD);
        String mail = bundle.getString(IParameters.MAIL);

        String gender = bundle.getString(IParameters.GENDER);
        String country = bundle.getString(IParameters.COUNTRY);
        Boolean ads = bundle.getBoolean(IParameters.ADVERTS);

        tvName.setText("Tu nombre es: " + name);
        tvPass.setText("Tu pass es: " + pass);
        tvMail.setText("Tu email es: " + mail);

        tvGender.setText("Tu género es: " + gender);
        tvCountry.setText("Tu país es: " + country);

        if (ads) tvAds.setText("Has decidido recibir anuncios.");
        else tvAds.setText("Has decidido no recibir anuncios.");


        wv1 = findViewById(R.id.wv1);
        wv1.loadUrl("https://www.google.es");
    }

    public void finalizar(View v) {
        finish();
    }
}
