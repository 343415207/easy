package com.moon.mvp;

import com.trello.rxlifecycle4.LifecycleTransformer;

public interface ILifecycle {
    <T> LifecycleTransformer<T> bindLifecycle();
}
