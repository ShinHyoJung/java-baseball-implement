package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        int num = Randoms.pickNumberInRange(100, 999);


        int hundred = num / 100;
        int ten = num % 100 / 10;
        int one = num % 100 % 10;
        int[] result = {hundred, ten, one};


        while (true) {

            int count = 0;
            System.out.println("숫자를 입력하세요.");
            int input = Integer.parseInt(Console.readLine());

            int num1 = input / 100;
            int num2 = input % 100 / 10;
            int num3 = input % 100 % 10;

            int[] number = {num1, num2, num3};

            for (int i = 0; i < 3; i++) {

                if (number[i] == result[i]) {
                    System.out.println(number[i] +  " " +  result[i]);
                    System.out.println(i);
                    count++;
                }

            }
            if(count > 0) {
                System.out.print(count + "스트라이크");

                if(count == 3) {
                    System.out.println("정답입니다!");
                    break;
                }
            } else {
                System.out.println("낫싱");
            }
        }
// 볼 = 볼 - 스트라이크
    }
}
    /*
    private static void ball(int num) {

        int hundred = num / 100;
        int ten = num % 100 / 10;
        int one = num % 100 % 10;
        int[] result = {hundred, ten, one };

        int input = Integer.parseInt(Console.readLine());

        int num1 = input / 100;
        int num2 = input % 100 / 10;
        int num3 = input % 100 % 10;


        int count=0;
        int [] number = {num1, num2, num3};

        for(int i=0; i<(result.length); i++) {
            for(int j=0; j<(number.length); j++) {

                if(result[i] == number[j]) {
                    count++;

                }
            }

        }

        if(count >0) {
            System.out.print(count + "볼 ");
        }
        else {

        }


}
*/
