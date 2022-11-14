package lotto.constant;

public enum LotteryRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE_BY_TWO(2, 0),
    LOSE_BY_ONE(1, 0),
    LOSE_BY_ZERO(0, 0),
    BEFORE_DRAW(-1, 0);

    private int numberOfMatches;
    private int reward;

    public static LotteryRank findRank (int numberOfMatches, boolean hasBonusNumber) {
        if (numberOfMatches == SECOND.getNumberOfMatches()) {
            if (hasBonusNumber) {
                return LotteryRank.SECOND;
            }
            return LotteryRank.THIRD;
        }

        for (LotteryRank rank : LotteryRank.values()) {
            if (rank.getNumberOfMatches() == numberOfMatches) {
                return rank;
            }
        }

        return BEFORE_DRAW;
    }

    private LotteryRank (int numberOfMatches, int reward) {
        this.numberOfMatches = numberOfMatches;
        this.reward = reward;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getReward() {
        return reward;
    }
}
