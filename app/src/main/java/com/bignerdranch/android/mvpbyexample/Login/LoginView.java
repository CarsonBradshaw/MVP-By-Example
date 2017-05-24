package com.bignerdranch.android.mvpbyexample.Login;

/**
 * Created by Admin on 5/24/2017.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setLoginSuccessMessage();

    void setLoginFailureMessage();

    void navigateToMain();
}
