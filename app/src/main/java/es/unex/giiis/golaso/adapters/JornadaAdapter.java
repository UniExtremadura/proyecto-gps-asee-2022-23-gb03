package es.unex.giiis.golaso.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.unex.giiis.golaso.R;

public class JornadaAdapter extends RecyclerView.Adapter<JornadaAdapter.ViewHolder> {

    List<Integer> jornadas;
    Context context;
    ResultadoAdapter adapter;
    private int selectedPosition = 0;
    boolean calculada;
    LinearLayoutManager horizontalLayout;

    public JornadaAdapter(Context context, List<Integer> jornadas, ResultadoAdapter adpater, LinearLayoutManager horizontalLayout) {
        this.context = context;
        this.jornadas = jornadas;
        this.adapter = adpater;
        calculada = false;
        this.horizontalLayout = horizontalLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_jornada_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tVNumJornada.setText(String.valueOf(jornadas.get(position)));

        if (selectedPosition == position) {
            holder.tVNumJornada.setTextColor(Color.parseColor("#0a7552"));
            holder.tVJornada.setTextColor(Color.parseColor("#0a7552"));
            holder.barraFinal.setBackgroundColor(Color.parseColor("#0a7552"));
        }
        else {
            holder.tVNumJornada.setTextColor(Color.parseColor("#ffffff"));
            holder.tVJornada.setTextColor(Color.parseColor("#ffffff"));
            holder.barraFinal.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        holder.itemView.setOnClickListener(v -> {
            adapter.setJornada(jornadas.get(position));
            selectedPosition = position;
            //horizontalLayout.scrollToPositionWithOffset(selectedPosition + 1, horizontalLayout.getWidth() / 2);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return jornadas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tVNumJornada, tVJornada, barraFinal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tVNumJornada = itemView.findViewById(R.id.tVNumJornada);
            tVJornada = itemView.findViewById(R.id.tVJornada);
            barraFinal = itemView.findViewById(R.id.barraFinal);
        }
    }
}
