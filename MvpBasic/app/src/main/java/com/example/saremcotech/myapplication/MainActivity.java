package com.example.saremcotech.myapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    private MainActivityPresenter presenter;
    private TextView nameTextView, emailTextView;
    private ProgressBar progressBar;
    private Button nameBtn, emailBtn;
    private EditText name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        initUi();
        initProgressBar();
        initClickListeneres();
    }

    private void initUi() {
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.emailEditText);
        nameBtn = findViewById(R.id.nameBtn);
        emailBtn = findViewById(R.id.emailBtn);
    }
    private void initClickListeneres()
    {
        nameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.updateName(name.getText().toString());
                hideProgressBar();
            }
        });
        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.updateEmail(email.getText().toString());
                hideProgressBar();
            }
        });
    }
    @Override
    public void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,
                250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar, params);
        showProgressBar();
    }

    @Override
    public void updateUserInfo(UserModel user) {
        nameTextView.setText("Name: "+user.getName());
        emailTextView.setText("Email: "+user.getEmail());
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
