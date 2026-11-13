import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TileGraphic {
    private final Image image; // Intrinsic (shared, immutable) state
    private final String type;

    public TileGraphic(String type, Image image) {
        this.type = type;
        this.image = image;
    }
    // Extrinsic state (x, y, tileSize) is passed from outside during rendering
    public void draw(GraphicsContext gc, double x, double y, double tileSize) {
        gc.drawImage(image, x, y, tileSize, tileSize);
    }

    public String getType() {
        return type;
    }
}