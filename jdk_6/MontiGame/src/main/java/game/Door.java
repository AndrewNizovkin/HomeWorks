package game;

public class Door {
    private boolean prize;
    private boolean open;
    private boolean marked;

    public Door() {
        prize = false;
        open = false;
        marked = false;
    }

    public boolean isPrize() {
        return prize;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
