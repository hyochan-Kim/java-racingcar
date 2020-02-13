package racingcar.domain;

/**
 * 게임 횟수 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class Round {
    public static final int MAX_TOTAL_ROUND = 100;
    public static final int START_ROUND = 1;
    public static final String TOTAL_ROUND_OUT_OF_RANGE_MESSAGE = "Input total round out of range(1,100)";
    public static final String LAST_ROUND_MESSAGE = "Current round is last round.";

    private final int totalRound;
    private int currentRound;

    public Round(final int totalRound) {
        validateTotalRound(totalRound);
        this.totalRound = totalRound;
        currentRound = START_ROUND;
    }

    private void validateTotalRound(final int totalRound) {
        if (totalRound < START_ROUND || totalRound > MAX_TOTAL_ROUND) {
            throw new IllegalArgumentException(TOTAL_ROUND_OUT_OF_RANGE_MESSAGE);
        }
    }

    public void next() {
        if (currentRound >= totalRound) {
            throw new IllegalArgumentException(LAST_ROUND_MESSAGE);
        }
        currentRound++;
    }

    public boolean isRoundOf(final int round) {
        return currentRound == round;
    }

    public boolean isFinal() {
        return currentRound == totalRound;
    }
}
