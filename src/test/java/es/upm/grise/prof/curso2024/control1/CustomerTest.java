package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerTest {
    private Customer customer;

    @Mock
    private Account account1;

    @Mock
    private Account account2;

    @Mock
    private Account account3;
    
    private static final String ACCOUNT_ONE_NUMBER = "ACC1";
    private static final String ACCOUNT_TWO_NUMBER = "ACC2";
    private static final String ACCOUNT_THREE_NUMBER = "ACC3";

    private static final float ACCOUNT_ONE_BALANCE = 100;
    private static final float ACCOUNT_TWO_BALANCE = 500;
    private static final float ACCOUNT_THREE_BALANCE = 5;

    @Test
    void testGetAccountWithHighestBalance() {
        Account account1 = new Account(ACCOUNT_ONE_NUMBER, ACCOUNT_ONE_BALANCE);
        Account account2 = new Account(ACCOUNT_TWO_NUMBER, ACCOUNT_TWO_BALANCE);
        Account account3 = new Account(ACCOUNT_THREE_NUMBER, ACCOUNT_THREE_BALANCE);

        Customer customer = new Customer();
        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        try {
            String accountWithHighestBalance = customer.getAccountWithHighestBalance();

            assertEquals(ACCOUNT_TWO_NUMBER, accountWithHighestBalance,
                    "El método no devuelve correctamente la cuenta con el mayor saldo");
        } catch (NoAccountsException e) {
            fail("No debería lanzar excepción");
        }
    }

    @Test
    void testGetAccountWithHighestBalanceMockito() throws NoAccountsException {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        when(account1.getAccountNumber()).thenReturn("123456");
        when(account1.getCurrentBalance()).thenReturn(1000.0f);

        when(account2.getAccountNumber()).thenReturn("654321");
        when(account2.getCurrentBalance()).thenReturn(2000.0f);

        when(account3.getAccountNumber()).thenReturn("789012");
        when(account3.getCurrentBalance()).thenReturn(1500.0f);

        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        String highestBalanceAccount = customer.getAccountWithHighestBalance();

        assertEquals("654321", highestBalanceAccount);
    }

    @Test
    public void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        Customer customer = new Customer();

        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();
        });
    }
}

