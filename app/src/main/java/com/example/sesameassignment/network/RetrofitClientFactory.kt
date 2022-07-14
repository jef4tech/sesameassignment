package com.example.sesameassignment.network


import okhttp3.Cache
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import androidx.viewbinding.BuildConfig
import com.example.sesameassignment.BaseApplication
import com.example.sesameassignment.utils.Extensions.hasNetwork
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientFactory {
    const val MainServer = "http://111.92.110.221:8018/"


    private val retrofitClient: Retrofit.Builder by lazy {
        val cacheSize = 50 * 1024
        val myCache = Cache(File(BaseApplication.ctx?.cacheDir, "responses"), cacheSize.toLong())
        val levelType: HttpLoggingInterceptor.Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = HttpLoggingInterceptor.Level.BODY else levelType = HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder().cache(myCache)
        okhttpClient.addInterceptor { chain ->

            var request = chain.request()

            request = if (BaseApplication.ctx?.let { hasNetwork(it) }!!)
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7) .build()

            chain.proceed(request)
        }


        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val restApis: RestApis by lazy {
        retrofitClient
            .build()
            .create(RestApis::class.java)
    }
}