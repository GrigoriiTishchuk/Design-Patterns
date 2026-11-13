import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    // Flyweight
    private static final Map<String, TileGraphic> graphicsCache = new HashMap<>();
    public static TileGraphic getTileGraphic(String tileType) {
        if (graphicsCache.containsKey(tileType)) {
            return graphicsCache.get(tileType);
        }
        System.out.println("[Flyweight Factory] Loading image asset from disk for type: " + tileType);
        String imagePath = getImagePathForType(tileType);
        Image image = loadImage(imagePath);

        TileGraphic graphic = new TileGraphic(tileType, image);
        graphicsCache.put(tileType, graphic);

        return graphic;
    }

    private static String getImagePathForType(String tileType) {
        switch (tileType) {
            case "Swamp":
                return "/tiles/swamp.png";
            case "Water":
                return "/tiles/water.png";
            case "Road":
                return "/tiles/road.png";
            case "Forest":
                return "/tiles/forest.png";
            case "Building":
                return "/tiles/building.png";
            default:
                throw new IllegalArgumentException("Unknown tile type: " + tileType);
        }
    }

    private static Image loadImage(String path) {
        InputStream stream = TileGraphicFactory.class.getResourceAsStream(path);
        if (stream == null) {
            throw new RuntimeException("Asset not found in resources: " + path +
                    ". Make sure the file exists in resources/tiles/ folder!");
        }
        return new Image(stream);
    }

    public static int getCacheSize() {
        return graphicsCache.size();
    }
}