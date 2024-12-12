package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private static final String ACCOUNT_ONE_NUMBER = "ACC1";
    private static final String ACCOUNT_TWO_NUMBER = "ACC2";
    private static final String ACCOUNT_THREE_NUMBER = "ACC3";

    private static final float ACCOUNT_ONE_BALANCE = 100;
    private static final float ACCOUNT_TWO_BALANCE = 500;
    private static final float ACCOUNT_THREE_BALANCE = 5;

    private Customer customer;

    @BeforeEach
    void setUp() {
        Account account1 = new Account(ACCOUNT_ONE_NUMBER, ACCOUNT_ONE_BALANCE);
        Account account2 = new Account(ACCOUNT_TWO_NUMBER, ACCOUNT_TWO_BALANCE);
        Account account3 = new Account(ACCOUNT_THREE_NUMBER, ACCOUNT_THREE_BALANCE);

        customer = new Customer();
        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);
    }

    @Test
    void testGetAccountWithHighestBalance() {
        try {
            String accountWithHighestBalance = customer.getAccountWithHighestBalance();

            assertEquals(ACCOUNT_TWO_NUMBER, accountWithHighestBalance,
                    "El método no devuelve correctamente la cuenta con el mayor saldo");
        } catch (NoAccountsException e) {
            fail("No debería lanzar excepción");
        }
    }

    @Test
    public void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        Customer customer = new Customer();

        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();
        });
    }
}

