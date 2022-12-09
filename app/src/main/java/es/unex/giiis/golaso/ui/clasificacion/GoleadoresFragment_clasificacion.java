package es.unex.giiis.golaso.ui.clasificacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.GoleadorAdapter;
import es.unex.giiis.golaso.api.jugadores.JugadoresNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentGoleadoresClasificacionBinding;
import es.unex.giiis.golaso.model.Jugador;


public class GoleadoresFragment_clasificacion extends Fragment implements GoleadorAdapter.ItemClickListener {

    private FragmentGoleadoresClasificacionBinding binding;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGoleadoresClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.rVClasJug);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        GoleadorAdapter adapter = new GoleadorAdapter(this.getContext(), new ArrayList<>(), this);

        AppExecutors.getInstance().networkIO().execute(new JugadoresNetworkLoaderRunnable(goleadores -> adapter.swap(goleadores)));

        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

    @Override
    public void onItemClick(Jugador jugador) {
        //Jugador detail
    }

}