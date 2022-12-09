package es.unex.giiis.golaso.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Comparator;
import java.util.List;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.model.Equipo;

public class ClasificacionAdapter  extends RecyclerView.Adapter<ClasificacionAdapter.ViewHolder> {

    Context context;
    List<Equipo> equipos;
    private ItemClickListener clickListener;

    public ClasificacionAdapter(Context context, List<Equipo> responseList, ItemClickListener clickListener) {
        this.context = context;
        this.equipos = responseList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_clasificacion_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        equipos.sort(Comparator.comparing(Equipo::getPt).reversed());

        if (equipos != null && equipos.size() > 0) {

            Equipo equipo = equipos.get(position);


            holder.tVPos.setText(String.valueOf(position + 1) + ".");

            String PosAcceso = equipo.getPosicionAcesso();
            switch (PosAcceso) {
                case "UCL":
                    holder.tVPos.setBackgroundColor(Color.parseColor("#001890"));
                    holder.tVPos.setTextColor(Color.parseColor("#FFFFFF"));
                    break;
                case "UEL":
                    holder.tVPos.setBackgroundColor(Color.parseColor("#BB6F00"));
                    holder.tVPos.setTextColor(Color.parseColor("#FFFFFF"));
                    break;
                case "UCFL":
                    holder.tVPos.setBackgroundColor(Color.parseColor("#00BB69"));
                    holder.tVPos.setTextColor(Color.parseColor("#FFFFFF"));
                    break;
                case "DES":
                    holder.tVPos.setBackgroundColor(Color.parseColor("#900000"));
                    holder.tVPos.setTextColor(Color.parseColor("#FFFFFF"));
                    break;
                case "N":
                    holder.tVPos.setBackgroundColor(Color.parseColor("#bfcfc0"));
                    holder.tVPos.setTextColor(Color.parseColor("#000000"));
                    break;
            }

            String imageUrl = (String) equipo.getLogo();
            Glide.with(context)
                    .load(imageUrl)
                    .override(80, 80)
                    .centerInside()
                    .into(holder.iVEscudoEquipo);

            holder.tVNombreEquipo.setText(String.valueOf(equipo.getNombre()));
            holder.tVPartidos.setText(String.valueOf(equipo.getPj()));

            if (equipo.getGf() < 10 && equipo.getGc() < 10)
                holder.tVGoles.setText("  " + String.valueOf(equipo.getGf()) + ":" + String.valueOf(equipo.getGc()));
            else
                if (equipo.getGf() < 10)
                    holder.tVGoles.setText("  " + String.valueOf(equipo.getGf()) + ":" + String.valueOf(equipo.getGc()));
                else
                    if (equipo.getGc() < 10)
                        holder.tVGoles.setText(String.valueOf(equipo.getGf()) + ":" + String.valueOf(equipo.getGc()) + "  ");
                    else
                        holder.tVGoles.setText(String.valueOf(equipo.getGf()) + ":" + String.valueOf(equipo.getGc()));

            holder.tVPuntos.setText(String.valueOf(equipo.getPt()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(equipo);
                }
            });
        }
        else {
            return;
        }

    }

    @Override
    public int getItemCount() {
        return equipos.size();
    }

    public void swap(List<Equipo> equipos) {
        this.equipos = equipos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tVPos, tVNombreEquipo, tVPartidos, tVGoles, tVPuntos;
        ImageView iVEscudoEquipo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tVPos = itemView.findViewById(R.id.tVPos);
            iVEscudoEquipo = itemView.findViewById(R.id.iVEscudoEquipo);
            tVNombreEquipo = itemView.findViewById(R.id.tVNombreEquipo);
            tVPartidos = itemView.findViewById(R.id.tVPartidos);
            tVGoles = itemView.findViewById(R.id.tVGoles);
            tVPuntos = itemView.findViewById(R.id.tVPuntos);
        }
    }

    public interface ItemClickListener {
        void onItemClick(Equipo equipo);
    }
}
