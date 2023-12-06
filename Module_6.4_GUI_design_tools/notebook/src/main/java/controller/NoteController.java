package controller;

import javafx.fxml.FXML;
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
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

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
        // Disable buttons initially
        editButton.setDisable(true);
        deleteButton.setDisable(true);

        // Add selection change listener

        // Enable/Disable buttons based on whether a note is selected
        notesListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    boolean isNoteSelected = newValue != null;
                    editButton.setDisable(!isNoteSelected);
                    deleteButton.setDisable(!isNoteSelected);

                    if (isNoteSelected) {
                        showNoteDetails(newValue); // Show details of the selected note
                    }
                });
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
            selectedNote.setTitle(titleField.getText());
            selectedNote.setContent(contentArea.getText());

            // Refresh ListView to show updated note
            notesListView.refresh();

            // clear the fields
            titleField.clear();
            contentArea.clear();
        } else {
            // Show an error message or log it
        }
    }

    @FXML
    private void onDelete() {
        Note selectedNote = notesListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            notebook.deleteNote(selectedNote);
            notesListView.setItems(FXCollections.observableList(notebook.getNotes()));
        } else {
            // The buttons are disabled when no note is selected, so nothing to do here.
        }
    }

}
