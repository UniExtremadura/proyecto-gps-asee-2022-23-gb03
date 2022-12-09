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

import java.util.ArrayList;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.BuscarEquiposAdapter;
import es.unex.giiis.golaso.api.equipos.EquiposNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentBuscarEquiposBinding;


public class BuscarEquiposFragment extends Fragment implements SearchView.OnQueryTextListener{

    private FragmentBuscarEquiposBinding binding;
    private BuscarEquiposAdapter mAdapter;

    private SearchView mSearchView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBuscarEquiposBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        RecyclerView mRecyclerView = root.findViewById(R.id.sEquiposList);
        mSearchView = root.findViewById(R.id.searchTeamSearchView);

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Create a new Adapter for the RecyclerView

        mAdapter = new BuscarEquiposAdapter(new ArrayList<>());

        AppExecutors.getInstance().networkIO().execute(new EquiposNetworkLoaderRunnable(
                (equipos) -> mAdapter.swap(equipos)));

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
