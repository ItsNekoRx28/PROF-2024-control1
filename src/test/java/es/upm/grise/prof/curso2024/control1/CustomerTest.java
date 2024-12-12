package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        Customer customer = new Customer();

        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();
        });
    }
}

