package es.unex.giiis.golaso.ui.favoritos;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.BuscarJugadoresAdapter;
import es.unex.giiis.golaso.api.jugadores.JugadoresNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentBuscarJugadoresBinding;


public class BuscarJugadoresFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentBuscarJugadoresBinding binding;
    private BuscarJugadoresAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBuscarJugadoresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView mRecyclerView = root.findViewById(R.id.sJugadoresList);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        SearchView mSearchView = root.findViewById(R.id.jugadoresSearchView);
        mSearchView.setOnQueryTextListener(this);

        // Create a new Adapter for the RecyclerView

        mAdapter = new BuscarJugadoresAdapter(new ArrayList<>());

        AppExecutors.getInstance().networkIO().execute(new JugadoresNetworkLoaderRunnable(
                (jugadores) -> mAdapter.swap(jugadores)));

        mRecyclerView.setAdapter(mAdapter);

        return root;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        mAdapter.filtradoJugadores(newText);

        return false;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}