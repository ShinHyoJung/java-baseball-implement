package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Application {
    private static final int LENGTH = 3;
    private static final int START_NUM = 0;
    private static final int END_NUM = 1;
    private static final int RESTART_NUM = 2;
    private static final String READY_ANNOUNCE = "준비되었습니다.";
    private static final String ANNOUNCE = "숫자를 입력해주세요:";
    private static final String END_ANNOUNCE = "게임 종료";
    private static final String MENU_END_DESCRIPTION = "1. 종료";
    private static final String MENU_RESTART_DESCRIPTION = "2. 재시작";
    private static final int MENU_END = 1;
    private static final int MENU_RESTART = 2;

    public static int menu() {
        System.out.println(MENU_END_DESCRIPTION);
        System.out.println(MENU_RESTART_DESCRIPTION);

        int select = Integer.parseInt(Console.readLine());

        if (select == MENU_END) {
            select = END_NUM;
        } else if (select == MENU_RESTART) {
            select = RESTART_NUM;
        }
        return select;
    }

    public static void run(int[] answer) {
        int STATUS = START_NUM;
        do {
            System.out.print(ANNOUNCE);

            int input = Integer.parseInt(Console.readLine());
            MakeNum split = new MakeNum();
            int[] inputNumber = split.splitNum(input);

            Count count = new Count();
            int strike = count.countStrike(inputNumber, answer);
            int ball = count.countBall(inputNumber, answer);

            Print print = new Print();
            print.print(strike, ball);

            if (strike == LENGTH) {
                STATUS = menu();
            }

            if (STATUS == END_NUM) {
                System.out.println(END_ANNOUNCE);
            }

            if(STATUS == RESTART_NUM) {
               // main(new String[]{});
            }

        } while (STATUS != END_NUM);
    }

    public static int[] ready() {
        MakeNum makeRandom = new MakeNum();
        int[] answer = makeRandom.makeRandom();
        System.out.println(READY_ANNOUNCE);

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = ready();
        run(answer);
    }
}


