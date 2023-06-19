package com.example.simplecalc

import retrofit2.Retrofit

object  ApiClient {

    private var API_BASE_URL = BuildConfig.BASE_URL
//    private var API_BASE_URL = BuildConfig.VERSION_NAME


    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
//            .addConverterFactory(
//                GsonConverterFactory.create(
//                    GsonBuilder()
//                        .setLenient()
//                        .create()
//                )
//            )
//            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
//            .client(signedClient())
            .build()
    }

//    val tmsRetrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(TMS_BASE_URL)
//            .addConverterFactory(
//                GsonConverterFactory.create(
//                    GsonBuilder()
//                        .setLenient()
//                        .create()
//                )
//            )
//            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
//            .client(signedClient())
//            .build()
//    }

//    val paystackRetrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(API_BASE_URL_PAYSTACK)
//            .addConverterFactory(
//                GsonConverterFactory.create(
//                    GsonBuilder()
//                        .setLenient()
//                        .create()
//                )
//            )
//            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
//            .build()
//    }


//    private fun signedClient(): OkHttpClient {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        return OkHttpClient.Builder()
//            .connectTimeout(90, TimeUnit.SECONDS)
//            .readTimeout(90, TimeUnit.SECONDS)
//            .writeTimeout(90, TimeUnit.SECONDS)
//            .addInterceptor { chain ->
//                try {
//                    val newRequest = chain.request().newBuilder()
//                        .addHeader("Authorization", "Bearer $token")
//                        .addHeader("business", businessId)
//                        .build()
//
//                    when {
//                        isStoreSetUp && !AppPref.isOnline -> {
//                            throw NetworkErrorException("Unable to connect, check your network. Ensure that OFFLINE MODE is not enabled in app")
//                        }
//                        else -> {
//                            val response = chain.proceed(newRequest)
//
//                            if (response.isSuccessful) {
//                                response
//                            } else {
//                                val charStream = response.body?.charStream()
//                                println("response.code ${response.code}")
//                                val errorMessage = charStream?.readText() ?: ""
//                                val parser = JsonParser()
//                                val jsonElement = parser.parse(errorMessage)
//                                val rootObject = jsonElement.asJsonObject
//                                val message = rootObject[KEY_MESSAGE].asString
//                                Timber.e(" $KEY_MESSAGE  $message")
//                                throw RuntimeException(message)
//                            }
//                        }
//                    }
//                }catch (e: Throwable){
//                    e.printStackTrace()
//                    if(e.message?.contains(Constants.UNABLE_TO_RESOLVE_HOST) == true) {
//                        throw NetworkErrorException("Network error,please check your internet connection")
//                    }else throw RuntimeException(e.message)                }
//            }
//            .addInterceptor(interceptor)
//            .build()
//    }

    fun <T> Class<T>.createApi( ):T{
       return retrofit.create(this)
    }

//    fun <T> Class<T>.createPayStackApi( ):T{
//        return paystackRetrofit.create(this)
//    }

}