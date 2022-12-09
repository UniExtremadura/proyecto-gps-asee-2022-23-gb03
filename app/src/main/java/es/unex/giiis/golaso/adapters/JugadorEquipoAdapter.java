package es.unex.giiis.golaso.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.model.Jugador;

public class JugadorEquipoAdapter extends RecyclerView.Adapter<JugadorEquipoAdapter.ViewHolder>{

    Context context;
    List<Jugador> jugadores;
    List<Jugador> jugadoresEquipo;
    private final int idEquipo;
    SwitchCompat mSwitch;
    private ItemClickListener clickListener;

    public JugadorEquipoAdapter(Context context, List<Jugador> responseList, long idEquipo, SwitchCompat mSwitch, ItemClickListener clickListener) {
        this.context = context;
        this.jugadores = responseList;
        this.jugadoresEquipo = new ArrayList<>();
        this.idEquipo = (int)idEquipo;
        this.mSwitch = mSwitch;
        this.clickListener = clickListener;
    }

    //busca los jugadores del equipo y los ordena por nombre
    private void buscarJugadoresEquipo(int idEquipo) {

        for (Jugador j:jugadores) {
            if (j.getIdEquipo() == idEquipo) {
                j.setNombre(eliminarAcentos(j.getNombre()));
                jugadoresEquipo.add(j);
            }
        }

        jugadoresEquipo.sort(Comparator.comparing(Jugador::getNombre));

    }

    //elimina las tildes de un String
    public static String eliminarAcentos(String str) {

        final String ORIGINAL = "ÁáÉéÍíÓóÚúÑñÜü";
        final String REEMPLAZO = "AaEeIiOoUuNnUu";

        if (str == null) {
            return null;
        }
        char[] array = str.toCharArray();
        for (int indice = 0; indice < array.length; indice++) {
            int pos = ORIGINAL.indexOf(array[indice]);
            if (pos > -1) {
                array[indice] = REEMPLAZO.charAt(pos);
            }
        }
        return new String(array);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_jugador_equipo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (jugadoresEquipo != null) {

            Jugador jugador = jugadoresEquipo.get(position);

            if(jugador.getPosicion() != null) {

                holder.posicionJug.setText(jugador.getPosicion());

                if (jugador.getPosicion().equals("PT"))
                    holder.posicionJug.setBackgroundColor(Color.parseColor("#C8B221"));
                else if (jugador.getPosicion().contains("DF"))
                    holder.posicionJug.setBackgroundColor(Color.parseColor("#5989B4"));
                else if (jugador.getPosicion().contains("CM"))
                    holder.posicionJug.setBackgroundColor(Color.parseColor("#59B45C"));
                else if (jugador.getPosicion().contains("DL") || jugador.getPosicion().contains("DC"))
                    holder.posicionJug.setBackgroundColor(Color.parseColor("#A73F3F"));
            }

            Glide.with(context)
                    .load("https://countryflagsapi.com/png/" + jugador.getPais().toLowerCase())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .override(120, 60)
                    .into(holder.iVPais);

            Glide.with(context)
                    .load(jugador.getFoto()).error(R.drawable.ic_perfil)
                    .into(holder.iVJugador);

            holder.tVNombreJug.setText(jugador.getNombre());

            mSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
                if (!mSwitch.isChecked()) {
                    jugadoresEquipo.sort(Comparator.comparing(Jugador::getNombre));
                    notifyDataSetChanged();
                }
                else {
                    jugadoresEquipo.sort(Comparator.comparing(Jugador::getPosicion).reversed());
                    notifyDataSetChanged();
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(jugador);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return jugadoresEquipo.size();
    }

    public void swap(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        buscarJugadoresEquipo(idEquipo);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tVNombreJug, posicionJug;
        ImageView iVJugador, iVPais;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tVNombreJug = itemView.findViewById(R.id.nombreJugador);
            iVJugador = itemView.findViewById(R.id.caraJugador);
            iVPais = itemView.findViewById(R.id.paisJugador);
            posicionJug = itemView.findViewById(R.id.posicionJug);
        }
    }

    public interface ItemClickListener {
        void onItemClick(Jugador jugador);
    }
}
