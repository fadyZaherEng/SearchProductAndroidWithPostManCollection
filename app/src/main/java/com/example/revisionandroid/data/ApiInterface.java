package com.example.revisionandroid.data;
import com.example.revisionandroid.pogo.Response;
import com.example.revisionandroid.ui.postData;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface
{
    @Headers({"Authorization:JDau1f7ZHPIj6L2f8omnljS47HUelF6QpkIRfiHyc6RJzsetUA6yuub5rOJX4gpKs9F3O9","Content-Type:application/json","lang:en"})
    @POST("products/search")
    Single<Response> getProduct(@Body postData data);
}
