package com.geekbrains.poplibsingle.model.retrofit;

import com.geekbrains.poplibsingle.model.retrofit.date.ConfigFile;
import com.geekbrains.poplibsingle.model.retrofit.date.GsonDate;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiService {
    @GET("/api")
    Single<GsonDate> getFileList();

    @GET("/api")
    Single<ConfigFile> getFile(@Query("name") String name);

}
