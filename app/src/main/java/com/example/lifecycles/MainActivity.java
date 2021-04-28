package com.example.lifecycles;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvTask;
    private TaskAdapter adapter;
    private FloatingActionButton btnOpenSecondActivity;
    private TextView titletxt;
    private final int REQUEST_CODE = 10;
    private List<String> list;


    private final static String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycler();
        initOpenSecondActivityButton();
//        Log.d(TAG, "onCreate");

    }

    private void initOpenSecondActivityButton() {

        btnOpenSecondActivity = findViewById(R.id.btn_open_second_activity);

        btnOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewItemActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    private void initRecycler() {
        rvTask = findViewById(R.id.rv_item);

        list = new ArrayList<>();
        list.add("privet");


        adapter = new TaskAdapter(this, list);
        rvTask.setLayoutManager(new LinearLayoutManager(this));
        rvTask.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            if (data != null) {
                String text = data.getStringExtra("send"); //Получаем данные, установленные ранее как результат
                list.add(text); //Добавляем данные в список
                adapter.notifyDataSetChanged(); //Обновляем адаптер, который отвечает за отображение списка, чтобы новые данные отобразились
                //Всё :)
            }
        }

    }


}