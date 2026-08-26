import java.util.Random;

public abstract class Map {
    protected Tile[][] grid;
    protected int width;
    protected int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Tile[height][width];
        generateMap();
    }

    private void generateMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = createTile();
            }
        }
    }


    public abstract Tile createTile();

    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Random rand = new Random();
        int tileType = rand.nextInt(3);
        switch (tileType) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default:
                return new RoadTile();
        }
    }
}


class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Random rand = new Random();
        int tileType = rand.nextInt(3);
        switch (tileType) {
            case 0:
                return new WaterTile();
            case 1:
                return new ForestTile();
            case 2:
                return new SwampTile();
            default:
                return new ForestTile();
        }
    }
}