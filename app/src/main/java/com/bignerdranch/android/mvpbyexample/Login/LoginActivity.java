package com.bignerdranch.android.mvpbyexample.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bignerdranch.android.mvpbyexample.R;
import com.bignerdranch.android.mvpbyexample.main.MainActivity;

/**
 * Created by Admin on 5/24/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        progressBar = (ProgressBar)findViewById(R.id.progress);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        presenter.validateLogin(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setLoginSuccessMessage() {
        Toast.makeText(this, "Login Worked!",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoginFailureMessage() {
        Toast.makeText(this, "Login Failure! Try again with at least length 5.",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
