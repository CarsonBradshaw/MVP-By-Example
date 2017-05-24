package com.bignerdranch.android.mvpbyexample.Login;

/**
 * Created by Admin on 5/24/2017.
 */

public interface LoginPresenter {
    void validateLogin(String username, String password);
    void onDestroy();
}
