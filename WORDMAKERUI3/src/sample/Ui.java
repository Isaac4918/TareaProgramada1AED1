package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class  Ui {
    public Stage primaryStage=new Stage();
    public String scenetype;




    public void newUI(int Scenenumber) throws Exception {
        if (Scenenumber==0){
            scenetype="init.fxml";
        }

        if (Scenenumber==1){
            scenetype="tablero.fxml";
        }

        if (Scenenumber==2){
            scenetype="final.fxml";
        }
        if (Scenenumber==3){
            scenetype="button.fxml";
        }


        Parent root = FXMLLoader.load(getClass().getResource(scenetype));
        primaryStage.setTitle("WORDMAKER");
        primaryStage.setScene(new Scene(root, 1500, 900));
        primaryStage.show();


    }

    public void close() throws Exception {
            primaryStage.close();
        }
    }

