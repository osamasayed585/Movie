package com.seenapay.movie.dialogs;


import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.seenapay.movie.R;
import com.seenapay.movie.network.Models.responses.BaseResponse;
import com.seenapay.movie.utils.PreferencesManager;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;


public class ErrorHandlerDialog {

    private final Context context;
    private final AlertDialog errorAlertDialog;

    @Inject
    PreferencesManager mPreferencesManager;

    @Inject
    public ErrorHandlerDialog(@ActivityContext Context context, AlertDialog errorAlertDialog) {
        this.context = context;
        this.errorAlertDialog = errorAlertDialog;

        errorAlertDialog.setTitle(context.getString(R.string.error));
        errorAlertDialog.setCancelable(false);
    }

    public void setBaseResponse(BaseResponse response, DialogInterface.OnClickListener onClickListener) {
        if (response.isSuccess()) {
            errorAlertDialog.setMessage(context.getString(R.string.please_check_your_internet_connection));
            errorAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, context.getResources().getString(R.string.ok), onClickListener);
        } else {
            errorAlertDialog.setMessage(response.getCopyright());
            errorAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, context.getResources().getString(R.string.ok), (dialog, which) -> errorAlertDialog.dismiss());
        }

    }

    public void show() {
        errorAlertDialog.show();
    }

    public void dismiss() {
        errorAlertDialog.dismiss();
    }

}
