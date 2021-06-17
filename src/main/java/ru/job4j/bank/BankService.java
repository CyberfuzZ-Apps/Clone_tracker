package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель банковской системы.
 * В системе можно производить следующие действия:
 * - добавлять пользователя в систему
 * - добавлять счет пользователю (счетов у пользователя может быть несколько)
 * - находить пользователя по номеру паспорта
 * - находить счет пользователя по реквизитам и номеру паспорта
 * - переводить деньги с одного счета на другой
 * @author EVGENIY ZAYCEV
 * @version 1.0
 */
public class BankService {
    /**
     * Поле класса содержит список всех пользователей в HashMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и если его еще нет в списке -
     * добавляет в список пользователей.
     * @param user пользователь, которого нужно добавить в список пользователей.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и номер банковского
     * счета, который необходимо добавить в список счетов пользователя,
     * если такого счета еще нет.
     * @param passport номер паспорта пользователя
     * @param account номер банковского счета, который необходимо добавить пользователю
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> ac = users.get(user.get());
            if (!ac.contains(account)) {
                ac.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта пользователя, ищет этого
     * пользователя в списке пользователей и возвращает пользователя, если
     * тот есть в списке. Либо возвращает null, если пользователя с таким
     * номером паспорта в списке нет.
     * @param passport номер паспорта пользователя
     * @return user (пользователь), либо null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и реквизиты счета,
     * находит пользователя по номеру паспорта. Если пользователь найден, то
     * получает список счетов пользователя и сравнивает этот список счетов с
     * реквизитами, поступающими на вход. Если счет с такими реквизитами найден -
     * возвращает этот счет, если нет - возвращает null.
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты банковского счета пользователя
     * @return возвращает найденный банковский счет или null, если счет не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод переводит деньги с одного банковского счета на другой.
     * Если номера счетов и номера паспортов существуют и сумма перевода
     * не превышает остаток счета с которого переводят, то деньги переводятся
     * и возвращается true. Если хоть одно из выше перечисленных условий не проходит,
     * то деньги не переводятся и возвращается false.
     * @param srcPassport номер паспорта пользователя, который переводит деньги
     * @param srcRequisite реквизиты счета с которого переводят
     * @param destPassport номер паспорта пользователя, которому переводят деньги
     * @param destRequisite реквизиты счета на который переводят
     * @param amount сумма перевода
     * @return возвращает true, если перевод был совершен, либо false, если перевод не совершен.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
