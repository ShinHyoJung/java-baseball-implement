package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Count.countBall;
import static baseball.Count.countStrike;
import static baseball.Print.print;
import static baseball.MakeNum.makeRandom;
import static baseball.MakeNum.splitNum;

public class Application {

    private static int LENGTH = 3;
    private static final String ANNOUNCE="숫자를 입력해주세요";
    private static final String MENU_END_DESCRIPTION = "1. 종료";
    private static final String MENU_RESTART_DESCRIPTION = "2. 재시작";
    private static final int MENU_END = 1;
    private static final int MENU_RESTART = 2;

    public static int menu() {

        System.out.println(MENU_END_DESCRIPTION);
        System.out.println(MENU_RESTART_DESCRIPTION);

        int select = Integer.parseInt(Console.readLine());

        if (select == MENU_END) {
            select = 1;
        } else if (select == MENU_RESTART) {
            main();
        }
        return select;
    }

    public static void run(int[] answer) {
        int i=0;
        do {

            System.out.println(ANNOUNCE);

            int input = Integer.parseInt(Console.readLine());
            int[] inputNumber = splitNum(input);

            int strike = countStrike(inputNumber, answer);
            int ball = countBall(inputNumber, answer);

            print(strike, ball);

            if (strike == LENGTH) {
                int select = menu();
                i = select;
            }


        } while(i != 1);
    }


    public static void main(String[] args) {

        int[] answer = makeRandom();
        run(answer);
    }
}


