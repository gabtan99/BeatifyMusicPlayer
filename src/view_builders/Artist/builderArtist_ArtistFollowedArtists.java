package view_builders.Artist;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerArtist_ArtistFollowedArtists;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import object.User;
import view_builders.builderUser;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ArtistFollowedArtists extends builderUser<AnchorPane> {

    private controllerArtist_ArtistFollowedArtists controller;

    public builderArtist_ArtistFollowedArtists(controllerArtist_ArtistFollowedArtists controller) {
        this.controller= controller;
        this.listElements = controller.getModel().getProfileModel().getFollowedArtists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            User user = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle userPic = new Circle(45);
            Label text = new Label(user.getUsername());

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button unfollowButton = new Button("Unfollow");
            unfollowButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(unfollowButton);
            popup.setPopupContent(content);

            albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        } else {
                            controller.checkProfile(user.getUser_id());
                        }
                    }
                }
            });

            unfollowButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.unfollow(user.getUser_id());
                    popup.hide();
                }
            });

            albumIndiv.setLeftAnchor(userPic, 20.0);
            albumIndiv.setTopAnchor(userPic, 13.0);
            albumIndiv.setTopAnchor(text, 106.0);
            albumIndiv.setLeftAnchor(text, 47.0);

            albumIndiv.getChildren().add(userPic);
            albumIndiv.getChildren().add(text);

            text.setMaxWidth(130.0);
            text.setAlignment(Pos.CENTER);
            text.setWrapText(true);
            text.setTextAlignment(TextAlignment.CENTER);

            userPic.setFill(new ImagePattern(new Image(user.getAvatarURL().toURI().toString())));

            listProducts.add(albumIndiv);

        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}