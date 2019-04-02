package controller;

import javafx.stage.Stage;
import model.Model;
import model.ModelCentral;
import view.View;
import view.viewDashboard;
import view.viewMusicPlayer;

public abstract class controllerDashboard extends Controller{

	protected viewDashboard view;
	protected ModelCentral model;
	protected Stage primaryStage;

	public controllerDashboard (Stage primaryStage) {
		this.primaryStage = primaryStage;
		model = ModelCentral.getInstance();
	}
}
