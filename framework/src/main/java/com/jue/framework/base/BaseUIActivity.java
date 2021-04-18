package com.jue.framework.base;

import android.os.Bundle;

import com.jue.framework.utils.SystemUI;

/**
 * FileName: BaseUIActivity
 * Founder: Jue
 * Profile: UI 基类
 */
public class BaseUIActivity extends BaseActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemUI.fixSystemUI(this);
    }
}
