package com.example.todoapplic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Note> {

    private Context mContext;
    private int mResource;

    public MyAdapter(Context context, int resource, List<Note> objects) {
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
        TextView txtSubtitle = convertView.findViewById(android.R.id.text2);

        Note note = getItem(position);
        txtTitle.setText(note.getName());
        txtSubtitle.setText(note.getDescription());

        return convertView;
    }
}
