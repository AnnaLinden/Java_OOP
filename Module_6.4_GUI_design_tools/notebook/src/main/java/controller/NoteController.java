package controller;

import javafx.fxml.FXML;

import java.io.Console;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;
import model.Notebook;

public class NoteController {

    @FXML
    private ListView<Note> notesListView;
    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;
    private Notebook notebook;


    public NoteController() {
        notebook = new Notebook();
    }

    @FXML
    private void initialize() {
        // Bind the ListView to the notebook's notes list
        notesListView.setItems(FXCollections.observableList(notebook.getNotes()));
        notesListView.setCellFactory(param -> new ListCell<Note>() {
            @Override
            protected void updateItem(Note note, boolean empty) {
                super.updateItem(note, empty);
                if (empty || note == null) {
                    setText(null);
                } else {
                    setText(note.getTitle());
                }
            }

        });

        // Add selection change listener

        notesListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showNoteDetails(newValue));
    }

    private void showNoteDetails(Note note) {
        if (note != null) {
            titleField.setText(note.getTitle());
            contentArea.setText(note.getContent());
            System.out.println("showNoteDetails: " + note.getTitle());
        }
    }


    @FXML
    private void onAdd() {
        String title = titleField.getText();
        String content = contentArea.getText();

        Note note = new Note(title, content);
        notebook.addNote(note);

        // Update ListView
        notesListView.setItems(FXCollections.observableList(notebook.getNotes()));

        // Select the new note in the ListView
        int newNoteIndex = notebook.getNotes().indexOf(note);
        notesListView.getSelectionModel().select(newNoteIndex);

        // Clear the input fields after adding the note
        titleField.clear();
        contentArea.clear();
    }

    @FXML
    private void onEdit() {
        Note selectedNote = notesListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            // Assuming you want to edit in the same text fields
            titleField.setText(selectedNote.getTitle());
            contentArea.setText(selectedNote.getContent());

            // Optionally, you can add a state to distinguish between add and edit
        } else {
            // Show error message or disable edit button when no note is selected
        }
    }

    @FXML
    private void onDelete() {
        Note selectedNote = notesListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            notebook.deleteNote(selectedNote);
            notesListView.setItems(FXCollections.observableList(notebook.getNotes()));
        } else {
            // Show error message or disable delete button when no note is selected
        }
    }

}
