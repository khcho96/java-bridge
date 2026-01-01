package bridge.view;

import bridge.constant.BridgeSelection;
import bridge.constant.Signature;
import bridge.domain.BridgeResult;
import bridge.domain.GameResult;
import java.util.ArrayList;
import java.util.List;


public final class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public static void printMap(GameResult gameResult) {
        BridgeResult bridgeResult = gameResult.gameState().bridgeResult();
        List<BridgeSelection> bridgeSelections = bridgeResult.getBridgeSelections();
        List<Boolean> result = bridgeResult.getResult();

        List<String> upResult = new ArrayList<>();
        List<String> downResult = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            Signature signature = Signature.from(result.get(i));

            if (bridgeSelections.get(i).equals(BridgeSelection.UP)) {
                upResult.add(signature.getName());
                downResult.add(Signature.NONE.getName());
                continue;
            }

            upResult.add(Signature.NONE.getName());
            downResult.add(signature.getName());
        }

        System.out.println("[ " + String.join(" | ", upResult) + " ]");
        System.out.println("[ " + String.join(" | ", downResult) + " ]");
        System.out.println();
    }

    public static void printResult(GameResult gameResult) {
        System.out.println("최종 게임 결과");
        printMap(gameResult);

        System.out.println("게임 성공 여부: " + gameResult.result().getName());
        System.out.println("총 시도한 횟수: " + gameResult.gameState().tryCount());
    }
}
