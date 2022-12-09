package es.unex.giiis.golaso.adapters;

import static java.lang.String.valueOf;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.model.Equipo;

public class BuscarEquiposAdapter extends RecyclerView.Adapter<BuscarEquiposAdapter.MyViewHolder>{

    private List<Equipo> mDataset;
    private List<Equipo> mDatasetOriginal;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and you provide access to all
    // the views for a data item in a view holder

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewNombre;
        public TextView mTextViewEntrenador;
        public TextView mTextViewPosicion;
        public ImageView mImageView;

        public View mView;
        public Equipo mItem;

        public MyViewHolder(View v) {

            super(v);

            mView=v;
            mTextViewNombre = v.findViewById(R.id.textViewNombreEquipo);
            mTextViewEntrenador = v.findViewById(R.id.textViewEntrenador);
            mTextViewPosicion = v.findViewById(R.id.textViewPosicion);
            mImageView = v.findViewById(R.id.itemEquipoLogo);

        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)

    public BuscarEquiposAdapter(List<Equipo> myDataset) {

        this.mDataset = myDataset;
        this.mDatasetOriginal = new ArrayList<>(myDataset);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {

        // create a new view
        // Create new views (invoked by the layout manager)

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_equipo, parent, false);

        return new MyViewHolder(v);

    }

    // Replace the contents of a view (invoked by the layout manager)

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mItem = mDataset.get(position);
        holder.mTextViewNombre.setText(mDataset.get(position).getNombre());
        holder.mTextViewEntrenador.setText(mDataset.get(position).getEntrenador());
        holder.mTextViewPosicion.setText(valueOf(mDataset.get(position).getPosicion()));

        Picasso.get().load(mDataset.get(position).getLogo()).
                resize(250, 250).
                centerCrop().
                into(holder.mImageView);

    }

    // Return the size of your dataset (invoked by the layout manager)

    @Override
    public int getItemCount() {

        return mDataset.size();

    }

    @SuppressLint("NotifyDataSetChanged")
    public void swap(List<Equipo> dataset){

        mDatasetOriginal = dataset;
        notifyDataSetChanged();

    }

    @SuppressLint("NotifyDataSetChanged")
    public void filter(String text) {

        mDataset.clear();

        if (text.length() > 0) {

            List<Equipo> filteredList = mDatasetOriginal.stream()
                    .filter(equipo -> equipo.getNombre().toLowerCase().contains(text.toLowerCase()))
                    .collect(Collectors.toList());

            mDataset.addAll(filteredList);

            notifyDataSetChanged();

        }

    }
}
