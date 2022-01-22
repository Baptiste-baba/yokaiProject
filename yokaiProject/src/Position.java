public class Position {

    public int row;
    public char column;

    public Position(int row, char column) {
        this.row = row;
        this.column = column;
    }

    public String toSting(){
        return String.valueOf(this.column) + this.row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
