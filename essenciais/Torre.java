package essenciais;

public class Torre {

    private int x, y, w, h;

    public Torre (int x, int y) {
        this.x = x; //(x,y) (x+w,y)
        this.y = y; //(x,y+h) (x+w-1,y+h)
        this.w = 1;
        this.h = 1;
    }

    public int[] getPos() {
        int[] p = {this.x,this.y,this.w,this.h};
        return p;
    }
}
