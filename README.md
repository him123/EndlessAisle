# Endless Aisle Android Native app as interview assignment for Vinculum Group.

### Key Points
~Step 1: App is containing dummy data. But the whole app is dynamically works. As inside the repositories package you can add as many as data and it will be redirected to the app.

~Setp 2: For this Android App I have followed MVVM(Model View ViewModel) architecture as code design pattern.

~Step 3: From Dashboard to payment screen the whole cycle of flow is maintained in the app.

~Step 4: Becuase I have used LiveData and RXjava/RxAdnroid advanced concept to build this app, the android os version 6.0 or/and above would be compatible for this app.

## Code Information

~App is mainly divided by 6 packages 

adapters|model|repositories|utils|view|viewmodels|
|---|---|---|---|---|---|


## Dependencies used

// RxJava
`implementation 'io.reactivex.rxjava2:rxjava:2.1.9'`
`implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'`

// Lifecycle components
`def archLifecycleVersion = '1.1.1'`
`implementation "android.arch.lifecycle:extensions:$archLifecycleVersion"`
`annotationProcessor "android.arch.lifecycle:compiler:$archLifecycleVersion"`

// Glide
`def glideVersion = '4.8.0'`
`implementation "com.github.bumptech.glide:glide:$glideVersion"`
`annotationProcessor "com.github.bumptech.glide:compiler:$glideVersion"`

// Butterknife
`implementation 'com.jakewharton:butterknife:10.0.0'`
`annotationProcessor 'com.jakewharton:butterknife-compiler:10.0.0'`

// Retrofit and OkHttp
// OkHttp interceptors for logging
`implementation "com.squareup.retrofit2:retrofit:2.0.0"`
`implementation "com.squareup.retrofit2:converter-gson:2.0.0"`
`implementation "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0"`
`implementation "com.squareup.okhttp3:okhttp:3.0.1"`
`implementation "com.squareup.okhttp3:okhttp-urlconnection:3.0.1"`
`implementation "com.squareup.okhttp3:logging-interceptor:3.4.1"`

//circle imageview
`implementation 'de.hdodenhof:circleimageview:2.2.0'`
`implementation 'com.intuit.sdp:sdp-android:1.0.6'`
    
    
