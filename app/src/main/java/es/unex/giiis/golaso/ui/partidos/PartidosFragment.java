package es.unex.giiis.golaso.ui.partidos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.unex.giiis.golaso.databinding.FragmentPartidosBinding;

public class PartidosFragment extends Fragment {

    private FragmentPartidosBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPartidosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPartidos;
        textView.setText("Este es el Home-PartidosFragment");

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}