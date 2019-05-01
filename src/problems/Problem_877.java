package problems;

/**
 * Alex and Lee play a game with piles of stones. There are an even number of piles arranged in a row, and each pile
 * has a positive integer number of stones piles[i]. The objective of the game is to end with the most stones.
 * The total number of stones is odd, so there are no ties. Alex and Lee take turns, with Alex starting first.
 * Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.
 * This continues until there are no more piles left, at which point the person with the most stones wins.
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */
public class Problem_877 {

    // not done
    public boolean stoneGame(int[] piles) {
        int stonesSum = 0;
        int x = 0;
        int y = 0;
        int begin = 0;
        int end = piles.length - 1;
        for (int i : piles)
            stonesSum += i;
        for (int i = 1; i <= piles.length; i++) {
            int which = decide(piles, begin, end);
            if (i % 2 == 1) {
                // x's turn & takes the greater option
                x += piles[which];
            } else {
                // y's turn
                y += piles[which];
            }
            if (which == begin) begin++;
            else end--;
            if (x > stonesSum / 2)
                return true;
            else if (y > stonesSum / 2)
                return false;
        }
        return x > y;
    }

    private int decide(int[] piles, int begin, int end) {
        boolean shouldConsider = end + 1 - begin > 3;
        if (piles[begin] > piles[end]) {
            if (shouldConsider && piles[begin + 1] + piles[end] > piles[begin]) return end;
            else return begin;
        } else {
            if (shouldConsider && piles[end - 1] + piles[begin] > piles[end]) return begin;
            else return end;
        }
    }
}
