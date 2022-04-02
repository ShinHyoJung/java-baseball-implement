package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class Application {

    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final String CORRECT="정답입니다!";

    public static int[] splitNum(int num) {

        int hundred = num / HUNDRED;
        int ten = num % HUNDRED / TEN;
        int one = num % HUNDRED % TEN;
        int [] result = {hundred, ten, one};

        return result;
    }

    public static int countStrike(int[] input, int[] answer) {
        int strike_count=0;

        for(int i=0; i<3; i++) {
           if(input[i] == answer[i]) {
                strike_count++;
           }
        }

        return strike_count;
    }



    public static int countBall(int[] input, int[] answer) {
        int ball_count = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3;j++) {

                if(input[i] == answer[j]) {
                    ball_count++;
                }
            }
        }
        return ball_count;
    }

    public static void printBall(int ball) {
        if(ball>0) {
            System.out.println(ball + "볼");
        }
    }

    public static String printStrike(int strike) {

        String str = null;

        if(strike> 0) {
            System.out.println(strike + "스트라이크");
            str = "스트라이크";
            if(strike==3) {
                System.out.println(CORRECT);
                str = CORRECT;
            }
        }
        return str;
    }

    public static void printNothing(int strike, int ball) {
        if(strike == 0 && ball ==0) {
            System.out.println("낫싱");
        }
    }

    public static int Menu() {
        System.out.println("1. 종료");
        System.out.println("2. 재시작");

        int select = Integer.parseInt(Console.readLine());

        return select;
    }

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        System.out.println("시작");
        int randnum = Randoms.pickNumberInRange(100, 999);

        int[] answer = splitNum(randnum);


        while (true) {

            System.out.println("숫자를 입력하세요.");
            int input = Integer.parseInt(Console.readLine());

            int[] inputnumber = splitNum(input);
            int countstrike = countStrike(answer, inputnumber);
            int countball = countBall(answer, inputnumber);

            countball -= countstrike;

            System.out.println(countstrike + " " + countball);

            printNothing(countstrike, countball);
            printBall(countball);
            String str = printStrike(countstrike);

            if(str == CORRECT) {
             int select = Menu();
                if(select ==1) {
                     break;
                }
            }

        }


    }
}


