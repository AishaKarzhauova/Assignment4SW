package Assignment4SW;

import java.util.HashMap;
import java.util.Map;

enum Direction {
    NORTH, EAST, SOUTH, WEST
}
class Maze {
    private Map <Integer, Room> rooms = new HashMap <Integer, Room>();

    public void addRoom (Room r) {
        rooms.put(r.getRoomNo(), r);
    }

    public Room roomNo (int r) {
        return rooms.get (r);
    }
}

class Room {
    private Map <Direction, Wall> sides = new HashMap <Direction, Wall>();
    private int roomNo;

    public Room (int roomNo) {
        this.roomNo = roomNo;
    }

    public Wall getSide (Direction direction) {
        return sides.get(direction);
    }

    public void setSide (Direction direction , Wall wall) {
        sides.put(direction, wall );
    }

    public Integer getRoomNo() {
        return roomNo;
    }
    /* ... */
}

class Wall {
    /* ... */
}

class DoorWall extends Wall {
    private Room r1;
    private Room r2;
    private boolean isOpen;

    public DoorWall (Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
        this.isOpen = false;
    }
}

interface MazeBuilder {
    void buildRooms();

    void buildDoors();

    Maze getMaze();
}

class MazeDirector {
    private MazeBuilder builder;

    public MazeDirector(MazeBuilder builder) {
        this.builder = builder;
    }

    public void constructMaze() {
        builder.buildRooms();
        builder.buildDoors();
    }
}

class VariationOfMazeBuilder implements MazeBuilder {
    private Maze maze;

    public VariationOfMazeBuilder() {
        this.maze = new Maze();
    }

    @Override
    public void buildRooms() {
        // Function/logic for rooms
    }

    @Override
    public void buildDoors() {
        // Functions/logic for doors
    }

    @Override
    public Maze getMaze() {
        return maze;
    }
}

public class MazeGame {
    public static void main(String[] args) {
        MazeBuilder builder = new VariationOfMazeBuilder();
        MazeDirector director = new MazeDirector(builder);
        director.constructMaze();
        Maze maze = builder.getMaze();
        // with builder class we can create multiple different mazes without changing the original code
        // written to only show the architecture, not functionality
    }
}