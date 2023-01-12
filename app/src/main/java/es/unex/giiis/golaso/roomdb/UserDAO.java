package es.unex.giiis.golaso.roomdb;

import androidx.room.Insert;

import es.unex.giiis.golaso.model.User;

public interface UserDAO {

    @Insert
    void insert(User user);

}
