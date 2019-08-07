package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    @Test
    public void whenAddNewUserWith2Accounts() {
        Bank bank = new Bank();
        bank.addUser(new User("Niyaz", "1111"));
        Account account1 = new Account(100, "1234");
        Account account2 = new Account(200, "2345");
        bank.addAccountToUser("1111", account1);
        bank.addAccountToUser("1111", account2);
        List<Account> result = bank.getUserAccounts("1111");
        List<Account> except = List.of(account1, account2);
        assertThat(result, is(except));
    }

    @Test
    public void whenTransferFromUser1ToUser2() {
        Bank bank = new Bank();
        bank.addUser(new User("Niyaz", "1111"));
        bank.addUser(new User("Damir", "2222"));
        Account account1 = new Account(100, "1234");
        Account account2 = new Account(200, "2345");
        bank.addAccountToUser("1111", account1);
        bank.addAccountToUser("2222", account2);
        boolean bln = bank.transferMoney("1111", "1234", "2222", "2345", 50);
        double result = account1.getValue();
        double except = 50;
        assertThat(result, is(except));
    }

}
