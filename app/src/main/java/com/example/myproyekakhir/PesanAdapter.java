package com.example.myproyekakhir;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproyekakhir.database.entitas.Pesan;

import java.util.List;

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.ViewAdapter> {
    private List<Pesan> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog{
        void onClick(int position);

    }
    public void setDialog(Dialog dialog){
        this.dialog = dialog;
    }

    public PesanAdapter(Context context, List<Pesan> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesan, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.name.setText(list.get(position).nama);
        holder.alamat.setText(list.get(position).alamat);
        holder.layanan.setText(list.get(position).layanan);
        holder.berat.setText(list.get(position).berat);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView name, alamat, layanan, berat;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            alamat = itemView.findViewById(R.id.alamat);
            layanan = itemView.findViewById(R.id.layanan);
            berat = itemView.findViewById(R.id.berat);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
