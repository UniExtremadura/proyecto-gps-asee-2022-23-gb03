package es.unex.giiis.golaso.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.ui.favoritos.BuscarEquiposFragment;
import es.unex.giiis.golaso.ui.favoritos.BuscarJugadoresFragment;
import es.unex.giiis.golaso.ui.favoritos.FavoritosFragmentMisFavs;

public class FavoritosAdapter  extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.myFavs, R.string.sPlayerList,
            R.string.sTeamList};
    private final Context mContext;

    public FavoritosAdapter(Context context, FragmentManager fm) {

        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FavoritosFragmentMisFavs();
            case 1:
                return new BuscarJugadoresFragment();
            case 2:
                return new BuscarEquiposFragment();
            default:
                return null;
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return mContext.getResources().getString(TAB_TITLES[position]);

    }

    @Override
    public int getCount() {

        return 3;

    }


}
