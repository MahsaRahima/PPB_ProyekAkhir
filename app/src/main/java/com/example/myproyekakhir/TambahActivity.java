package com.example.myproyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myproyekakhir.database.AppDatabase;
import com.example.myproyekakhir.database.entitas.Pesan;

public class TambahActivity extends AppCompatActivity {
    private EditText editName, editAlamat, editLayanan, editBerat;
    private Button btnSave;
    private AppDatabase database;
    private int id = 0;
    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editName = findViewById(R.id.name);
        editAlamat = findViewById(R.id.alamat);
        editLayanan = findViewById(R.id.layanan);
        editBerat = findViewById(R.id.berat);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        if (id>0){
            isEdit = true;
            Pesan pesan = database.pesanDao().get(id);
            editAlamat.setText(pesan.alamat);
            editName.setText(pesan.nama);
            editLayanan.setText(pesan.layanan);
            editBerat.setText(pesan.berat);
        }else{
            isEdit = false;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEdit){
                    database.pesanDao().update(id, editName.getText().toString(), editAlamat.getText().toString(),
                            editLayanan.getText().toString(), editBerat.getText().toString());
                }else{
                    database.pesanDao().insertAll(editName.getText().toString(), editAlamat.getText().toString(),
                            editLayanan.getText().toString(), editBerat.getText().toString());
                }
                finish();
            }
        });
    }
}