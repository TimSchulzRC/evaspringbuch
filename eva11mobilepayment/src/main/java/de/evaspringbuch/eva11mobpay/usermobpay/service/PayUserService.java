package de.evaspringbuch.eva11mobpay.usermobpay.service;

import de.evaspringbuch.eva11mobpay.usermobpay.domain.PayUser;
import de.evaspringbuch.eva11mobpay.usermobpay.domain.State;

public interface PayUserService {
    int getAccountBalanceByName(String userId);

    boolean containsAndAvailable(String userId);

    State getState(String userId);

    void openAccount(String userId);

    String transfer(String from, String to, int amount) throws PayUserException;

    boolean deleteUser(String userId);

    void changeUserToSuspendedState(String userId);

    PayUser getPayUser(String userId);
}
