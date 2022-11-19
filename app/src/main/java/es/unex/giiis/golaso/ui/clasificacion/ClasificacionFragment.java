package es.unex.giiis.golaso.ui.clasificacion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.databinding.FragmentClasificacionBinding;

public class ClasificacionFragment extends Fragment {

    private FragmentClasificacionBinding binding;

    TabLayout tabClas;
    ViewPager2 viewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tabClas = root.findViewById(R.id.tabClas);
        viewPager = root.findViewById(R.id.viewPager);

        tabClas.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}