public class asignadorIDs {
    private int id;

    public asignadorIDs() {
        id = 0;
    }

    public synchronized int getID() {
        return id++;
    }
}
