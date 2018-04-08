package com.xample.masyadi.coffelate2.model;

/**
 * Created by masyadi on 4/3/2018.
 */

public class MenuProdukModel {
    private String nama;
    private int harga;

    public MenuProdukModel(String nama, int umur) {
        this.nama = nama;
        this.harga = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}
