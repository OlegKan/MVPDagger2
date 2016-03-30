/*
 * Copyright (C) 2016 Oleg Kan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.simplaapliko.mvpdagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simplaapliko.mvpdagger2.presenter.MainActivityPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    @Inject MainActivityPresenter mPresenter;

    private TextView mAppNameTextView;


    // Android lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init dagger component and inject MainActivity
        App.get().plusMainActivityComponent()
                .inject(this);

        mPresenter.setView(this);

        Button getAppNameButton = (Button) findViewById(R.id.get_app_name);
        //noinspection ConstantConditions
        getAppNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onGetAppNameButtonClick();
            }
        });

        mAppNameTextView = (TextView) findViewById(R.id.app_name);
    }

    @Override
    protected void onStop() {
        super.onStop();

        App.get().clearMainActivityComponent();
    }


    // View API

    @Override
    public String getAppName() {
        return mAppNameTextView.getText().toString();
    }

    @Override
    public void setAppName(String appName) {
        mAppNameTextView.setText(appName);
    }
}
