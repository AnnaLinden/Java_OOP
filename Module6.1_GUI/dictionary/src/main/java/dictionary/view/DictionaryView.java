package dictionary.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import dictionary.controller.DictionaryController;
import dictionary.model.Dictionary;

public class DictionaryView extends Application {
    private DictionaryController controller;
    private TextField wordInput;
    private TextArea meaningDisplay;

    @Override
    public void start(Stage stage) {
        controller = new DictionaryController(new Dictionary());

        wordInput = new TextField();
        Button searchButton = new Button("Search");
        meaningDisplay = new TextArea();
        meaningDisplay.setEditable(false);

        searchButton.setOnAction(e -> searchWord());

        FlowPane layout = new FlowPane(10, 10, wordInput, searchButton, meaningDisplay);
        Scene scene = new Scene(layout, 300, 200);

        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    private void searchWord() {
        String word = wordInput.getText();
        String meaning = controller.searchWord(word);
        if (meaning != null) {
            meaningDisplay.setText(meaning);
        } else {
            meaningDisplay.setText("Word not found.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
