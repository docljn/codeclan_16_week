package example.codeclan.com.roompractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zsoltpodoba-szalai on 28/01/2018.
 */

class TodoAdapter  extends ArrayAdapter<Todo> {

    public TodoAdapter(Context context, ArrayList<Todo> todoList){
        super(context, 0, todoList);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.todo_item, parent, false);
        }

        Todo currentTodo = getItem(position);

        TextView todoName = listItemView.findViewById(R.id.todo_name);
        todoName.setText(currentTodo.getName());

        return listItemView;

    }

}
