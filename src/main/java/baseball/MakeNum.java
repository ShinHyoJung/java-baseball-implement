package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class MakeNum {
    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final int LENGTH = 3;
    private static final int ZERO = 0;

    public static int[] makeRandom() {
        int []answer = new int[3];

        for (int i=0; i< answer.length; i++) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            answer[i] = randNum;
            for(int j=0; j<i; j++) {
                if (answer[i] == answer[j]) {
                    i--;
                    break;
                }
            }
        }
        return answer;
    }

    public static int[] splitNum(int num) {

        int length = (int)(Math.log10(num)+1);


        if(length != LENGTH) {
            throw new IllegalArgumentException();
        }

        int hundred = num / HUNDRED;
        int ten = num % HUNDRED / TEN;
        int one = num % HUNDRED % TEN;
        int [] result = {hundred, ten, one};

        if(ten==ZERO || one==ZERO) {
            throw new IllegalArgumentException();
        }

        if(hundred == ten || hundred == one || ten == one) {
            throw new IllegalArgumentException();
        }

        return result;
    }

}
