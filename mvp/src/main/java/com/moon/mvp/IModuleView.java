package com.moon.mvp;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public interface IModuleView {

    /**
     * 没有布局
     */
    int INVALID_LAYOUT = -1;

    View initModule(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    @LayoutRes
    int getHeadLayoutId();


    @LayoutRes
    int getNetErrorLayoutId();

    @LayoutRes
    int getContentLayoutId();

    int getEmptyLayoutId();

    int getNotLimitId();

    void showContextView();

    void showEmptyView();

    void showNetFailView();

    void showNotLimitView();
}
