package es.unex.giiis.golaso.ui.favoritos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.FavoritosAdapter;
import es.unex.giiis.golaso.databinding.FragmentFavoritosBinding;

public class FavoritosFragment extends Fragment {

    private FragmentFavoritosBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFavoritosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TabLayout mTabLayout = root.findViewById(R.id.favsTabLayout);
        ViewPager mViewPager = root.findViewById(R.id.favsViewPager);

        FavoritosAdapter adapter = new FavoritosAdapter(this.getContext(),
                getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}