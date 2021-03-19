import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileNotFoundException;

public class TicTacToe extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException{

        InputStream stream = new FileInputStream("./img/ttt.png");
        Image image = new Image(stream);
        ImageView imgView = new ImageView();
        imgView.setFitHeight(100);
        imgView.setFitWidth(150);
        imgView.setImage(image);
        imgView.setX(50);

        Button pvp = new Button();
        Button pvc = new Button();
        Button quit = new Button();
        quit.setCancelButton(true);
        pvp.setText("Player vs Player");
        pvc.setText("Player vs Computer");
        quit.setText("Exit");

        pvp.minHeight(50);
        pvp.minWidth(50);
        pvc.minHeight(50);
        pvc.minWidth(50);
        quit.minHeight(50);
        quit.minWidth(50);

        pvp.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                try{
                    startGame(primaryStage, "PvP");
                } catch(IOException e){
                    e.printStackTrace();
                }
                System.out.println("PVP");
            }
        });

        pvc.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                primaryStage.close();
                try{
                startGame(primaryStage, "PvC");
                } catch(IOException e){
                    e.printStackTrace();
                }
                System.out.println("PVC");
            }
        });

        quit.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                System.out.println("Exit");
                closeStage(primaryStage);
            }
        });

        //Group root = new Group(imgView);
        VBox root = new VBox(imgView);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pvp, pvc, quit);
        pvp.setPadding(new Insets(10,10,10,10));
        pvc.setPadding(new Insets(4,4,4,4));
        quit.setPadding(new Insets(4,4,4,4));
        Scene menu = new Scene(root, 200, 200, Color.LIGHTGRAY);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(menu);
        primaryStage.show();
    }

    void closeStage(Stage stage){
        stage.close();
    }

    void startGame(Stage stage, String mode) throws IOException{
        InputStream input = new FileInputStream("./img/plane.jpg");
        Image jpg = new Image(input);
        ImageView plane = new ImageView(jpg);
        plane.setFitWidth(256);
        plane.setFitHeight(256);

        Button quit = new Button();
        quit.setText("Quit");

        quit.setMinHeight(63);
        quit.setMinWidth(256);
        //quit.setLayoutX(100);
        quit.setLayoutY(257);

        quit.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                stage.close();
            }
        });

        Group window = new Group();
        Pane board = new Pane(plane);

        window.getChildren().addAll(board, quit);
        Scene play = new Scene(window, 256, 320, Color.LIGHTGRAY);

        stage.setTitle(mode);
        stage.setScene(play);
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}