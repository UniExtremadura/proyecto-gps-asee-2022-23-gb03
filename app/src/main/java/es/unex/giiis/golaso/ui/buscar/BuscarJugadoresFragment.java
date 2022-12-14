package es.unex.giiis.golaso.ui.buscar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.BuscarJugadoresAdapter;
import es.unex.giiis.golaso.api.jugadores.JugadoresNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentBuscarJugadoresBinding;
import es.unex.giiis.golaso.elementos.JugadorDetailFragment;


public class BuscarJugadoresFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentBuscarJugadoresBinding binding;
    private BuscarJugadoresAdapter mAdapter;

    private SearchView mSearchView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBuscarJugadoresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView mRecyclerView = root.findViewById(R.id.sJugadoresList);
        mSearchView = root.findViewById(R.id.searchPlayerSearchView);

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Create a new Adapter for the RecyclerView

        mAdapter = new BuscarJugadoresAdapter(new ArrayList<>(), jugador -> {

            JugadorDetailFragment jugadorDetail = JugadorDetailFragment.newInstance(jugador);
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager()
                    .beginTransaction();
            transaction.replace(R.id.fragment_search, jugadorDetail)
                    .addToBackStack(null)
                    .commit();

        });

        AppExecutors.getInstance().networkIO().execute(new JugadoresNetworkLoaderRunnable(
                (jugadores) -> mAdapter.swap(jugadores)));

        mRecyclerView.setAdapter(mAdapter);

        mSearchView.setOnQueryTextListener(this);

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;

    }

    @Override
    public boolean onQueryTextChange(String newText) {

        mAdapter.filter(newText);

        return false;

    }
}