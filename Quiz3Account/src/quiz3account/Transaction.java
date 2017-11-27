package quiz3account;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    // deposit or withdrawal must be null,
    // otherwise throw InvalidArgumentException with message explaining
    public Transaction(Date date, BigDecimal deposit, BigDecimal withdrawal) {
        transactionDate = date;
        if ((deposit == null && withdrawal != null) ||
                (deposit != null && withdrawal == null)) {
            depositAmount = deposit;
            withdrawalAmount = withdrawal;
        } else {
            throw new IllegalArgumentException("Must withdraw or deposit, not both or neither");
        }
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    private BigDecimal depositAmount, withdrawalAmount;
    private Date transactionDate; // type in MySQL is DATETIME
}
