package es.unex.giiis.golaso.elementos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import es.unex.giiis.golaso.MainActivity;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.databinding.FragmentEquipoDetailBinding;
import es.unex.giiis.golaso.model.Equipo;
import es.unex.giiis.golaso.ui.clasificacion.ClasificacionFragment;

public class EquipoDetailFragment extends Fragment implements FragmentManager.OnBackStackChangedListener {

    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "ubicacion";
    private static final String ARG_PARAM3 = "estadio";
    private static final String ARG_PARAM4 = "entrenador";
    private static final String ARG_PARAM5 = "logo";
    private static final String ARG_PARAM6 = "id";

    private FragmentEquipoDetailBinding binding;
    TabLayout tabEquipo;

    private String mNombre;
    private String mUbicacion;
    private String mEstadio;
    private String mEntrenador;
    private String mLogo;
    private long mId;

    private Equipo mEquipo;

    public static EquipoDetailFragment newInstance(String nombre, String ubicacion, String estadio,
                                                   String entrenador, String logo, long id) {

        EquipoDetailFragment fragment = new EquipoDetailFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, nombre);
        args.putString(ARG_PARAM2, ubicacion);
        args.putString(ARG_PARAM3, estadio);
        args.putString(ARG_PARAM4, entrenador);
        args.putString(ARG_PARAM5, logo);
        args.putLong(ARG_PARAM6, id);

        fragment.setArguments(args);

        return fragment;

    }

    public static EquipoDetailFragment newInstance(Equipo equipo) {

        EquipoDetailFragment fragment = new EquipoDetailFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, equipo.getNombre());
        args.putString(ARG_PARAM2, equipo.getUbicacion());
        args.putString(ARG_PARAM3, equipo.getEstadio());
        args.putString(ARG_PARAM4, equipo.getEntrenador());
        args.putString(ARG_PARAM5, equipo.getLogo());
        args.putLong(ARG_PARAM6, equipo.getIdEquipo());

        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            mNombre = getArguments().getString(ARG_PARAM1);
            mUbicacion = getArguments().getString(ARG_PARAM2);
            mEstadio = getArguments().getString(ARG_PARAM3);
            mEntrenador = getArguments().getString(ARG_PARAM4);
            mLogo = getArguments().getString(ARG_PARAM5);
            mId = getArguments().getLong(ARG_PARAM6);

            mEquipo = new Equipo(mId, mNombre, mEntrenador, mEstadio, mUbicacion, mLogo);

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEquipoDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tabEquipo = root.findViewById(R.id.tabEquipo);

        tabEquipo.selectTab(tabEquipo.getTabAt(0));

        Fragment fragment = JugadoresFragment_equipo.newInstance(mId);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.frameEquipo, fragment)
                .addToBackStack(null)
                .commit();

        tabEquipo.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    Fragment fragment = JugadoresFragment_equipo.newInstance(mId);
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.frameEquipo, fragment)
                            .commit();
                }

                if (tab.getPosition() == 1) {
                    Fragment fragment = ResultadosFragment_equipo.newInstance(mId);
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.frameEquipo, fragment)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        TextView tVNombre = root.findViewById(R.id.tVNombre);
        tVNombre.setText(mNombre);

        TextView tVEstadio = root.findViewById(R.id.tVEstadio);
        String estadio = "Estadio: " + mEstadio;
        tVEstadio.setText(estadio);

        TextView tVUbicacion = root.findViewById(R.id.tVUbi);
        String ubi = "Ubicación: " + mUbicacion;
        tVUbicacion.setText(ubi);

        TextView tVEntrenador = root.findViewById(R.id.tVEntrenador);
        String entrenador = "Entrenador: " + mEntrenador;
        tVEntrenador.setText(entrenador);

        ImageView iVlogoEquipo = root.findViewById(R.id.logoEquipo);

        Glide.with(this)
                .load(mLogo)
                .into(iVlogoEquipo);

        FloatingActionButton shareTeam = root.findViewById(R.id.shareTeam);
        shareTeam.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String text="";

            text = mEquipo.getNombre() + "\n Entrenador: " + mEquipo.getEntrenador() +
                    "\n Estadio: " + mEquipo.getEstadio() + "\n Ubicación: " +
                    mEquipo.getUbicacion() +
                    "\n Compartido desde GOLASO, tu app de fútbol favorita!";

            intent.putExtra(Intent.EXTRA_TEXT,text);
            startActivity(intent);

        });

        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

    @Override
    public void onBackStackChanged() {

    }
}
