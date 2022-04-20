package Robot;

public class Robot {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    int x=0;
    int y=0;
    Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public void moveRobotTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("Поворот против часовой стрелки");
        if (direction == Direction.DOWN){
            this.direction = Direction.RIGHT;
            return;
        }

        if (direction == Direction.UP){
            this.direction = Direction.LEFT;
            return;
        }

        if (direction == Direction.LEFT){
            this.direction = Direction.DOWN;
        }

        if (direction == Direction.RIGHT){
            this.direction = Direction.UP;
        }
    }

    public void turnRight() {
        System.out.println("поворот по часовой стрелке");
        if (this.direction == Direction.DOWN){
            System.out.println("Вниз -> влево");
            this.direction = Direction.LEFT;
            return;
        }

        if (this.direction == Direction.UP){
            System.out.println("Вверх -> вправо");
            this.direction = Direction.RIGHT;
            return;
        }

        if (this.direction == Direction.LEFT){
            System.out.println("Влево -> вверх");
            this.direction = Direction.UP;
            return;
        }

        if (this.direction == Direction.RIGHT){
            System.out.println("Вправо -> вниз");
            this.direction = Direction.DOWN;
        }
    }

    public void stepForward() {
        System.out.println("движение");
        if (direction == Direction.DOWN) {
            System.out.println("вниз");
            this.y--;
        }

        if (direction == Direction.UP) {
            System.out.println("вверх");
            this.y++;
        }

        if (direction == Direction.LEFT) {
            System.out.println("налево");
            this.x--;
        }

        if (direction == Direction.RIGHT) {
            System.out.println("направо");
            this.x++;
        }
    }

    public void moveRobot(Robot robot, int toX, int toY) {
        this.moveX(robot, toX);
        this.moveY(robot, toY);
    }

    public void moveX(Robot robot, int toX) {
        int distance = toX - robot.getX();
        if (distance < 0) {
            rotateRobot(robot, Direction.LEFT);
        } else if (distance > 0) {
            rotateRobot(robot, Direction.RIGHT);
        }

        while (distance != 0) {
            robot.stepForward();
            distance = toX - robot.getX();
        }
    }

    public void moveY(Robot robot, int toY) {
        int distance = toY - robot.getY();
        if (distance < 0) {
            rotateRobot(robot, Direction.DOWN);
        } else if (distance > 0) {
            rotateRobot(robot, Direction.UP);
        }

        while (distance != 0) {
            robot.stepForward();
            distance = toY - robot.getY();
        }
    }

    public void rotateRobot(Robot robot, Direction direction) {
        while (robot.getDirection() != direction) {
            robot.turnRight();
        }
    }
}
