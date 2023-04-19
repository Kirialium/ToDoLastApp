package com.example.todoapplic;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter<Note> {

    private Context mContext;
    private int mResource;

    public MyAdapter(Context context, int resource, ArrayList<Note> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        TextView txtTitle = convertView.findViewById(android.R.id.text1);

        Note note = getItem(position);
        txtTitle.setText(note.getName());

        //Шрифт
        Typeface customFont = ResourcesCompat.getFont(mContext, R.font.roboto);
        txtTitle.setTypeface(customFont);

        //Цвет
        int customColor = ContextCompat.getColor(mContext, R.color.black);
        txtTitle.setTextColor(customColor);

        //Размер
        txtTitle.setTextSize(22);



        return convertView;
    }
}
