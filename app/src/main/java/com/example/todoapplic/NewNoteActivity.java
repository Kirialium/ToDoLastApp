package com.example.todoapplic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class NewNoteActivity extends AppCompatActivity {

    private EditText editTextName, editTextDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        Objects.requireNonNull(getSupportActionBar()).hide();

        //Установка цвета для верхней и нижней полоски
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.third_blue));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));

        //Инициализация некоторых переменных
        editTextName = findViewById(R.id.name_new_note_edit_text);
        editTextDescription = findViewById(R.id.description_edit_text);

        //Кнопка возвращения домой, сохранения данных и их передача
        ImageButton backToHomeBtn = findViewById(R.id.back_to_home_btn);
        backToHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Открытие нового активити
                Intent intent = new Intent(NewNoteActivity.this, MainActivity.class);
                intent.putExtra("NAME_NOTE", editTextName.getText().toString());
                intent.putExtra("DESCRIPTION_NOTE", editTextDescription.getText().toString());
                NewNoteActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}