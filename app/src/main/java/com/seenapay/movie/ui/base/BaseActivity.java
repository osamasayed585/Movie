package com.seenapay.movie.ui.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.ybq.android.spinkit.SpinKitView;
import com.seenapay.movie.databinding.ActivityBaseBinding;
import com.seenapay.movie.dialogs.ErrorHandlerDialog;
import com.seenapay.movie.network.Models.responses.BaseResponse;
import com.seenapay.movie.utils.HelperMethods;
import com.seenapay.movie.utils.PreferencesManager;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BaseActivity extends AppCompatActivity {


    @Inject
    PreferencesManager preferencesManager;

    @Inject
    public ErrorHandlerDialog errorHandlerDialog;

    public SpinKitView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelperMethods.setLocale(this, preferencesManager.getLanguage());
    }

    @Override
    public void setContentView(View view) {
        ActivityBaseBinding binding = ActivityBaseBinding.inflate(getLayoutInflater());
        progressView = binding.progressView;
        binding.fContainer.addView(view);
        super.setContentView(binding.getRoot());
    }

    public void onLoading(boolean isLoading) {
        if (isLoading) {
            if (progressView.getVisibility() != View.VISIBLE)
                progressView.setVisibility(View.VISIBLE);
        } else
            progressView.setVisibility(View.GONE);
    }

    public void onApiError(BaseResponse response) {
        errorHandlerDialog.setBaseResponse(response, this::onErrorHandlerDialogOkClick);
        errorHandlerDialog.show();
    }

    private void onErrorHandlerDialogOkClick(DialogInterface dialog, int which) {
        errorHandlerDialog.dismiss();
        finish();
        startActivity(getIntent());
    }

    public void onBackClick(View view) {
        finish();
    }

}
