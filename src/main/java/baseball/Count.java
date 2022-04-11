package baseball;

public class Count {

    private static int START_NUM = 0;

    public static int countStrike(int[] input, int[] answer) {
        int strikeCount = START_NUM;

        for (int i = START_NUM; i < answer.length; i++) {
            if (input[i] == answer[i]) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int countBall(int[] input, int[] answer) {
        int ballCount = START_NUM;

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

