package com.xample.masyadi.coffelate2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xample.masyadi.coffelate2.MenuDetailActivity;
import com.xample.masyadi.coffelate2.R;
import com.xample.masyadi.coffelate2.model.MenuProdukModel;

import java.util.List;

/**
 * Created by masyadi on 4/3/2018.
 */

public class MenuProdukAdapter extends RecyclerView.Adapter<MenuProdukAdapter.ViewHolder> {

    private static int VIEW_HEADER = 0;
    private static int VIEW_ITEM = 1;
    private Context context;
    private List<MenuProdukModel> dataList;

    public MenuProdukAdapter(Context context, List<MenuProdukModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MenuProdukAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == VIEW_HEADER){
            view = LayoutInflater.from(context).inflate(R.layout.view_kategori_menu, parent, false);
        }
        else {
            view = LayoutInflater.from(context).inflate(R.layout.view_list_item_menu_produk, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuProdukAdapter.ViewHolder holder, int position) {

        if (isHeader(position)){
            holder.kategoriMakanan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Kategori makanan", Toast.LENGTH_SHORT).show();
                }
            });

            holder.kategoriMinuman.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Kategori minuman", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {

            final MenuProdukModel data = dataList.get(position - 1);

            String nama = data.getNama().toString();
            int harga = data.getHarga();

            holder.txtNama.setText(nama);
            holder.txtHarga.setText("Rp."+ harga);

            holder.itemRecyclerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, data.getNama(), Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context.getApplicationContext(), MenuDetailActivity.class));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)){
            return VIEW_HEADER;
        }
        else {
            return VIEW_ITEM;
        }
    }

    public boolean isHeader(int posisi){
        if (posisi == VIEW_HEADER){
            return true;
        }
        else {
            return false;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout kategoriMakanan, kategoriMinuman;
        TextView txtNama, txtHarga;
        CardView itemRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);

            kategoriMakanan = (LinearLayout) itemView.findViewById(R.id.kategori_makanan);
            kategoriMinuman = (LinearLayout) itemView.findViewById(R.id.kategori_minuman);
            txtNama         = (TextView) itemView.findViewById(R.id.nama_menu);
            txtHarga        = (TextView) itemView.findViewById(R.id.harga_menu);
            itemRecyclerView = (CardView) itemView.findViewById(R.id.item_menu);
        }
    }
}
