import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Lab12_1 extends Application {
    private int cartCount = 0;
    private double totalPrice = 0.0;
    private Label cartLabel;
    private ListView<String> cartView;
    private List<String> cartItems = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Button item1Button = new Button("Add Item 1 to Cart");
        Button item2Button = new Button("Add Item 2 to Cart");
        Button item3Button = new Button("Add Item 3 to Cart");

        cartLabel = new Label("Shopping Cart: (0 items)");
        cartView = new ListView<>();

        item1Button.setOnAction(e -> addItemToCart("Item 1", 10.0));
        item2Button.setOnAction(e -> addItemToCart("Item 2", 20.0));
        item3Button.setOnAction(e -> addItemToCart("Item 3", 30.0));

        VBox layout = new VBox(10, cartLabel, cartView, item1Button, item2Button, item3Button);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        primaryStage.setScene(new Scene(layout, 350, 400));
        primaryStage.setTitle("Shopping Cart");
        primaryStage.show();
    }

    private void addItemToCart(String item, double price) {
        cartCount++;
        totalPrice += price;
        cartItems.add(item + " - $" + price);
        cartView.getItems().setAll(cartItems);
        cartLabel.setText("Shopping Cart (" + cartCount + " items):");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
