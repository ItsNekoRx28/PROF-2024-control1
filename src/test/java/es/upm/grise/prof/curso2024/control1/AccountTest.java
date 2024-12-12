package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class AccountTest {

    @Test
    void testGetCurrentBalance() {
        // Configuración de valores de prueba
        final String ACCOUNT_NUMBER = "12345";
        final float INITIAL_AMOUNT = 1000.0f;
        final float TRANSACTION_1_AMOUNT = 200.0f;
        final float TRANSACTION_2_AMOUNT = -150.0f;
        final float EXPECTED_BALANCE = INITIAL_AMOUNT + TRANSACTION_1_AMOUNT + TRANSACTION_2_AMOUNT;

        // Crear un mock para la clase Transaction
        Transaction transaction1 = mock(Transaction.class);
        Transaction transaction2 = mock(Transaction.class);

        // Configurar el comportamiento de los mocks
        when(transaction1.getAmount()).thenReturn(TRANSACTION_1_AMOUNT);
        when(transaction2.getAmount()).thenReturn(TRANSACTION_2_AMOUNT);

        // Crear la cuenta y añadir las transacciones
        Account account = new Account(ACCOUNT_NUMBER, INITIAL_AMOUNT);
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);
        
        // Ejecutar el método a probar
        float currentBalance = account.getCurrentBalance();

        // Verificar el resultado
        assertEquals(EXPECTED_BALANCE, currentBalance, 0.01f, "El saldo actual no es el esperado");
    }
}
