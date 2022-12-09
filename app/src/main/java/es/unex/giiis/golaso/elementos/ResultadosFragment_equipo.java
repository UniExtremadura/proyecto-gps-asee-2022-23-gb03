package es.unex.giiis.golaso.elementos;

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
import es.unex.giiis.golaso.api.equipos.EquiposNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentResultadosEquipoBinding;

public class ResultadosFragment_equipo extends Fragment {

    private FragmentResultadosEquipoBinding binding;
    RecyclerView recyclerPartidoView;

    private static final String ARG_PARAM1 = "idEquipo";
    private long mIdEquipo;

    public static ResultadosFragment_equipo newInstance(long idEquipo) {
        ResultadosFragment_equipo fragment = new ResultadosFragment_equipo();
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

        binding = FragmentResultadosEquipoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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