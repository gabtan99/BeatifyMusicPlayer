package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerListener_ListenerFollowedListeners;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class builderListener_ListenerFollowedListeners extends builderUser<AnchorPane> {

    public builderListener_ListenerFollowedListeners(controllerListener_ListenerFollowedListeners controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getProfileModel().getFollowedListeners();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button unfollowButton = new Button("Unfollow");
            unfollowButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(unfollowButton);
            popup.setPopupContent(content);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
