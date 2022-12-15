package com.example.myproyekakhir.database.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.myproyekakhir.database.entitas.Pesan;

import java.util.List;

@Dao
public interface PesanDao {
    @Query("SELECT * FROM pesan")
    List<Pesan> getAll();

    @Query("INSERT INTO pesan (nama,alamat,layanan,berat)values(:nama,:alamat,:layanan,:berat )")
    void insertAll(String nama, String alamat, String layanan, String berat);

    @Query("UPDATE pesan SET nama=:nama, alamat=:alamat, layanan=:layanan, berat=:berat WHERE id=:id")
    void update(int id, String nama, String alamat, String layanan, String berat);

    @Query("SELECT * FROM pesan WHERE id=:id")
    Pesan get(int id);

    @Delete
    void delete(Pesan pesan);
}