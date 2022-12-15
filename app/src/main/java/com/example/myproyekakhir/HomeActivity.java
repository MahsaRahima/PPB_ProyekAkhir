package com.example.myproyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    private Button btnPesan;
    private FirebaseUser firebaseUser;
    private TextView textName;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnPesan = findViewById(R.id.btn_Pesan);
        textName = findViewById(R.id.name);
        btnLogout = findViewById(R.id.btn_logout);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser.getDisplayName()!=null) {
            textName.setText(firebaseUser.getDisplayName());
        }else{
            textName.setText("Login Gagal!");
        }
        btnLogout.setOnClickListener(view ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });

    }
    public void artikel1 (View view){
        String url ="https://iziloh.com/6-cara-pakai-parfum-laundry/";
        Intent bukaLink = new Intent(Intent.ACTION_VIEW);
        bukaLink.setData(Uri.parse(url));
        startActivity(bukaLink);
    }
    public void artikel2 (View view){
        String url ="https://iziloh.com/simpel-3-tutorial-melipat-celana-berbagai-jenis/";
        Intent bukaLink = new Intent(Intent.ACTION_VIEW);
        bukaLink.setData(Uri.parse(url));
        startActivity(bukaLink);
    }
    public void artikel3 (View view){
        String url ="https://iziloh.com/best-5-outlet-laundry-cuci-karpet-terdekat-jakarta/";
        Intent bukaLink = new Intent(Intent.ACTION_VIEW);
        bukaLink.setData(Uri.parse(url));
        startActivity(bukaLink);
    }

}