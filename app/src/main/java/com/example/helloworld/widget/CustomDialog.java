package com.example.helloworld.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helloworld.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    private String title, message, cancel, confirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;


    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;

    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layou_custom_dialog);
        //设置屏幕宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8); //设置dialogde的宽度为当前手机屏幕宽度*0.8
        getWindow().setAttributes(p);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                dismiss();

                break;
            case R.id.tv_confirm:
                if (confirmListener != null) {
                    confirmListener.onCanfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(Dialog dialog);
    }

    public interface IOnConfirmListener {
        void onCanfirm(Dialog dialog);
    }
}
