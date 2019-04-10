package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistShowArtistAlbumSongs;
import view.Artist.viewSong_ArtistShowArtistPlaylistSongs;

public class controllerSong_ArtistShowArtistPlaylistSongs extends PaneController {

	public controllerSong_ArtistShowArtistPlaylistSongs(AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistShowArtistPlaylistSongs(   mainPane,this, dashboardController);
	}

	public void addSongToQueue(Song song) {
		this.model.getPlayerModel().addSongToQueue(song);
	}

	public void playSong(Song song) {
		this.model.getPlayerModel().playSingleSong(song);
	}
}
