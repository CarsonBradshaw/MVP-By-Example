package com.bignerdranch.android.mvpbyexample.Login;

/**
 * Created by Admin on 5/24/2017.
 */

public interface LoginModel {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
