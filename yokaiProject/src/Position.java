public class Position {
    public int row;
    public char column;

    public String toSting(){
        return String.valueOf(this.column) + this.row;
    }
}
