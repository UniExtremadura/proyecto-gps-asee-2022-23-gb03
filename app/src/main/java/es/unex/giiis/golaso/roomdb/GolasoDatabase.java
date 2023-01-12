package es.unex.giiis.golaso.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.unex.giiis.golaso.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class GolasoDatabase extends RoomDatabase {

    // Patrón Singleton porque solo queremos una instancia de GolasoDatabase porque solo queremos que
    // se instancie una única vez (por costes sobretodo).

    private static GolasoDatabase instance;

    public static synchronized GolasoDatabase getInstance(Context context){

        if (instance == null) {

            instance = Room.databaseBuilder(context, GolasoDatabase.class, "golaso.db")
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return instance;

    }

    // Room implementa esto por nosotros
    public abstract UserDAO getUserDAO();

}
