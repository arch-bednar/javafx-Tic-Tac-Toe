import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileNotFoundException;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import java.io.FileInputStream;
import javafx.scene.Group;
import javafx.stage.Stage;

public class game extends Application{

    public static void main(String[] args){
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{

	InputStream stream = new FileInputStream("./img/ttt.png");
	Image image = new Image(stream);
	ImageView imgView = new ImageView(image);
	imgView.setFitHeight(100);
	imgView.setFitWidth(150);
	imgView.setImage(image);
	imgView.setX(50);

	Button pvp = new Button();
	Button pvc = new Button();
	Button exit = new Button();
	exit.setCancelButton(true);
	pvp.setText("Player vs Player");
	pvc.setText("Player vs Computer");
	exit.setText("Exit");

	pvp.minHeight(50);
	pvp.minWidth(50);
	pvc.minHeight(50);
	pvc.minWidth(50);
	exit.minHeight(50);
	exit.minWidth(50);

	pvp.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
		    try{
			startGame(primaryStage, "PvP");
		    }
		    catch(IOException e){
			e.printStackTrace();
		    }
		}
	    });

	pvc.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
		    primaryStage.close();
		    try{
			startGame(primaryStage, "PvC");
		    }catch(IOException e){
			e.printStackTrace();
		    }
		    System.out.println("PvC");
		}
	    });

	exit.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
		    closeStage(primaryStage);
		}
	    });

	VBox root = new VBox(imgView);
	root.setAlignment(Pos.CENTER);
	root.getChildren().addAll(pvp,pvc,exit);
	Scene menu = new Scene(root, 200, 200, Color.LIGHTGRAY);
	primaryStage.setTitle("TicTacToe");
	primaryStage.setScene(menu);
	primaryStage.show();
    }

    private void closeStage(Stage stage){
	stage.close();
    }

    private void startGame(Stage stage, String mode) throws FileNotFoundException{
	/*InputStream input = new FileInputStream("./img/plane.jpg");
	Image jpg = new Image(input);
	ImageView plane = new ImageView(jpg);
	plane.setFitWidth(256);
	plane.setFitHeight(256);
	*/
	Button quit = new Button();
	quit.setText("Exit");
	quit.setCancelButton(true);

	quit.setMinHeight(63);
	quit.setMinWidth(256);
	quit.setLayoutY(277);
	quit.setLayoutX(10);

	quit.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
		    stage.close();
		}
	    });

	Group window = new Group();
	GridPane board = new GridPane();
	board.getStyleClass().add("game-grid");
	//board.setGridLinesVisible(true);
	board.setPrefSize(256, 256);
	makeMesh(board);

	window.getChildren().addAll(board, quit);
	Scene play = new Scene(window, 276, 350, Color.LIGHTGRAY);
	play.getStylesheets().add("game.css");
	stage.setTitle(mode);
	stage.setScene(play);
	stage.show();
    }

    private void makeMesh(GridPane grid){
	for(int col=0; col<3; col++){
	    grid.getColumnConstraints().add(new ColumnConstraints(85));
	}

	for(int row=0; row<3; row++){
	    grid.getRowConstraints().add(new RowConstraints(85));
	}

	for(int col=0; col<3; col++){
	    for(int row=0; row<3; row++){
		Pane pane = new Pane();
		pane.getStyleClass().add("game-grid-cell");
		if(col==0)
		    pane.getStyleClass().add("first-column");
		if(row==0)
		    pane.getStyleClass().add("first-row");
		grid.add(pane, col, row);
	    }
	}

	//grid.setAlignment(Pos.CENTER);
    }
}
