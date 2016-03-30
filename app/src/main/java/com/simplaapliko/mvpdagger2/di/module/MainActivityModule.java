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

package com.simplaapliko.mvpdagger2.di.module;

import com.simplaapliko.mvpdagger2.data.DataRepository;
import com.simplaapliko.mvpdagger2.di.scope.PresenterScope;
import com.simplaapliko.mvpdagger2.presenter.MainActivityPresenter;
import com.simplaapliko.mvpdagger2.presenter.MainActivityPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    @PresenterScope
    public MainActivityPresenter provideMainActivityPresenter(DataRepository dataRepository) {
        MainActivityPresenterImpl presenter = new MainActivityPresenterImpl();
        presenter.setDataRepository(dataRepository);
        return presenter;
    }
}
