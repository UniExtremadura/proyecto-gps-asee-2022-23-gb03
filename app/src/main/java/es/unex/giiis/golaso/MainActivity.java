package es.unex.giiis.golaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import es.unex.giiis.golaso.databinding.ActivityMainBinding;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each menu should be considered as top
        // level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_fav, R.id.nav_table, R.id.nav_profile)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Pantalla ajustes
        //editText = (EditText)findViewById(R.id.editText);

        //String text = "Bienvenido de nuevo a Golaso";
        //editText.setText(text);

        // set preferences default values
        //PreferenceManager.setDefaultValues(this,R.xml.preferences, false);
        //loadPreferences(); --> Descomentar esta línea para quedar guardadas las preferencias
        // elegidas cuando se vuelva a iniciar la app

    }

    /*@Override
    public void onRestart() {
        super.onRestart();
        loadPreferences();
    }

    //Este método va a cargar las preferencias
    public void loadPreferences() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        float textSize = Float.parseFloat(pref.getString("textSize", "14"));
        boolean boldStyle = pref.getBoolean("boldStyle", false);
        boolean italicStyle = pref.getBoolean("italicStyle", false);
        String textColor = pref.getString("textColor", "black");
        String backgroundColor = pref.getString("backgroundColor", "green");

        //cambiar el tamaño del texto
        editText.setTextSize(textSize);

        //negrita y cursiva
        int style = 0;
        if(boldStyle)
            style |= Typeface.BOLD;
        if(italicStyle)
            style |= Typeface.ITALIC;

        editText.setTypeface(null, style);

        //cambiar color de la letra
        switch (textColor) {
            case "black":
                editText.setTextColor(Color.BLACK);
                break;
            case "white":
                editText.setTextColor(Color.WHITE);
                break;
            case "blue":
                editText.setTextColor(Color.BLUE);
                break;
            case "red":
                editText.setTextColor(Color.RED);
                break;
        }

        //cambiar color del fondo
        switch (backgroundColor) {
            case "black":
                editText.setBackgroundColor(Color.BLACK);
                break;
            case "white":
                editText.setBackgroundColor(Color.WHITE);
                break;
            case "blue":
                editText.setBackgroundColor(Color.BLUE);
                break;
            case "red":
                editText.setBackgroundColor(Color.RED);
                break;
            case "background":
                editText.setBackgroundColor(Color.parseColor("#bfcfc0"));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //Lanzar actividad de preferencias
            Intent intent = new Intent(this, AjustesActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

}