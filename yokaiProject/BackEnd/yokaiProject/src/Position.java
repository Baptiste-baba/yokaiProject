public class Position {

    public int row;
    public int column;

    public Position(int row, int y) {
        this.row = row;
        this.column = y;
    }

    public String toString(){
        return String.valueOf(this.column) + this.row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
