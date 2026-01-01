package bridge.generator.domain;

public class TryCount {

    private int tryCount;

    public static TryCount newInstance() {
        return new TryCount();
    }

    public int getTryCount() {
        return tryCount;
    }
}
