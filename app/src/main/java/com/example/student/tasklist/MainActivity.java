package com.example.student.tasklist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ListView lvTasks;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTasks = (ListView)findViewById(R.id.lvTasks);
        tasks = new ArrayList<String>();

        tasksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasks);
        lvTasks.setAdapter(tasksAdapter);

        tasks.add("First task");
        tasks.add("B task");
        tasks.add("tri task");

    }

    public void onAddTasks(View v){
        EditText etNewTask = (EditText) findViewById(R.id.etNewTask);
        String taskText = etNewTask.getText().toString();

        tasksAdapter.add(taskText);
        etNewTask.setText("");

        setupListViewListener();

    }

    private void setupListViewListener(){
        lvTasks.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        tasks.remove(position);
                        tasksAdapter.notifyDataSetChanged();
                        return true;
                    }
                }

        );
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
