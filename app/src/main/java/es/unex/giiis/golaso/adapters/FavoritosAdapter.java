package es.unex.giiis.golaso.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import es.unex.giiis.golaso.ui.favoritos.FavoritosFragmentEquipos;

public class FavoritosAdapter  extends FragmentStateAdapter {

    public FavoritosAdapter(@NonNull Fragment fragment) {

        super(fragment);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position)  {

        if(position == 1){

            return new FavoritosFragmentEquipos();

        }else{

            return new FavoritosFragmentEquipos();

        }

    }

    @Override
    public int getItemCount() {

        return 2;

    }


}
