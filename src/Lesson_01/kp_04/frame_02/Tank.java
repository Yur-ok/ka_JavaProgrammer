package Lesson_01.kp_04.frame_02;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Tank {
    private String color;
    private int crew;
    private int maxSpeed;

    private int UP = 1;
    private int DOWN = 2;
    private int LEFT = 3;
    private int RIGHT = 4;

    private int tankDirection = 1;

    private int tankX = 128;
    private int tankY = 512;



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void move(int direction) throws Exception {
        int step = 1;
        int covered = 0;

        // check limits x: 0, 512; y: 0, 512
        if ((direction == UP && tankY == 0) || (direction == DOWN && tankY >= 512)
                || (direction == LEFT && tankX == 0) || (direction == RIGHT && tankX >= 512)) {
            System.out.println("[illegal move] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            return;
        }

        turn(direction);

        while (covered < 64) {
            if (direction == UP) {
                tankY -= step;
                System.out.println("[move up] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == DOWN) {
                tankY += step;
                System.out.println("[move down] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == LEFT) {
                tankX -= step;
                System.out.println("[move left] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else {
                tankX += step;
                System.out.println("[move right] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            }
            covered += step;
            repaint();
            Thread.sleep(speed);
        }
    }

    public void turn(int direction) {
        if (tankDirection != direction) {
            tankDirection = direction;
        }
    }

    public void fire() throws Exception {

        bulletX = tankX + 25;
        bulletY = tankY + 25;

        while ((bulletX > -14 && bulletX < 592) && (bulletY > -14 && bulletY < 592)) {
            if (tankDirection == UP) {
                bulletY -= 1;
            } else if (tankDirection == DOWN) {
                bulletY += 1;
            } else if (tankDirection == LEFT) {
                bulletX -= 1;
            } else if (tankDirection == RIGHT) {
                bulletX += 1;
            }
            repaint();
            Thread.sleep(bulletSpeed);
            if (processInterception("bullet")) {
                bulletX = -100;
                bulletY = -100;
                amountOfBriks--;
            }
        }
    }


    public void getTankPosition() {
// TODO: 16.02.2016  
    }
}
