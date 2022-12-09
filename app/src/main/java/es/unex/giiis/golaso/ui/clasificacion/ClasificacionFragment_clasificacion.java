package es.unex.giiis.golaso.ui.clasificacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import es.unex.giiis.golaso.databinding.FragmentClasificacionClasificacionBinding;

public class ClasificacionFragment_clasificacion extends Fragment {

    private FragmentClasificacionClasificacionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentClasificacionClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textClasificacionFragmentClasificacion;
        textView.setText("Este es el ClasificacionFragmentClasificacion");

        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}