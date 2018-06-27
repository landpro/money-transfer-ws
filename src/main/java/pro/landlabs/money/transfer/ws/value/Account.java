package pro.landlabs.money.transfer.ws.value;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Account {

    private final int id;
    private final BigDecimal balance;

    @JsonCreator
    public Account(@JsonProperty("id") int id, @JsonProperty("balance") BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}