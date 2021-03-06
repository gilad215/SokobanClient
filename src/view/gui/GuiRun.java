package view.gui;

import controller.MyController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MyModel;

import java.io.FileInputStream;


public class GuiRun {

	public void start(Stage primaryStage) {
		try {
			FXMLLoader fl=new FXMLLoader();
			BorderPane root = fl.load(getClass().getResource("SokobanGUI.fxml").openStream());
			SokobanGUIController sgc=fl.getController();
			Scene scene = new Scene(root,650,600);
			MyModel m=new MyModel();

			MyController controller=new MyController(sgc, m);
			sgc.addObserver(controller);
			m.addObserver(controller);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add(new Image(new FileInputStream("./Extras/images/icon.png")));
			primaryStage.setTitle("Kirby Sokoban");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
