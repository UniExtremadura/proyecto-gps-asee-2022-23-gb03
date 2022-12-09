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
import es.unex.giiis.golaso.adapters.ClasificacionAdapter;
import es.unex.giiis.golaso.api.equipos.EquiposNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentClasificacionClasificacionBinding;
import es.unex.giiis.golaso.model.Equipo;

public class ClasificacionFragment_clasificacion extends Fragment implements ClasificacionAdapter.ItemClickListener{

    private FragmentClasificacionClasificacionBinding binding;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentClasificacionClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.rVClas);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ClasificacionAdapter adapter = new ClasificacionAdapter(this.getContext(), new ArrayList<>(), this);

        AppExecutors.getInstance().networkIO().execute(new EquiposNetworkLoaderRunnable(equipos -> adapter.swap(equipos)));

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
    public void onItemClick(Equipo equipo) {
        //equipo detail
    }
}