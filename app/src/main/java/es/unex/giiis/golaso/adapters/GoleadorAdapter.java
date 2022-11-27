package es.unex.giiis.golaso.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.model.Jugador;

public class GoleadorAdapter extends RecyclerView.Adapter<GoleadorAdapter.ViewHolder>{

    Context context;
    List<Jugador> goleadores;
    List<Jugador> topGoleadores;
    final int NUM_TOP = 20;

    public GoleadorAdapter(Context context, List<Jugador> responseList) {
        this.context = context;
        this.goleadores = responseList;
        this.topGoleadores = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_goleador_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (topGoleadores != null) {

            Jugador goleador = topGoleadores.get(position);

            GlideApp.with(context)
                    .load("https://countryflagsapi.com/png/" + goleador.getPais().toLowerCase())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .override(120, 60)
                    .into(holder.iVPais);

            Glide.with(context)
                    .load(R.drawable.ic_perfil)
                    .override(60, 60)
                    .into(holder.iVJugador);

            holder.tVPos.setText(String.valueOf(position + 1) + ".");
            holder.tVNombreJug.setText(goleador.getNombre());
            holder.tVGolesJug.setText(String.valueOf(goleador.getGoles()));
            holder.tVAsJug.setText(String.valueOf(goleador.getAsistencias()));
            holder.tVEquipoJug.setText(goleador.getEquipo());

        }
    }

    @Override
    public int getItemCount() {
        return topGoleadores.size();
    }

    public void swap(List<Jugador> goleadores) {
        this.goleadores = goleadores;
        setTopGoleadores();
        notifyDataSetChanged();
    }

    private void setTopGoleadores() {

        goleadores.sort(Comparator.comparing(Jugador::getGoles).thenComparing(Jugador::getAsistencias).reversed());

        for (int i = 0; i < NUM_TOP; i++) {
            topGoleadores.add(goleadores.get(i));
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tVPos, tVNombreJug, tVGolesJug, tVAsJug, tVEquipoJug;
        ImageView iVJugador, iVPais;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tVPos = itemView.findViewById(R.id.tVPosJug);
            tVNombreJug = itemView.findViewById(R.id.tVNombreJug);
            tVGolesJug = itemView.findViewById(R.id.tVGolesJug);
            iVJugador = itemView.findViewById(R.id.iVJugador);
            tVAsJug = itemView.findViewById(R.id.tVAsJug);
            iVPais = itemView.findViewById(R.id.iVPais);
            tVEquipoJug = itemView.findViewById(R.id.tVEquipoJug);
        }
    }


}

