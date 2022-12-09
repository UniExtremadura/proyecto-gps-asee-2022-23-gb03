package es.unex.giiis.golaso.ui.ajustes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import es.unex.giiis.golaso.R;

public final class ConfiguracionTema {

    private ConfiguracionTema() {
    }

    public enum Mode {
        DEFAULT, DARK, LIGHT
    }

    public static void applyTheme(Mode mode) {
        switch (mode) {
            case DARK:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case LIGHT:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            default:
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
        }
    }

    public static void applyTheme(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = defaultSharedPreferences.getString(context.getString(R.string.settings_theme_key), Mode.DEFAULT.name());
        applyTheme(Mode.valueOf(value));
    }
}
