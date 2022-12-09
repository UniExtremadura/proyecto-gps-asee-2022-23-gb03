package es.unex.giiis.golaso.ui.clasificacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import es.unex.giiis.golaso.databinding.FragmentGoleadoresClasificacionBinding;

public class GoleadoresFragment_clasificacion extends Fragment {

    private FragmentGoleadoresClasificacionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGoleadoresClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGoleadoresClasificacion;
        textView.setText("Este es el GoleadoresFragmentClasificacion");

        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}