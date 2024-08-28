public class DistribuidorIDs {
    private int id;

    public DistribuidorIDs() {
        id = 0;
    }

    public synchronized int getID() {
        return id++;
    }
}
