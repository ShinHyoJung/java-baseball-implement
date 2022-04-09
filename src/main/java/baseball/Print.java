package baseball;

public class Print {

    private static final String CORRECT="정답입니다!";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final int LENGTH = 3;
    private static final int EXISTENCE = 0;

    public static void print(int strike, int ball) {

        if(strike > EXISTENCE) {
            System.out.println(strike + STRIKE);

            if(strike==LENGTH) {
                System.out.println(CORRECT);

            }
        }

        if(ball>EXISTENCE) {
            System.out.println(ball + BALL);
        }

        if(strike == EXISTENCE && ball ==EXISTENCE) {
            System.out.println(NOTHING);
        }
    }
}
