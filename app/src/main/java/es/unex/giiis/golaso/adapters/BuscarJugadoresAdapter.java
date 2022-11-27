package es.unex.giiis.golaso.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.model.Jugador;

public class BuscarJugadoresAdapter extends RecyclerView.Adapter<BuscarJugadoresAdapter.MyViewHolder> {

    private List<Jugador> mDataset;
    private List<Jugador> mOriginalDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and you provide access to all
    // the views for a data item in a view holder

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewNombre;
        public TextView mTextViewEquipo;
        public TextView mTextViewPosicion;
        public View mView;
        public Jugador mItem;

        public MyViewHolder(View v) {

            super(v);

            mView=v;
            mTextViewNombre = v.findViewById(R.id.textViewNombreJugador);
            mTextViewEquipo = v.findViewById(R.id.textViewEquipoJugador);
            mTextViewPosicion = v.findViewById(R.id.textViewposicionJugador);

        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)

    public BuscarJugadoresAdapter(List<Jugador> myDataset) {

        mDataset = myDataset;
        mOriginalDataset = new ArrayList<>();
        mOriginalDataset.addAll(myDataset);

    }

    @Override
    public BuscarJugadoresAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {

        // create a new view
        // Create new views (invoked by the layout manager)

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jugador, parent, false);

        return new BuscarJugadoresAdapter.MyViewHolder(v);

    }

    // Replace the contents of a view (invoked by the layout manager)

    @Override
    public void onBindViewHolder(final BuscarJugadoresAdapter.MyViewHolder holder, int position) {

        holder.mItem = mDataset.get(position);
        holder.mTextViewNombre.setText(mDataset.get(position).getNombre());
        holder.mTextViewEquipo.setText(mDataset.get(position).getEquipo());
        holder.mTextViewPosicion.setText(mDataset.get(position).getPosicion());

    }

    // Return the size of your dataset (invoked by the layout manager)

    @Override
    public int getItemCount() {

        return mDataset.size();

    }

    public void swap(List<Jugador> dataset){

        mDataset = dataset;
        notifyDataSetChanged();

    }

    public void filtradoJugadores(String txtBuscar){

        int longitud = txtBuscar.length();

        if (longitud == 0) {

            mDataset.clear();
            mDataset.addAll(mOriginalDataset);

        } else {

            List<Jugador> filteredList = mDataset.stream().filter(jugador -> jugador.getNombre().
                    toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());

            mDataset.clear();
            mDataset.addAll(filteredList);

        }

        notifyDataSetChanged();

    }

}
