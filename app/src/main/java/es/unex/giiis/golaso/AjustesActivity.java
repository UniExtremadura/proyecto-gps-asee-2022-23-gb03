package es.unex.giiis.golaso;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class AjustesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
