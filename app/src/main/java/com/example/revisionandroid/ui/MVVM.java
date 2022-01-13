package com.example.revisionandroid.ui;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.revisionandroid.data.ClientProduct;
import com.example.revisionandroid.pogo.DataItem;
import com.example.revisionandroid.pogo.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MVVM extends ViewModel
{
    MutableLiveData<List<DataItem> > mutableLiveData=new MutableLiveData<>();
    void getData(){
        postData data=new postData("apple");
        Single<com.example.revisionandroid.pogo.Response> single=ClientProduct.getInstance()
                .search(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<Response> observer=new SingleObserver<Response>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Response response) {
                 mutableLiveData.setValue(response.getData().getData());
            }

            @Override
            public void onError(@NonNull Throwable e) {
               Log.v("eeeeeeeeeeeeeeeee",e.getMessage().toString());
            }
        };
        single.subscribe(observer);
    }
}
