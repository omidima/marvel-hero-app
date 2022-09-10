package ir.omid.myapplication.model.entities;

import android.provider.BaseColumns;

import com.google.gson.annotations.SerializedName;

public class MarvelHeroEntity implements BaseColumns {
    public static final String TABLE_NAME = "marvel_hero";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_REAL_NAME = "realName";
    public static final String COLUMN_NAME_TEAM = "team";
    public static final String COLUMN_NAME_IMAGE_URL = "imageUrl";
    public static final String COLUMN_NAME_BIO = "bio";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MarvelHeroEntity.TABLE_NAME + " (" +
                    "id INTEGER PRIMARY KEY," +
                    MarvelHeroEntity.COLUMN_NAME_NAME + " TEXT," +
                    MarvelHeroEntity.COLUMN_NAME_REAL_NAME + " TEXT," +
                    MarvelHeroEntity.COLUMN_NAME_TEAM + " TEXT," +
                    MarvelHeroEntity.COLUMN_NAME_IMAGE_URL + " TEXT," +
                    MarvelHeroEntity.COLUMN_NAME_BIO + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MarvelHeroEntity.TABLE_NAME;

    public String name;
    public String realName;
    public String team;
    public String imageUrl;
    public String bio;


    public MarvelHeroEntity(String name, String realName, String team, String imageUrl, String bio) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.imageUrl = imageUrl;
        this.bio = bio;
    }
}