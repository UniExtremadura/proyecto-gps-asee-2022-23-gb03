package es.unex.giiis.golaso.ui.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.unex.giiis.golaso.databinding.FragmentFavoritosEquiposBinding;

public class FavoritosFragmentEquipos extends Fragment {

    private FragmentFavoritosEquiposBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFavoritosEquiposBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEquiposFavs;
        textView.setText("Este es el FavoritosFragmentEquipos");

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}