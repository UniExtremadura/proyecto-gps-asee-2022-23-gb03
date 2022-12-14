package es.unex.giiis.golaso.adapters;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.model.Equipo;
import es.unex.giiis.golaso.model.Partido;

public class PartidoHomeAdapter extends RecyclerView.Adapter<PartidoHomeAdapter.ViewHolder> {

    Context context;
    List<Partido> partidos;
    List<Equipo> equipos;
    public List<Partido> partidosDia;
    String fecha;

    public PartidoHomeAdapter(Context context, List<Partido> partidosList, List<Equipo> equiposList) {
        this.context = context;
        this.partidos = partidosList;
        this.equipos = equiposList;
        this.partidosDia = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date();
        this.fecha = dateFormat.format(date);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_partido_resultados, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (!partidosDia.isEmpty()) {
            Partido partido = partidosDia.get(position);

            Equipo local = buscarEquipoPorId(partido.getId_local());
            Equipo visitante = buscarEquipoPorId(partido.getId_visitante());

            holder.tVNombreLocal.setText(partido.getLocal());
            holder.tVNombreVis.setText(partido.getVisitante());

            Glide.with(context)
                    .load(local.getLogo())
                    .override(120, 120)
                    .into(holder.iVEquipoLocal);
            Glide.with(context)
                    .load(Uri.parse(visitante.getLogo()))
                    .override(120, 120)
                    .into(holder.iVEquipoVis);

            if (partido.getMarcador() != null) {
                String marcador = String.valueOf(partido.getMarcador());
                char target = '–';
                int golesLocal = Integer.parseInt(marcador.substring(0, marcador.indexOf(target)));
                int golesVis = Integer.parseInt(marcador.substring(marcador.indexOf(target) + 1));

                holder.tVGolesLocal.setText(Integer.toString(golesLocal));
                holder.tVGolesVis.setText(Integer.toString(golesVis));

                if (golesLocal > golesVis) {
                    holder.tVNombreLocal.setTextColor(Color.parseColor("#82f7a0"));
                    holder.tVGolesLocal.setTextColor(Color.parseColor("#82f7a0"));
                    holder.tVNombreVis.setTextColor(Color.parseColor("#ffffff"));
                    holder.tVGolesVis.setTextColor(Color.parseColor("#ffffff"));
                }
                else {
                    if (golesLocal < golesVis) {
                        holder.tVNombreVis.setTextColor(Color.parseColor("#82f7a0"));
                        holder.tVGolesVis.setTextColor(Color.parseColor("#82f7a0"));
                        holder.tVNombreLocal.setTextColor(Color.parseColor("#ffffff"));
                        holder.tVGolesLocal.setTextColor(Color.parseColor("#ffffff"));
                    }
                    else {
                        holder.tVNombreLocal.setTextColor(Color.parseColor("#ffffff"));
                        holder.tVGolesLocal.setTextColor(Color.parseColor("#ffffff"));
                        holder.tVNombreVis.setTextColor(Color.parseColor("#ffffff"));
                        holder.tVGolesVis.setTextColor(Color.parseColor("#ffffff"));
                    }
                }
            }
            else {
                holder.tVGolesLocal.setText("");
                holder.tVGolesVis.setText("");
                holder.tVNombreVis.setTextColor(Color.parseColor("#ffffff"));
                holder.tVNombreLocal.setTextColor(Color.parseColor("#ffffff"));
            }

            if (partido.getHora() != null) {
                String hora = partido.getHora().substring(0, 5);
                holder.tVHora.setText(hora);
            }
            else
                holder.tVHora.setText("Hora por determinar");

            if (partido.getFecha() != null)
                holder.tVFecha.setText(partido.getFecha());
            else
                holder.tVHora.setText("Hora por determinar");

        }
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        seleccionarPartidosDia();
        notifyDataSetChanged();
    }

    public void seleccionarPartidosDia () {
        partidosDia.clear();
        for (Partido p:partidos) {
            if (p.getFecha().equals(this.fecha))
                partidosDia.add(p);
        }
    }

    private Equipo buscarEquipoPorId(long id) {

        boolean enc = false;
        Equipo e = null;

        for (int i = 0; i < equipos.size() && !enc; i++) {
            e = equipos.get(i);
            if (e.getIdEquipo() == id)
                enc = true;
        }

        return e;
    }

    @Override
    public int getItemCount() {
        return partidosDia.size();
    }

    public void swapP(List<Partido> partidos) {
        this.partidos = partidos;
        seleccionarPartidosDia();
        notifyDataSetChanged();
    }

    public void swapE(List<Equipo> equipos) {
        this.equipos = equipos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tVNombreLocal, tVGolesLocal, tVNombreVis, tVGolesVis, tVHora, tVFecha, tVVacio;
        ImageView iVEquipoLocal, iVEquipoVis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iVEquipoLocal = itemView.findViewById(R.id.iVEquipoLocal);
            iVEquipoVis = itemView.findViewById(R.id.iVEquipoVis);
            tVFecha = itemView.findViewById(R.id.tVfecha);
            tVGolesLocal = itemView.findViewById(R.id.tVGolesLocal);
            tVNombreLocal = itemView.findViewById(R.id.tVNombreLocal);
            tVHora = itemView.findViewById(R.id.tVHora);
            tVGolesVis = itemView.findViewById(R.id.tVGolesVis);
            tVNombreVis = itemView.findViewById(R.id.tVNombreVis);
            tVVacio = itemView.findViewById(R.id.tVVacio);
        }
    }
}
