class Robot {
    private int width, height, perimeter;
    private int x, y, dir; // 0=East, 1=North, 2=West, 3=South
    private String[] dirs = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
    }

    public void step(int num) {
        num %= perimeter;

        if (num == 0 && x == 0 && y == 0) {
            dir = 3; // South
            return;
        }

        while (num > 0) {
            if (dir == 0) { // East
                int move = Math.min(num, width - 1 - x);
                x += move;
                num -= move;
                if (num > 0) dir = 1;
            } else if (dir == 1) { // North
                int move = Math.min(num, height - 1 - y);
                y += move;
                num -= move;
                if (num > 0) dir = 2;
            } else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (num > 0) dir = 3;
            } else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (num > 0) dir = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dirs[dir];
    }
}