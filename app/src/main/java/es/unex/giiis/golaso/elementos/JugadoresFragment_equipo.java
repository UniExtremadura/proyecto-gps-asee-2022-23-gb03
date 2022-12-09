package es.unex.giiis.golaso.elementos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.JugadorEquipoAdapter;
import es.unex.giiis.golaso.api.jugadores.JugadoresNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentJugadoresEquipoBinding;
import es.unex.giiis.golaso.model.Jugador;

public class JugadoresFragment_equipo extends Fragment implements JugadorEquipoAdapter.ItemClickListener{

    private FragmentJugadoresEquipoBinding binding;

    private static final String ARG_PARAM1 = "idEquipo";
    private long mIdEquipo;

    public static JugadoresFragment_equipo newInstance(long idEquipo) {
        JugadoresFragment_equipo fragment = new JugadoresFragment_equipo();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, idEquipo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIdEquipo = getArguments().getLong(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJugadoresEquipoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_jug);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        SwitchCompat mSwitch = root.findViewById(R.id.switch1);

        JugadorEquipoAdapter adapter = new JugadorEquipoAdapter(this.getContext(), new ArrayList<>(), mIdEquipo, mSwitch, this);

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

    @Override
    public void onItemClick(Jugador jugador) {
        Fragment fragment = JugadorDetailFragment
                .newInstance(jugador);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer_clas, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}