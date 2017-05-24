package com.bignerdranch.android.mvpbyexample.Login;

/**
 * Created by Admin on 5/24/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginModel.OnLoginFinishedListener {
    private LoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
        this.mLoginModel = new LoginModelImpl();
    }

    @Override
    public void validateLogin(String username, String password) {
        if(mLoginView!=null){
            mLoginView.showProgress();
        }

        mLoginModel.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        mLoginView=null;
    }


    @Override public void onUsernameError() {
        if (mLoginView != null) {
            mLoginView.setLoginFailureMessage();
            mLoginView.hideProgress();
        }
    }

    @Override public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.setLoginFailureMessage();
            mLoginView.hideProgress();
        }
    }

    @Override public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.setLoginSuccessMessage();
            mLoginView.navigateToMain();
        }
    }
}
