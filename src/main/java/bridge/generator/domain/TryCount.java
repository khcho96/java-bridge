package bridge.generator.domain;

public class TryCount {

    private int tryCount;

    public TryCount() {
        tryCount = 1;
    }

    public static TryCount newInstance() {
        return new TryCount();
    }

    public void increaseTryCount() {
        tryCount++;
    }

    @Override
    public String toString() {
        return tryCount + "";
    }
}
