package es.unex.giiis.golaso.ui.buscar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.BuscarAdapter;
import es.unex.giiis.golaso.databinding.FragmentBuscarBinding;


public class BuscarFragment extends Fragment {

    private FragmentBuscarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBuscarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TabLayout mTabLayout = root.findViewById(R.id.buscarTabLayout);
        ViewPager2 mViewPager2 = root.findViewById(R.id.buscarViewPager);
        BuscarAdapter mAdapter = new BuscarAdapter(this);


        mViewPager2.setAdapter(mAdapter);

        new TabLayoutMediator(mTabLayout, mViewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.sPlayerList);
                    break;
                case 1:
                    tab.setText(R.string.sTeamList);
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