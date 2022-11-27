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

import java.util.ArrayList;
import java.util.List;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.model.Equipo;
import es.unex.giiis.golaso.model.Partido;

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ViewHolder> {

    Context context;
    List<Partido> partidos;
    List<Equipo> equipos;
    int jornadaSeleccionada;
    public List<Partido> partidosDeJornada;

    public ResultadoAdapter(Context context, List<Partido> partidosList, List<Equipo> equiposList) {
        this.context = context;
        this.partidos = partidosList;
        this.equipos = equiposList;
        this.partidosDeJornada = new ArrayList<>();
        this.jornadaSeleccionada = 1;
    }

    /*public int calcularUltimaJornada() {

        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getMarcador() == null)
                return partidos.get(i-1).getJornada();
        }

        return 1;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_partido_resultados, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (!partidosDeJornada.isEmpty()) {

            Partido partido = partidosDeJornada.get(position);

            Equipo local = buscarEquipoPorId(partido.getId_local());
            Equipo visitante = buscarEquipoPorId(partido.getId_visitante());

            holder.tVNombreLocal.setText(partido.getLocal());
            holder.tVNombreVis.setText(partido.getVisitante());

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

            if (partido.getHora() != null)
                holder.tVHora.setText(partido.getHora());
            else
                holder.tVHora.setText("Hora por determinar");

            if(partido.getFecha() != null)
                holder.tVFecha.setText(partido.getFecha());
            else
                holder.tVHora.setText("Fecha por determinar");
        }

    }

    public void seleccionarPartidosJornada () {
        partidosDeJornada.clear();
        for (Partido p:partidos) {
            if (p.getJornada() == this.jornadaSeleccionada)
                partidosDeJornada.add(p);
        }
    }

    public void setJornada (int jornada){
        this.jornadaSeleccionada = jornada;
        seleccionarPartidosJornada();
        notifyDataSetChanged();
    }

    private Equipo buscarEquipoPorId(int id) {

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
        return partidosDeJornada.size();
    }

    public void swapP(List<Partido> partidos) {
        this.partidos = partidos;
        //this.jornadaSeleccionada = calcularUltimaJornada();
        seleccionarPartidosJornada();
        notifyDataSetChanged();
    }

    public void swapE(List<Equipo> equipos) {
        this.equipos = equipos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tVNombreLocal, tVGolesLocal, tVNombreVis, tVGolesVis, tVHora, tVFecha;
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

        }
    }
}
