package textEditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.skin.TextFieldSkin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditorController {

    @FXML
    ListView fileList;

    @FXML
    TextArea myTextFile;

    @FXML
    public void save() {
        String text =myTextFile.getText();

        File selectedFile = (File) fileList.getSelectionModel().getSelectedItem();

        File subor = new File("a.txt");

        try (Writer writer = new FileWriter(selectedFile)) {
            writer.write(text);

        }catch (IOException ex){

        }
    }

    public void initialize() {
        //korenovy adresar CalcualtorAdv
        File file = new File(".");

        File[] files = file.listFiles();

        List<File> poleSuborov = new ArrayList<>();

        for (File elementPolafiles : files) {
            if (elementPolafiles.isFile()) {
                poleSuborov.add(elementPolafiles);
            }
        }


        ObservableList<File> list2 = FXCollections.observableList(poleSuborov);

        fileList.setItems(list2);

        SelectionModel<File> selectionModel = fileList.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                viewFile(newValue);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    public void viewFile(File file) throws FileNotFoundException {

        String strBuffer;

        String out = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((strBuffer = bufferedReader.readLine()) != null) {
                System.out.println(strBuffer);

                out = out + strBuffer + "\n";
            }
            myTextFile.setText(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
