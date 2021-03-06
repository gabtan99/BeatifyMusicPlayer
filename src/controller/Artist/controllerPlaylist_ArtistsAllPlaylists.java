package controller.Artist;

import controller.*;
import javafx.scene.layout.AnchorPane;
import object.Playlist;
import view.Artist.viewPlaylist_ArtistAllPlaylists;

public class controllerPlaylist_ArtistsAllPlaylists extends PaneController {

    public controllerPlaylist_ArtistsAllPlaylists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setMyPlaylists(facade.getMyPlaylists(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getLibraryModel().setFollowedPlaylists(facade.getFollowedPlaylists(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewPlaylist_ArtistAllPlaylists(mainPane, this, dashboardController);
    }

    public void goToFollowedList(int playlist_id){
        model.getLibraryModel().setSelectedPlaylist(facade.getPlaylist(playlist_id));
        model.getLibraryModel().setSongContents(facade.getPlaylistSongs(playlist_id));
        controllerSong_ArtistPlaylistFollowedSongs c = new controllerSong_ArtistPlaylistFollowedSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }

    public void goToOwnList(int playlist_id){
        model.getLibraryModel().setSelectedPlaylist(facade.getPlaylist(playlist_id));
        model.getLibraryModel().setSongContents(facade.getPlaylistSongs(playlist_id));
        controllerSong_ArtistPlaylistOwnedSongs c = new controllerSong_ArtistPlaylistOwnedSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }

    public void addPlaylists(){
        controller_AddPlaylist controllerAddPlaylist = new controller_AddPlaylist(mainPane, dashboardController);
        dashboardController.setCurrentPane(controllerAddPlaylist);
    }

    public void unfollowPlaylist(int playlist_id){
        facade.unfollowPlaylist(model.getProfileModel().getUser().getUser_id(), playlist_id);
        model.getLibraryModel().setFollowedPlaylists(facade.getFollowedPlaylists(this.model.getProfileModel().getUser().getUser_id()));
    }

    public void deletePlaylist(int playlist_id){
        facade.deletePlaylist(playlist_id);
        model.getLibraryModel().setMyPlaylists(facade.getFollowedPlaylists(this.model.getProfileModel().getUser().getUser_id()));
    }

    public void editPlaylist(Playlist p) {
        this.model.getLibraryModel().setSelectedPlaylist(p);
        controller_EditPlaylist edit = new controller_EditPlaylist(mainPane, dashboardController);
        dashboardController.setCurrentPane(edit);
    }

    public void addPlaylistToQueue(int playlist_id){
        model.getPlayerModel().addPlaylistToQueue(facade.getPlaylistSongs(playlist_id));
    }
}
