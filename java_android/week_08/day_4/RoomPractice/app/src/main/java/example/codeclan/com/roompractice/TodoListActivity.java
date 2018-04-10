package example.codeclan.com.roompractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TodoListActivity extends AppCompatActivity {

    public TodoDao todoDao;
    Button deleteAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

//        DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this));

        Todo todo1 = new Todo("Workout", "Chest day");

        AppDatabase.getAppDatabase(this).todoDao().insertAll(todo1);

        ArrayList<Todo> todoArray = new ArrayList<Todo>(AppDatabase.getAppDatabase(this).todoDao().getAll());

        TodoAdapter todoAdapter = new TodoAdapter(this, todoArray);

        ListView todoListView = (ListView) findViewById(R.id.todoListView); //UPDATED
        todoListView.setAdapter(todoAdapter);  //UPDATED



    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    public void deleteAll(View button){
        AppDatabase.getAppDatabase(this).todoDao().deleteAll();
    }

}
