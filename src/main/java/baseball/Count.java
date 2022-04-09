package baseball;

public class Count {

    public static int countStrike(int[] input, int[] answer) {
        int strikeCount = 0;

        for (int i = 0; i < answer.length; i++) {
            if (input[i] == answer[i]) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int countBall(int[] input, int[] answer) {
        int ballCount = 0;

        for (int i : input) {
            for (int j : answer) {
                if (i == j) {
                    ballCount++;
                }
            }
        }
        return ballCount -= countStrike(input, answer);
    }
}

