package ir.omid.myapplication.core.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ir.omid.myapplication.model.entities.MarvelHeroEntity;
import ir.omid.myapplication.model.entities.UserEntity;
import ir.omid.myapplication.presentation.activity.MainActivity;

public class AppDatabase extends SQLiteOpenHelper {
    public static SQLiteDatabase APP_DATABASE;

    public AppDatabase(Context context) {
        super(context, "name.db", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserEntity.SQL_CREATE_ENTRIES);
        db.execSQL(MarvelHeroEntity.SQL_CREATE_ENTRIES);
        APP_DATABASE = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(UserEntity.SQL_DELETE_ENTRIES);
        db.execSQL(MarvelHeroEntity.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void createData(UserEntity user) {
        ContentValues values = new ContentValues();
        values.put(UserEntity.COLUMN_NAME_USERNAME, user.username);
        values.put(UserEntity.COLUMN_NAME_EMAIL, user.email);

        long newRowId =
                this.getWritableDatabase().insert(
                        UserEntity.TABLE_NAME, null, values);
    }

    public void removeData(String username) {
        String selection = UserEntity.COLUMN_NAME_USERNAME + " = ?";
        String[] selectionArgs = { username };
        int deletedRows = APP_DATABASE.delete(UserEntity.TABLE_NAME, selection, selectionArgs);
    }

    public List getAllData() {
        String[] projection = {
                UserEntity._ID,
                UserEntity.COLUMN_NAME_USERNAME,
                UserEntity.COLUMN_NAME_EMAIL
        };
        String sortOrder =
                UserEntity.COLUMN_NAME_USERNAME + " DESC";
        Cursor cursor = APP_DATABASE.query(
                UserEntity.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(UserEntity._ID));
            Bundle item = cursor.getExtras();
            itemIds.add(new UserEntity(item.getString("usernmae"),item.getString("email")));
        }
        cursor.close();

        return itemIds;
    }

}
