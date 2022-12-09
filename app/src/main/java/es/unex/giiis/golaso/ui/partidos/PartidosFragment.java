package es.unex.giiis.golaso.ui.partidos;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.MainActivity;
import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.adapters.BuscarEquiposAdapter;
import es.unex.giiis.golaso.adapters.PartidoHomeAdapter;
import es.unex.giiis.golaso.api.equipos.EquiposNetworkLoaderRunnable;
import es.unex.giiis.golaso.api.partidos.PartidosNetworkLoaderRunnable;
import es.unex.giiis.golaso.databinding.FragmentPartidosBinding;

public class PartidosFragment extends Fragment {

    private FragmentPartidosBinding binding;
    EditText eText;
    DatePickerDialog picker;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    TextView textEmpty;
    ImageView imageViewEmpty;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPartidosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerViewLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView = root.findViewById(R.id.rVPartidosHome);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        this.textEmpty = root.findViewById(R.id.tVVacio);
        this.imageViewEmpty = root.findViewById(R.id.iVSadBall);

        PartidoHomeAdapter adapter = new PartidoHomeAdapter(this.getActivity(), new ArrayList<>(), new ArrayList<>());

        AppExecutors.getInstance().networkIO().execute(new PartidosNetworkLoaderRunnable(partidos -> adapter.swapP(partidos)));
        AppExecutors.getInstance().networkIO().execute(new EquiposNetworkLoaderRunnable(equipos -> adapter.swapE(equipos)));

        recyclerView.setAdapter(adapter);

        eText = root.findViewById(R.id.datePicker);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date();
        eText.setText(dateFormat.format(date));
        adapter.setFecha(dateFormat.format(date));

        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(v -> {
            final Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            int month = cldr.get(Calendar.MONTH);
            int year = cldr.get(Calendar.YEAR);
            // date picker dialog
            picker = new DatePickerDialog(this.getActivity(), (view, year1, monthOfYear, dayOfMonth) -> {
                eText.setText(twoDigits(dayOfMonth) + "/" + twoDigits(monthOfYear+1) + "/" + year1);
                adapter.setFecha(eText.getText().toString());

                if(adapter.getItemCount() > 0) {
                    textEmpty.setVisibility(View.INVISIBLE);
                    imageViewEmpty.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                }

                else {
                    imageViewEmpty.setVisibility(View.VISIBLE);
                    textEmpty.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                }
                adapter.notifyDataSetChanged();


            }, year, month, day);
            picker.show();
        });

        return root;

    }

    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

}