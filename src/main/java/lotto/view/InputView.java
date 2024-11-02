package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int inputPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return validatePurchase(input);
    }

    public List<Integer> WinNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();
        return validateWinNumber(input);
    }

    public int BonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = Console.readLine();
        return validateBonusNumber(input);
    }

    static int validatePurchase(String input) {
        int lottoAmount = Integer.parseInt(input);
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 살 수 있습니다");
        }
        return lottoAmount / 1000;
    }

    static List<Integer> validateWinNumber(String input) {
        String[] LottoNumber = input.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        try {
            for (String number : LottoNumber) {
                winNumbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 하고, 쉼표(,)로 구분되어야 합니다.");
        }
        return winNumbers;
    }

    static int validateBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}