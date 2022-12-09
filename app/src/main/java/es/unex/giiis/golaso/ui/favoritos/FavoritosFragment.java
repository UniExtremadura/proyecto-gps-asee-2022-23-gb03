package es.unex.giiis.golaso.ui.favoritos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.FavoritosAdapter;
import es.unex.giiis.golaso.databinding.FragmentFavoritosBinding;

public class FavoritosFragment extends Fragment {

    private FragmentFavoritosBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFavoritosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TabLayout mTabLayout = root.findViewById(R.id.favsTabLayout);
        ViewPager2 mViewPager2 = root.findViewById(R.id.favsViewPager);
        FavoritosAdapter mAdapter = new FavoritosAdapter(this);

        mViewPager2.setAdapter(mAdapter);

        new TabLayoutMediator(mTabLayout, mViewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.players);
                    break;
                case 1:
                    tab.setText(R.string.teams);
                    break;
            }
        }).attach();

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}