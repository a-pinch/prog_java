package stepic.pinch.s33_12;

public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(Direction.UP, 0, 0);
        moveRobot(robot, 3, 0);
        System.out.println(robot);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int dx = toX - robot.getX();
        int dy = toY - robot.getY();
        Direction rd = robot.getDirection();
        while(dx!=0 || dy!=0){
            if((rd==Direction.RIGHT && dx>0) || (rd==Direction.UP && dy>0) ||
                    (rd == Direction.LEFT && dx<0) || (rd==Direction.DOWN && dy<0)){
                robot.stepForward();
                dx = toX - robot.getX();
                dy = toY - robot.getY();
            }else{
                robot.turnRight();
                rd = robot.getDirection();
            }
        }
    }
}
