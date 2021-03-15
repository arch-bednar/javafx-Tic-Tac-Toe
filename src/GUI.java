import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GUI extends Application{

    @Override
    public void start(Stage primaryStage){
        Button pvp = new Button();
        Button pvc = new Button();
        Button quit = new Button();
        pvp.setText("Player vs Player");
        pvc.setText("Player vs Computer");
        quit.setText("Quit");

        pvp.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                System.out.println("PVP")
            }
        });

        pvc.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                System.out.println("PVC");
            }
        });

        quit.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                System.out.println("Quit");
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(pvp, pvc, quit);

        Scene menu = new Scene(root, 300, 300);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}