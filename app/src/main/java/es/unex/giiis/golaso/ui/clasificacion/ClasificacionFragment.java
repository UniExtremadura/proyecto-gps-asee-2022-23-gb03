package es.unex.giiis.golaso.ui.clasificacion;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.databinding.FragmentClasificacionBinding;

public class ClasificacionFragment extends Fragment {

    private FragmentClasificacionBinding binding;

    TabLayout tabClas;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClasificacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageView imageView = root.findViewById(R.id.logoLiga);

        redondearImagen(imageView, R.drawable.ic_logo_liga);

        tabClas = root.findViewById(R.id.tabClas);

        tabClas.selectTab(tabClas.getTabAt(1));

        getChildFragmentManager().beginTransaction()
                .replace(R.id.frameClas, new ClasificacionFragment_clasificacion())
                .commit();

        tabClas.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0)
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.frameClas, new ResultadosFragment_clasificacion())
                            .commit();

                if (tab.getPosition() == 1)
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.frameClas, new ClasificacionFragment_clasificacion())
                            .commit();

                if (tab.getPosition() == 2)
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.frameClas, new GoleadoresFragment_clasificacion())
                            .commit();
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

    public void redondearImagen(ImageView iv, int dw) {
        Drawable originalDrawable = getResources().getDrawable(dw, null);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(200);

        iv.setImageDrawable(roundedDrawable);
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}