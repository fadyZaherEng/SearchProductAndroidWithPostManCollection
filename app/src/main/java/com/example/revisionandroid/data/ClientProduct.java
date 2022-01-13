package com.example.revisionandroid.data;

import com.example.revisionandroid.pogo.Response;
import com.example.revisionandroid.ui.postData;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientProduct
{
   public static ClientProduct clientProduct;
   private  static final String BASE_URL = "https://student.valuxapps.com/api/";
   final ApiInterface apiInterface;
   public  ClientProduct() {
      Retrofit retrofit=new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .build();
      apiInterface=retrofit.create(ApiInterface.class);
  }
  public static ClientProduct getInstance(){
      if(clientProduct==null)
      {
          clientProduct=new ClientProduct();
      }
      return clientProduct;
  }
  public Single<Response> search(postData data)
  {
      return apiInterface.getProduct(data);
  }
}
