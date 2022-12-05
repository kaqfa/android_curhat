package info.fahri.aplikasicurhat.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import info.fahri.aplikasicurhat.DetailCurhatActivity;
import info.fahri.aplikasicurhat.R;
import info.fahri.aplikasicurhat.apiclient.Curhat;

public class CurhatAdapter extends RecyclerView.Adapter<CurhatAdapter.ViewHolder> {

    ArrayList<Curhat> listCurhat;

    public CurhatAdapter(ArrayList<Curhat> listCurhat) {
        this.listCurhat = listCurhat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.curhat_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Curhat curhat = listCurhat.get(position);
        holder.txtNama.setText(curhat.getNama());
        holder.txtCurhat.setText(curhat.getKonten());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemLayout.getContext();
                Intent it = new Intent(context, DetailCurhatActivity.class);
                it.putExtra("current_curhat", curhat);
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCurhat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtCurhat, txtNama;
        public ConstraintLayout itemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCurhat = itemView.findViewById(R.id.txtItemKonten);
            txtNama = itemView.findViewById(R.id.txtItemNama);
            itemLayout = itemView.findViewById(R.id.item_layout);
        }

    }
}