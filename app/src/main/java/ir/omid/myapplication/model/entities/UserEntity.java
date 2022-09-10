package ir.omid.myapplication.model.entities;

import android.provider.BaseColumns;

public class UserEntity implements BaseColumns {
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_NAME_USERNAME = "username";
    public static final String COLUMN_NAME_EMAIL = "email";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserEntity.TABLE_NAME + " (" +
                    UserEntity._ID+"INTEGER PRIMARY KEY," +
                    UserEntity.COLUMN_NAME_USERNAME + " TEXT," +
                    UserEntity.COLUMN_NAME_EMAIL + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserEntity.TABLE_NAME;

    public String username;
    public String email;

    public UserEntity(
            String username,
            String email
    ) {
        this.username = username;
        this.email = email;
    }

    public UserEntity() {
        this("omidima","omid814445@gmail.com");
    }
}
