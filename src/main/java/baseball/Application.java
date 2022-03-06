package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        int num = Randoms.pickNumberInRange(100, 999);

        int hundred = num / 100;
        int ten = num % 100 / 10;
        int one = num % 100 % 10;


        while (true) {

            System.out.println("숫자를 입력하세요.");
            int input = Integer.parseInt(Console.readLine());

            int num1 = input / 100;
            int num2 = input % 100 / 10;
            int num3 = input % 100 % 10;

            if (hundred == num1 && ten == num2 && one == num3) {
                System.out.println("3스트라이크 정답입니다.");
            } else if (hundred == num1 && ten == num2) {
                System.out.println("2스트라이크");
            } else if(hundred == num1 && one == num3) {
                System.out.println("2스트라이크");
            } else if(ten == num2 && one == num3) {
                System.out.println("2스트라이크");
            } else if(hundred == num1) {
                System.out.println("1스트라이크");
            } else if(ten == num2) {
                System.out.println("1스트라이크");
            } else if(one == num3) {
                System.out.println("1스트라이크");
            }
        }

    }
}