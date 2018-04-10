package example.codeclan.com.roompractice;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by zsoltpodoba-szalai on 28/01/2018.
 */

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    public static Todo addTodo(final AppDatabase db, Todo todo) {
        db.todoDao().insertAll(todo);
        return todo;
    }

    private static void populateWithTestData(AppDatabase db) {
        Todo todo = new Todo("TestName for todo", "TestDescription for todo");
        addTodo(db, todo);

        ArrayList<Todo> todoList = new ArrayList<Todo>(db.todoDao().getAll());
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + todoList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
