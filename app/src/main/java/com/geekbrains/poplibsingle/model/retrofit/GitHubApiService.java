package com.geekbrains.poplibsingle.model.retrofit;

import com.geekbrains.poplibsingle.model.GsonDate;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GitHubApiService {
    @GET("/users/{user}")
    Single<GsonDate> getAvatarUrl(@Path("user") String user);
}
