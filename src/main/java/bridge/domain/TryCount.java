package bridge.domain;

public class TryCount {

    private static final int INIT_TRY_COUNT = 1;

    private int tryCount;

    public TryCount() {
        tryCount = INIT_TRY_COUNT;
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
