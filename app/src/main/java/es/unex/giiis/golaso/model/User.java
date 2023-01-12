package es.unex.giiis.golaso.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @ColumnInfo(name = "user_id")
    @PrimaryKey(autoGenerate = true)
    long id;

    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "email")
    String email;


    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
