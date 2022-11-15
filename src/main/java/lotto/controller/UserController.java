package lotto.controller;

import lotto.domain.User;
import lotto.service.LotteryCheckService;
import lotto.service.LotterySellService;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserController {
    static UserService userService = new UserService();
    static LotterySellService lotterySellService = new LotterySellService();
    static LotteryCheckService lotteryCheckService = new LotteryCheckService();

    private static User user;

    public static void buyLotteryTicket() throws IllegalArgumentException {
        int money = InputView.takeMoneyInput();
        user = userService.createUser(money);
        lotterySellService.sell(user);
        OutputView.showPurchaseList(user.findAllLotteryNumbers());
    }

    public static void checkLotteryResult() {
        lotteryCheckService.updateUserLotteryResult(user);
        OutputView.showWinningResult(
                user.countWinningTicketsByRank(),
                user.getNumberOfTickets(),
                user.getTotalReward()
        );
    }
}
