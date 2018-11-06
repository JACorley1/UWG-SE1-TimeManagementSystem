package edu.westga.cs3211.time_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Entry point for the program.
 * 
 * @author Jonathan Corley
 */
public class Main extends Application {
	public static final String MAIN_WINDOW_TITLE = "Time Management System";
	public static final String MAIN_WINDOW_VIEW = "view/MainWindow.fxml";

	/**
	 * JavaFX entry point.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param primaryStage the main window hook
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.MAIN_WINDOW_VIEW));
		loader.load();
		Scene scene = new Scene(loader.getRoot());
		primaryStage.setTitle(Main.MAIN_WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Java entry point
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Main.launch(args);
	}

}
