package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;
import model.Notebook;

public class NoteController {

    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;
    @FXML
    private TextArea displayArea;

    private Notebook notebook;

    public NoteController() {
        notebook = new Notebook();
    }

    @FXML
    private void onAdd() {
        String title = titleField.getText();
        String content = contentArea.getText();

        Note note = new Note(title, content);
        notebook.addNote(note);

        displayArea.setText(notebook.getFormattedNotes());

        // Clear the input fields after adding the note
        titleField.clear();
        contentArea.clear();
    }

    // Additional methods for advanced features if implemented
}
