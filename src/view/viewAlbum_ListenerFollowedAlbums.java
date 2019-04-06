package view;

import controller.controllerAlbum_ListenerFollowedAlbums;
import controller.controllerDashboard;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewAlbum_ListenerFollowedAlbums extends  View{

    // All Albums the Listener is Following
    // List of Albums only

    public controllerAlbum_ListenerFollowedAlbums controller;

    public viewAlbum_ListenerFollowedAlbums(AnchorPane mainPane, controllerAlbum_ListenerFollowedAlbums controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateAlbum.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(){

    }
}
