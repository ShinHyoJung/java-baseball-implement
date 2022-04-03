package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class Application {

    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final int STRIKE3 = 3;
    private static final int EXISTENCE = 0;
    private static final String ANNOUNCE="숫자를 입력해주세요";
    private static final String CORRECT="정답입니다!";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String MENU1 = "1. 종료";
    private static final String MENU2 = "2. 재시작";

    public static int[] splitNum(int num) {

        int length = (int)(Math.log10(num)+1);

        if(length != 3) {
            throw new IllegalArgumentException();
        }

        int hundred = num / HUNDRED;
        int ten = num % HUNDRED / TEN;
        int one = num % HUNDRED % TEN;
        int [] result = {hundred, ten, one};

        if(hundred==0 || ten==0 || one==0) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public static int countStrike(int[] input, int[] answer) {
        int strike_count=0;

        for(int i=0; i< answer.length; i++) {
           if(input[i] == answer[i]) {
                strike_count++;
           }
        }

        return strike_count;
    }



    public static int countBall(int[] input, int[] answer) {
        int ball_count = 0;

        for(int i=0; i<input.length; i++) {
            for(int j=0; j<answer.length;j++) {
                if(input[i] == answer[j]) {
                    ball_count++;
                }
            }
        }
        return ball_count;
    }

    public static void printBall(int ball) {
        if(ball>EXISTENCE) {
            System.out.println(ball + BALL);
        }
    }

    public static String printStrike(int strike) {

        String str = null;

        if(strike> EXISTENCE) {
            System.out.println(strike + STRIKE);
            str = STRIKE;
            if(strike==STRIKE3) {
                System.out.println(CORRECT);
                str = CORRECT;
            }
        }
        return str;
    }

    public static void printNothing(int strike, int ball) {
        if(strike == EXISTENCE && ball ==EXISTENCE) {
            System.out.println(NOTHING);
        }
    }

    public static int menu() {
        System.out.println(MENU1);
        System.out.println(MENU2);

        int select = Integer.parseInt(Console.readLine());

        return select;
    }

    public static void start(int[] answer) {
        while (true) {

            System.out.println(ANNOUNCE);

            int input = Integer.parseInt(Console.readLine());
            int[] inputnumber = splitNum(input);

            int countstrike = countStrike(answer, inputnumber);
           // int countball = countBall(answer, inputnumber);

           // countball -= countstrike;

            //printNothing(countstrike, countball);
        //    printBall(countball);
            String str = printStrike(countstrike);

            if (str == CORRECT) {
                int select = menu();
                if (select == 1) {
                    break;
                } else if(select ==2) {
                    makeRandom(answer);
                }
            }
        }
    }

    public static void makeRandom(int[] answer) {

        for (int i=0; i< answer.length; i++) {
            int randnum = Randoms.pickNumberInRange(1, 9);
            answer[i] = randnum;
        }
        start(answer);
    }

    public static void main(String[] args) {

        int []answer = new int[3];
        makeRandom(answer);
    }
}


