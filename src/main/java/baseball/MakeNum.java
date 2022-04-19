package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class MakeNum {
    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final int LENGTH = 3;
    private static final int ZERO = 0;

    public int[] makeRandom() {
        int[] answer = new int[3];
        int count = 0;
        while (count < LENGTH) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            removeDuplicate(answer, randNum);
        }
        return answer;
    }

    public int[] removeDuplicate(int[] answer, int randNum) {
        int count = 0;
        for (int i=0; i<LENGTH;i++) {
            if (answer[i] != randNum) {
                answer[count] = randNum;
                count++;
                break;
            }
        }
        return answer;
    }

    public int[] splitNum(int num) {

        int length = (int) (Math.log10(num) + 1);

        if (length != LENGTH) {
            throw new IllegalArgumentException();
        }

        int hundred = num / HUNDRED;
        int ten = num % HUNDRED / TEN;
        int one = num % HUNDRED % TEN;
        int[] result = {hundred, ten, one};

        if (ten == ZERO || one == ZERO) {
            throw new IllegalArgumentException();
        }

        if (hundred == ten || hundred == one || ten == one) {
            throw new IllegalArgumentException();
        }
        return result;
    }

}
