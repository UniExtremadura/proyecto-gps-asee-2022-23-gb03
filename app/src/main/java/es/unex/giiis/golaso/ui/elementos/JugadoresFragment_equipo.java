package es.unex.giiis.golaso.ui.elementos;

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

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.JugadorEquipoAdapter;
import es.unex.giiis.golaso.api.goleadores.JugadoresNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentJugadoresEquipoBinding;

public class JugadoresFragment_equipo extends Fragment {

    private FragmentJugadoresEquipoBinding binding;
    private RecyclerView recyclerView;

    private static final String ARG_PARAM1 = "idEquipo";
    private int mIdEquipo;

    public static JugadoresFragment_equipo newInstance(int idEquipo) {
        JugadoresFragment_equipo fragment = new JugadoresFragment_equipo();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, idEquipo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIdEquipo = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJugadoresEquipoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recycler_view_jug);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        JugadorEquipoAdapter adapter = new JugadorEquipoAdapter(this.getContext(), new ArrayList<>(), mIdEquipo);

        AppExecutors.getInstance().networkIO().execute(new JugadoresNetworkLoaderRunnable(jugadores -> adapter.swap(jugadores)));

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
}