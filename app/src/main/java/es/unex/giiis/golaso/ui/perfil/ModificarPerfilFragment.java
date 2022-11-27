package es.unex.giiis.golaso.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import es.unex.giiis.golaso.R;
import es.unex.giiis.golaso.databinding.FragmentModificarPerfilBinding;

public class ModificarPerfilFragment extends Fragment {

    private EditText modify_user;
    private EditText modify_password;
    private Button btn_edit;
    private FragmentModificarPerfilBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModificarPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        modify_user = root.findViewById(R.id.modify_user);

        modify_password = root.findViewById(R.id.modify_password);

        btn_edit = root.findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("email", modify_user.getText().toString());
                bundle.putString("password", modify_password.getText().toString());
                getParentFragmentManager().setFragmentResult("requestKey", bundle);
                Navigation.findNavController(root).navigate(R.id.action_nav_modificar_perfil_to_nav_profile);
            }
        });
        return root;
    }
}