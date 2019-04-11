package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerUser_ListenerShowArtistsProfile;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import object.Album;
import view.viewError;
import view_builders.builderAlbum;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ListenerShowArtistsAlbum extends builderAlbum<AnchorPane> {

    public controllerUser_ListenerShowArtistsProfile controller;

    public builderAlbum_ListenerShowArtistsAlbum(controllerUser_ListenerShowArtistsProfile controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPeopleModel().getAlbums();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            Album album = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Label text = new Label(album.getName());

            text.setId("nameText");

            albumIndiv.setLeftAnchor(albumCover, 20.0);
            albumIndiv.setTopAnchor(albumCover, 13.0);
            albumIndiv.setTopAnchor(text, 106.0);
            albumIndiv.setLeftAnchor(text, 26.0);

            albumIndiv.getChildren().add(albumCover);
            albumIndiv.getChildren().add(text);

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button followButton = new Button("Follow");
            followButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(followButton);
            popup.setPopupContent(content);


            followButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.followAlbum(album.getAlbum_id())) {
                        popup.hide();
                    } else {
                        popup.hide();
                        errorPopup = new viewError("Already Following That Album", albumIndiv);
                    }
                }
            });

            text.setMaxWidth(130.0);
            text.setAlignment(Pos.CENTER);
            text.setWrapText(true);
            text.setTextAlignment(TextAlignment.CENTER);

            String picurl = "/resources/albumCover.png";

            if (album.getCover_URL() != null) {
                picurl = album.getCover_URL().toURI().toString();
            }

            albumCover.setFill(new ImagePattern(new Image(picurl)));

            albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        } else {
                            controller.goToAlbumList(album.getAlbum_id());
                        }
                    }
                }
            });

            listProducts.add(albumIndiv);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
