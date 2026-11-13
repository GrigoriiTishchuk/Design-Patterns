import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int MAP_WIDTH = 15;
    private static final int MAP_HEIGHT = 12;
    private static final double TILE_SIZE = 40.0;

    private Canvas canvas;
    private Label statsLabel;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(MAP_WIDTH * TILE_SIZE, MAP_HEIGHT * TILE_SIZE);
        statsLabel = new Label();

        Button cityBtn = new Button("Generate City Map");
        Button wildernessBtn = new Button("Generate Wilderness Map");

        cityBtn.setOnAction(e -> renderNewMap(new CityMap(MAP_WIDTH, MAP_HEIGHT), "City Map"));
        wildernessBtn.setOnAction(e -> renderNewMap(new WildernessMap(MAP_WIDTH, MAP_HEIGHT), "Wilderness Map"));

        HBox controls = new HBox(15, cityBtn, wildernessBtn, statsLabel);
        controls.setPadding(new Insets(10));
        controls.setAlignment(Pos.CENTER_LEFT);

        BorderPane root = new BorderPane();
        root.setTop(controls);
        root.setCenter(canvas);

        // Initial map render
        renderNewMap(new WildernessMap(MAP_WIDTH, MAP_HEIGHT), "Wilderness Map");

        Scene scene = new Scene(root);
        primaryStage.setTitle("RPG Map Generator - Flyweight Rendering");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void renderNewMap(Map map, String mapName) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        map.render(gc, TILE_SIZE);

        int totalTiles = MAP_WIDTH * MAP_HEIGHT;
        int cachedGraphics = TileGraphicFactory.getCacheSize();
        statsLabel.setText(String.format("%s | Total tiles: %d | Shared TileGraphic instances: %d",
                mapName, totalTiles, cachedGraphics));
    }

    public static void main(String[] args) {
        launch(args);
    }
}