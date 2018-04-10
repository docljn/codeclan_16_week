package example.codeclan.com.roompractice;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsoltpodoba-szalai on 28/01/2018.
 */

@Dao
public interface TodoDao {
    @Insert
    public void insertAll(Todo... todos);

    @Query("SELECT * FROM todo")
    List<Todo> getAll();

    @Query("DELETE FROM todo")
    public void deleteAll();
}
