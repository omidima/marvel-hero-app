package ir.omid.myapplication.model.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ir.omid.myapplication.core.database.AppDatabase;
import ir.omid.myapplication.model.dto.MarvelHeroDto;
import ir.omid.myapplication.model.entities.MarvelHeroEntity;
import ir.omid.myapplication.presentation.activity.MainActivity;

public class MarvelHeroDao {
    public void createData(MarvelHeroEntity item) {
        ContentValues values = new ContentValues();
        values.put(MarvelHeroEntity.COLUMN_NAME_NAME,item.name);
        values.put(MarvelHeroEntity.COLUMN_NAME_REAL_NAME,item.realName);
        values.put(MarvelHeroEntity.COLUMN_NAME_BIO,item.bio);
        values.put(MarvelHeroEntity.COLUMN_NAME_IMAGE_URL,item.imageUrl);
        values.put(MarvelHeroEntity.COLUMN_NAME_TEAM,item.team);

        MainActivity.db.getWritableDatabase().insertWithOnConflict(
                MarvelHeroEntity.TABLE_NAME,
                null,
                values,
                SQLiteDatabase.CONFLICT_ABORT
        );
    }

    public void removeData(int index) {
        String selection = "id = ?";
        MainActivity.db.getReadableDatabase().delete(
                MarvelHeroEntity.TABLE_NAME,
                selection,
                new String[]{String.valueOf(index)}
        );
    }

    public List<MarvelHeroDto> getAllData() {
        Cursor cursor = MainActivity.db.getReadableDatabase().query(
                MarvelHeroEntity.TABLE_NAME,
                new String[]{
                        MarvelHeroEntity.COLUMN_NAME_NAME,
                        MarvelHeroEntity.COLUMN_NAME_REAL_NAME,
                        MarvelHeroEntity.COLUMN_NAME_TEAM,
                        MarvelHeroEntity.COLUMN_NAME_IMAGE_URL,
                        MarvelHeroEntity.COLUMN_NAME_BIO
                },null,null,null,null, "id ASC"
        );

        List<MarvelHeroDto> items = new ArrayList<MarvelHeroDto>();
        while (cursor.moveToNext()) {
            MarvelHeroDto item = new MarvelHeroDto(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            items.add(item);
        }

        return items;
    }
}
