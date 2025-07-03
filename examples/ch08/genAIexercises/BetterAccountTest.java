// 8.5.2节, 生成式AI练习: BetterAccountTest.java
// 重构图8.6的代码，使用可重用的方法来简化

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class BetterAccountTest {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // 初始化账户
        Account account1 = new Account("Zhou Jing", new BigDecimal("50.00"));
        Account account2 = new Account("Logan Brown", new BigDecimal("-7.53"));

        // 显示初始余额
        displayBalances(account1, account2);

        // 处理account1存款
        processDeposit(account1, "account1");
        displayBalances(account1, account2);

        // 处理account2存款
        processDeposit(account2, "account2");
        displayBalances(account1, account2);
    }

    /**
     * 处理存款操作
     * @param account 要存款的账户对象
     * @param accountName 账户名称提示(用于交互)
     */
    private static void processDeposit(Account account, String accountName) {
        System.out.printf("请输入%s的存款金额: ", accountName);
        BigDecimal depositAmount = input.nextBigDecimal();
        
        System.out.printf("%n正在将%s加到%s的余额上%n%n", 
            formatCurrency(depositAmount), accountName);
        
        account.deposit(depositAmount);
    }

    /**
     * 格式化金额显示（保留2位小数，银行家舍入法）
     * @param amount 要格式化的金额
     * @return 格式化后的字符串
     */
    private static String formatCurrency(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_EVEN).toString();
    }

    /**
     * 显示多个账户的余额信息
     * @param accounts 可变参数，可传入多个账户
     */
    private static void displayBalances(Account... accounts) {
        for (Account account : accounts) {
            System.out.printf("%s的余额是: $%s%n", 
                account.getName(), formatCurrency(account.getBalance()));
        }
        System.out.println();
    }
}