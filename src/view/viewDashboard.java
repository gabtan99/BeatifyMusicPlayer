package view;

import com.jfoenix.controls.JFXButton;
import controller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelCentral;

public abstract class viewDashboard extends View {

	private controllerDashboard controller;

	public AnchorPane rightCurrentAnchor;
	public AnchorPane centerCurrentAnchor;
	public JFXButton profileBtn;
	public JFXButton playlistsBtn;
	public JFXButton albumsBtn;
	public JFXButton listenersBtn;
	public JFXButton artistBtn;
	public JFXButton songsBtn;
	public JFXButton searchBtn;
	public JFXButton queueBtn;
	protected controllerMusicPlayer musicPlayer;
	protected PaneController currentPaneController;


	public viewDashboard (Stage primaryStage, controllerDashboard controller) {
		this.model = controller.getModel();
		this.primaryStage = primaryStage;
		this.controller = controller;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateDashboard.fxml"));
		loader.setController(this);

		sm = new StageManager(primaryStage);
		sm.loadScene(loader);

		//currentPaneController = new controllerAllSongs(centerCurrentAnchor, model);
		musicPlayer = new controllerMusicPlayer(rightCurrentAnchor, controller);
	}
	


}
