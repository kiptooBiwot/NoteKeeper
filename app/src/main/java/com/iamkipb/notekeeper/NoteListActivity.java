package com.iamkipb.notekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    private NoteRecyclerAdapter mNoteRecyclerAdapter;

//    private ArrayAdapter<NoteInfo> mAdapterNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoteListActivity.this, NoteActivity.class));
            }
        });
        initializeDisplayContent();
    }

    @Override
    protected void onResume() {
        super.onResume();
            mNoteRecyclerAdapter.notifyDataSetChanged();
    }

    private void initializeDisplayContent() {
        final RecyclerView recyclerNotes = findViewById(R.id.list_notes);
        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
        recyclerNotes.setLayoutManager(notesLayoutManager);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        mNoteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
        recyclerNotes.setAdapter(mNoteRecyclerAdapter);
    }
}


//    FloatingActionButton fab = findViewById(R.id.fab);
//    int menuId = destination.getId();
//
//                switch (menuId){
//                        case R.id.nav_notes:
//                        handleSelection("Notes selected");
//                        fab.hide();
//                        break;
//                        case R.id.nav_courses:
//                        handleSelection("Courses selected");
//                        fab.hide();
//                        break;
//                        case R.id.nav_share:
//                        handleSelection("Don't you think you've shared enough?");
//                        fab.hide();
//                        break;
//                        case R.id.nav_send:
//                        handleSelection("Message Sent");
//                        fab.hide();
//                        break;
//default:
//        fab.show();
//        }

//    private void handleSelection(String message) {
//        View view = findViewById(R.id.list_items);
//        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
//    }