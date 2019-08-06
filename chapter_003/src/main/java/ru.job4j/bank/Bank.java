package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавить нового пользователя
     *
     * @param user Пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Delete user.
     *
     * @param user User.
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * Add new account to user by passport.
     *
     * @param passport User passport;
     * @param account  New account;
     */
    public void addAccountToUser(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            users.get(user).add(account);
        }
    }

    /**
     * Delete account from user by passport.
     *
     * @param passport User passport.
     * @param account  Account.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            users.get(user).remove(account);
        }
    }

    /**
     * Get user accounts.
     *
     * @param passport Users passport.
     * @return Accounts.
     */
    public List<Account> getUserAccounts(String passport) {
        User user = findByPassport(passport);
        return (user != null) ? users.get(user) : new ArrayList<>();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean res = false;
        Account srcAccount = findAccount(srcPassport, srcRequisite);
        Account destAccount = findAccount(destPassport, dstRequisite);
        if ((srcAccount != null) && (destAccount != null) && (srcAccount.getValue() > amount)) {
            srcAccount.changeValue(-amount);
            destAccount.changeValue(amount);
            res = true;
        }
        return res;
    }

    private User findByPassport(String passport) {
        Set<User> keys = users.keySet();
        return keys.stream().filter(n->n.getPassport().equals(passport)).findFirst().get();
//        for (User user : keys) {
//            if (user.getPassport().equals(passport)) {
//                result = user;
//                break;
//            }
//        }
//        return result;
    }

    private Account findAccount(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = new ArrayList<>();
        if (user != null) {
            accounts = users.get(user);
        }
        Account result = null;
        return accounts.stream().filter(n->n.getRequisites().equals(requisite)).findFirst().get();
//        for (Account account : accounts) {
//            if (account.getRequisites().equals(requisite)) {
//                result = account;
//                break;
//            }
//        }
//        return result;
    }


}
