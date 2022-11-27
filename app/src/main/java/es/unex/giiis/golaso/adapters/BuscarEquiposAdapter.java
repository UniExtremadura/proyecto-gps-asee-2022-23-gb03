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
import es.unex.giiis.golaso.model.Equipo;

public class BuscarEquiposAdapter extends RecyclerView.Adapter<BuscarEquiposAdapter.MyViewHolder>{

    private List<Equipo> mDataset;
    private List<Equipo> mOriginalDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and you provide access to all
    // the views for a data item in a view holder

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewNombre;
        public TextView mTextViewEntrenador;
        public TextView mTextViewPosicion;
        public View mView;
        public Equipo mItem;

        public MyViewHolder(View v) {

            super(v);

            mView=v;
            mTextViewNombre = v.findViewById(R.id.textViewNombreEquipo);
            mTextViewEntrenador = v.findViewById(R.id.textViewEntrenador);
            mTextViewPosicion = v.findViewById(R.id.textViewPosicion);

        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)

    public BuscarEquiposAdapter(List<Equipo> myDataset) {

        mDataset = myDataset;
        mOriginalDataset = new ArrayList<>();
        mOriginalDataset.addAll(myDataset);

    }

    @Override
    public BuscarEquiposAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {

        // create a new view
        // Create new views (invoked by the layout manager)

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_equipo, parent, false);

        return new MyViewHolder(v);

    }

    // Replace the contents of a view (invoked by the layout manager)

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mItem = mDataset.get(position);
        holder.mTextViewNombre.setText(mDataset.get(position).getNombre());
        holder.mTextViewEntrenador.setText(mDataset.get(position).getEntrenador());
        holder.mTextViewPosicion.setText(mDataset.get(position).getPosicion().toString());

    }

    // Return the size of your dataset (invoked by the layout manager)

    @Override
    public int getItemCount() {

        return mDataset.size();

    }

    public void swap(List<Equipo> dataset){

        mDataset = dataset;
        notifyDataSetChanged();

    }

    public void filtradoEquipos(String txtBuscar){

        int longitud = txtBuscar.length();

        if (longitud == 0) {

            mDataset.clear();
            mDataset.addAll(mOriginalDataset);

        } else {

            List<Equipo> filteredList = mDataset.stream().filter(equipo -> equipo.getNombre().
                    toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());

            mDataset.clear();
            mDataset.addAll(filteredList);

        }

        notifyDataSetChanged();

    }

}
