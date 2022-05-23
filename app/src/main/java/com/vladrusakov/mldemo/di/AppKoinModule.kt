package com.vladrusakov.mldemo.di

import android.content.Context
import android.net.ConnectivityManager
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.vladrusakov.common.datastore.AppDataStore
import com.vladrusakov.common.datastore.PreferencesDataStore
import com.vladrusakov.common.interceptors.NetworkConnectionInterceptor
import com.vladrusakov.mldemo.BuildConfig
import com.vladrusakov.mldemo.data.ItemsSearchRepositoryImpl
import com.vladrusakov.mldemo.data.local.ItemsSearchLocalSource
import com.vladrusakov.mldemo.data.local.ItemsSearchLocalSourceImpl
import com.vladrusakov.mldemo.data.net.RetrofitSearchService
import com.vladrusakov.mldemo.data.remote.ItemsSearchRemoteSource
import com.vladrusakov.mldemo.data.remote.ItemsSearchRemoteSourceImpl
import com.vladrusakov.mldemo.domain.GetLastSearchProductUseCase
import com.vladrusakov.mldemo.domain.ItemsSearchUseCase
import com.vladrusakov.mldemo.domain.repository.ItemsSearchRepository
import com.vladrusakov.mldemo.presentation.itemdetail.ItemDetailViewModel
import com.vladrusakov.mldemo.presentation.itemslist.ItemsListViewModel
import com.vladrusakov.mldemo.presentation.itemssearch.ItemsSearchViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}

val networkModule = module {
    factory { provideOkHttpClient(androidContext()) }
    factory { provideRetrofit(get()) }
    single { provideSearchApi(get()) }
}

val dataModule = module {
    single<PreferencesDataStore> {
        AppDataStore(androidContext())
    }

    factory<ItemsSearchRemoteSource> { ItemsSearchRemoteSourceImpl(get()) }
    factory<ItemsSearchLocalSource> { ItemsSearchLocalSourceImpl(get()) }
    factory<ItemsSearchRepository> { ItemsSearchRepositoryImpl(get(), get()) }
}

val viewModelModule = module {
    viewModel { ItemsSearchViewModel(get()) }
    viewModel { ItemsListViewModel(get()) }
    viewModel { ItemDetailViewModel() }
}

val domainModule = module {
    factory { ItemsSearchUseCase(get()) }
    factory { GetLastSearchProductUseCase(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

fun provideOkHttpClient(context: Context): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    val connection = NetworkConnectionInterceptor(context)
    if (BuildConfig.DEBUG) {
        logging.level = HttpLoggingInterceptor.Level.BODY
    } else {
        logging.level = HttpLoggingInterceptor.Level.NONE
    }
    return OkHttpClient.Builder().apply {
        addInterceptor(logging)
        addInterceptor(connection)
    }.build()
}

fun provideSearchApi(retrofit: Retrofit): RetrofitSearchService =
    retrofit.create(RetrofitSearchService::class.java)
