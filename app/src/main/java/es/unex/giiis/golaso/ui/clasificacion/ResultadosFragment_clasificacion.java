package es.unex.giiis.golaso.ui.clasificacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.unex.giiis.golaso.databinding.FragmentResultadosClasificacionBinding;

public class ResultadosFragment_clasificacion extends Fragment {

    private FragmentResultadosClasificacionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultadosClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textResultadosClasificacion;
        textView.setText("Este es el ResultadosFragmentClasificacion");

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }


}