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

package com.simplaapliko.mvpdagger2.data;

import android.content.Context;

import com.simplaapliko.mvpdagger2.R;

public class AndroidDataRepository implements DataRepository {

    private Context mContext;

    public AndroidDataRepository(Context context) {
        mContext = context;
    }

    @Override
    public String getAppName() {
        // testing that object has access to Context
        return mContext.getString(R.string.app_name);
    }
}
