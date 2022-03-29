package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        System.out.println("시작");
        int num = Randoms.pickNumberInRange(100, 999);

        int select;
        int hundred = num / 100;
        int ten = num % 100 / 10;
        int one = num % 100 % 10;
        int[] result = {hundred, ten, one};


        while (true) {

            int strike_count = 0;
            int ball_count = 0;
            System.out.println("숫자를 입력하세요.");
            int input = Integer.parseInt(Console.readLine());

            int num1 = input / 100;
            int num2 = input % 100 / 10;
            int num3 = input % 100 % 10;

            int[] number = {num1, num2, num3};

            for (int i = 0; i < 3; i++) {

                if (number[i] == result[i]) {

                    strike_count++;
                }

            }

            for(int i=0; i<3; i++)
                for(int j=0; j<3; j++) {
                if(number[i] == result[j]) {
                    ball_count++;

                }
            }
            ball_count = ball_count - strike_count;

            if(ball_count>0) {
                if(strike_count>0) {
                    System.out.print(ball_count + "볼");
                } else {
                    System.out.println(ball_count + "볼");
                }
            }

            if(strike_count > 0) {
                System.out.println(strike_count + "스트라이크");

                if(strike_count == 3) {
                    System.out.println("정답입니다!");
                    System.out.println("1. 종료");
                    System.out.println("2. 재시작");

                    select = Integer.parseInt(Console.readLine());

                    if(select ==1) {
                        break;
                    } else if(select ==2) {
                    // 재시작 구현
                    }
                }
            }

            if(ball_count ==0 && strike_count ==0) {
                System.out.println("낫싱");
            }
        }
// 볼 = 볼 - 스트라이크
    }
}


