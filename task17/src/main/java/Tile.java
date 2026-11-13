import javafx.scene.canvas.GraphicsContext;

public abstract class Tile {
    // Reference to the shared Flyweight graphic
    protected TileGraphic graphic;

    public Tile() {
        // Fetch shared graphic based on tile type
        this.graphic = TileGraphicFactory.getTileGraphic(getType());
    }

    public abstract char getCharacter();
    public abstract String getType();
    public abstract void action();

    // Delegates rendering to the shared Flyweight, passing extrinsic coordinates
    public void render(GraphicsContext gc, double x, double y, double tileSize) {
        graphic.draw(gc, x, y, tileSize);
    }
}

class SwampTile extends Tile {
    @Override
    public char getCharacter() { return 'S'; }

    @Override
    public String getType() { return "Swamp"; }

    @Override
    public void action() {
        System.out.println("You are in a swamp. Damn, unlucky.");
    }
}

class WaterTile extends Tile {
    @Override
    public char getCharacter() { return 'W'; }

    @Override
    public String getType() { return "Water"; }

    @Override
    public void action() {
        System.out.println("You are in water. You can swim, I guess.");
    }
}

class RoadTile extends Tile {
    @Override
    public char getCharacter() { return 'R'; }

    @Override
    public String getType() { return "Road"; }

    @Override
    public void action() {
        System.out.println("You are on a road.");
    }
}

class ForestTile extends Tile {
    @Override
    public char getCharacter() { return 'F'; }

    @Override
    public String getType() { return "Forest"; }

    @Override
    public void action() {
        System.out.println("You are in a forest. You can find some wood here.");
    }
}

class BuildingTile extends Tile {
    @Override
    public char getCharacter() { return 'B'; }

    @Override
    public String getType() { return "Building"; }

    @Override
    public void action() {
        System.out.println("You are in a building. You can rest here.");
    }
}
