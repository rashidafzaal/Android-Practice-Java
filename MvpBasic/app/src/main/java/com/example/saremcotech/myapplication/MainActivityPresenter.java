package com.example.saremcotech.myapplication;


public class MainActivityPresenter {

    private UserModel user;
    private View view;

    public MainActivityPresenter(View view) {
        this.user = new UserModel();
        this.view = view;
    }

    public void updateName(String name)
    {
        user.setName(name);
        view.updateUserInfo(user);
    }

    public void updateEmail(String email){
        user.setEmail(email);
        view.updateUserInfo(user);

    }

    public interface View{

        void updateUserInfo(UserModel user);
        void initProgressBar();
        void showProgressBar();
        void hideProgressBar();

    }
}