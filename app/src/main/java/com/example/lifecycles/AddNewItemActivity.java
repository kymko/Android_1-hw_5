package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewItemActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText taskTitleEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        btnAdd = findViewById(R.id.btn_add);
        taskTitleEditText = findViewById(R.id.task_title_et);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = taskTitleEditText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("send", str);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}