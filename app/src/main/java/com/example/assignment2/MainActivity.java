package com.example.assignment2;

import android.graphics.Color;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addNote;
    EditText textNote;
    LinearLayout viewNotes;
    Context myActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActivity = (Context) this;
        addNote = (Button) findViewById(R.id.addNote);
        textNote = (EditText) findViewById(R.id.textNote);
        viewNotes = (LinearLayout) findViewById(R.id.viewNotes);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText newNote = new EditText(myActivity);
                newNote.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                newNote.setGravity(Gravity.CENTER);
                newNote.setText(textNote.getText());
                viewNotes.addView(newNote);

                final Button deleteNote = new Button(myActivity);
                deleteNote.setText("Delete");
                viewNotes.addView(deleteNote);

                deleteNote.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewNotes.removeView(newNote);
                        viewNotes.removeView(deleteNote);
                    }
                });

            }
        });
    }
}