package es.unex.giiis.golaso.ui.buscar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.unex.giiis.golaso.databinding.FragmentBuscarEquiposBinding;

public class BuscarEquiposFragment extends Fragment {

    private FragmentBuscarEquiposBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBuscarEquiposBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        final TextView textView = binding.textBuscarEquipos;
        textView.setText("Este es el BuscarEquiposFragment");

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}
