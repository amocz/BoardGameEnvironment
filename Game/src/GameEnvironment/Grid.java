package GameEnvironment;

public abstract class Grid {
    private int height;
    private int width;

    public Grid() {
        this.height = 0;
        this.width = 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
