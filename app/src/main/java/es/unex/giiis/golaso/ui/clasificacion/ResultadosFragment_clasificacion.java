package es.unex.giiis.golaso.ui.clasificacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.JornadaAdapter;
import es.unex.giiis.golaso.adapters.ResultadoAdapter;
import es.unex.giiis.golaso.api.equipos.EquiposNetworkLoaderRunnable;
import es.unex.giiis.golaso.api.partidos.PartidosNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentResultadosClasificacionBinding;

public class ResultadosFragment_clasificacion extends Fragment {

    private FragmentResultadosClasificacionBinding binding;
    RecyclerView recyclerJornadaView;
    RecyclerView recyclerPartidoView;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    LinearLayoutManager HorizontalLayout;
    JornadaAdapter jornadaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultadosClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerViewLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerJornadaView = root.findViewById(R.id.rVJornada);
        recyclerJornadaView.setHasFixedSize(true);
        recyclerJornadaView.setLayoutManager(RecyclerViewLayoutManager);
        HorizontalLayout = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerJornadaView.setLayoutManager(HorizontalLayout);

        List<Integer> jornadas = new ArrayList<>();

        for (int i = 1; i <= 38; i++) {
            jornadas.add(i);
        }

        ResultadoAdapter adapter = new ResultadoAdapter(this.getContext(), new ArrayList<>(), new ArrayList<>());

        recyclerPartidoView = root.findViewById(R.id.rVPartidos);
        recyclerPartidoView.setHasFixedSize(true);
        recyclerPartidoView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        AppExecutors.getInstance().networkIO().execute(new PartidosNetworkLoaderRunnable(partidos -> adapter.swapP(partidos)));
        AppExecutors.getInstance().networkIO().execute(new EquiposNetworkLoaderRunnable(equipos -> adapter.swapE(equipos)));
        recyclerPartidoView.setAdapter(adapter);

        jornadaAdapter = new JornadaAdapter(this.getContext(), jornadas, adapter, HorizontalLayout);
        recyclerJornadaView.setAdapter(jornadaAdapter);

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


}