package model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    // Method to get a formatted String of all notes for display (if needed)
    public String getFormattedNotes() {
        StringBuilder sb = new StringBuilder();
        for (Note note : notes) {
            sb.append("Title: ").append(note.getTitle())
                    .append("\nContent: ").append(note.getContent())
                    .append("\n\n");
        }
        return sb.toString();
    }
}

