package es.unex.giiis.golaso.ui.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.unex.giiis.golaso.databinding.FragmentFavoritosJugadoresBinding;

public class FavoritosFragmentJugadores extends Fragment {

     private FragmentFavoritosJugadoresBinding binding;

     public View onCreateView(@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {

          binding = FragmentFavoritosJugadoresBinding.inflate(inflater, container, false);
          View root = binding.getRoot();

          final TextView textView = binding.textJugadoresFavs;
          textView.setText("Este es el FavoritosFragmentJugadores");

          return root;

     }

     @Override
     public void onDestroyView() {

          super.onDestroyView();
          binding = null;

     }

}
