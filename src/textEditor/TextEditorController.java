package textEditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TextEditorController {

    @FXML
    TextArea myTextFile;


    @FXML
    public void save() {
 /*       dostat text z textArea
        dopisat metodu na zapis do suboru.
        Pouzit Bufferedwriter na zapis do dokumentu */
        //nejaka zmena

        String text = myTextFile.getText();
        writer1.write(text);

    }

    public void initialize(){
  /*      Nacitat textovy dokument
         zobrazit v textarea*/



    }
    void test(){

    }

}
