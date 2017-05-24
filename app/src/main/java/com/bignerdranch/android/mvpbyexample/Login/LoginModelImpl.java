package com.bignerdranch.android.mvpbyexample.Login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Admin on 5/24/2017.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if(username.length()<5){
                    listener.onUsernameError();
                }else if(password.length()<5){
                    listener.onPasswordError();
                }else{
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
