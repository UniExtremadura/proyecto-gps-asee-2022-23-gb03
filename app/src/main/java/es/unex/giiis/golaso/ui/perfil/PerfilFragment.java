package es.unex.giiis.golaso.ui.perfil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.databinding.FragmentPerfilBinding;

public class PerfilFragment extends Fragment {

    private Button buttonEdit;
    private Button buttonLogout;
    private TextView user_email;
    private FragmentPerfilBinding binding;
    private SharedPreferences sharedPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        sharedPref = getActivity().getPreferences(getContext().MODE_PRIVATE);

        user_email = root.findViewById(R.id.user_email);
        user_email.setText(sharedPref.getString(getString(R.string.edit_user), "No user"));

        buttonLogout = (Button) root.findViewById(R.id.buttonLogout);
        buttonEdit = (Button) root.findViewById(R.id.buttonEdit);

        /*buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_nav_profile_to_nav_login);
            }
        });*/

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_nav_profile_to_nav_modificar_perfil);
            }
        });

        return root;

    }
}