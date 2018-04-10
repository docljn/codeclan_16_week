package example.codeclan.com.roompractice;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zsoltpodoba-szalai on 26/01/2018.
 */

@Entity
public class Todo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String description;

    public Todo(String name, String description){
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
