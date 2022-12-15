package com.example.myproyekakhir.database.entitas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pesan {
    @PrimaryKey
    public int id;

    public String nama;

    public String alamat;

    public String layanan;

    public String berat;
}

