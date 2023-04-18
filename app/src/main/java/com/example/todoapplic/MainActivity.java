package com.example.todoapplic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ImageButton newNoteBtn;
    private static final String TAG = "MainActivity";
    private ImageView imageBulb;
    private TextView textWilBe;
    private ArrayList<Note> listNotes = new ArrayList<Note>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        //Установка цвета для верхней и нижней полоски
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.third_blue));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));

        //Инициализация некоторых переменных
        imageBulb = findViewById(R.id.image_bulb);
        textWilBe = findViewById(R.id.text_wil_be);

        //Создание объекта заметки, с переданными данными из второго активити
        Bundle passedData = getIntent().getExtras();
        if(passedData != null && passedData.getBoolean("IS_FIRST_NOTE")){
            Note newNote = new Note();
            newNote.setName(passedData.getString("NAME_NOTE"));
            newNote.setDescription(passedData.getString("DESCRIPTION_NOTE"));
            listNotes.add(newNote);
            Log.d(TAG, newNote.getName());
            Log.d(TAG, newNote.getDescription());
            imageBulb.setBackground(null);
            textWilBe.setText("");

        }

        //Кнопка перехода на создание новой заметки
        newNoteBtn = findViewById(R.id.new_note_btn);
        newNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}