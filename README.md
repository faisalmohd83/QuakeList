# QuakeList

[![Build Status](https://dev.azure.com/faisalmohammed0097/faisalmohammed/_apis/build/status/faisalmohd83.QuakeList?branchName=master)](https://dev.azure.com/faisalmohammed0097/faisalmohammed/_build/latest?definitionId=1&branchName=master)

## Welcome to the EarthquakeList App wiki!

### Prerequisites
* AndroidStudio 3.0 or later
* Java JDK 1.8
* Kotlin 1.3.21
* Android SDK minimum API level 22

### Libraries used

* RetroFit - Retrofit is a REST Client library (Helper Library), Type-safe HTTP client for Android and Java by Square, Inc., used in Android and Koltin to create an HTTP request and also to process the HTTP response from a REST API.

* RxAndroid - Reactive Extensions for Android for Async programming.

* Gson - Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.

### Android components

- RecyclerView - Used to list the Albums.
- Constraintlayout - Simple, flat hierarchies in a layout.
- Synthetic Binding(Kotlin) - bind the data with UI, wonder not if **findViewById()** missing in any UI.

### [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/)([Android Jetpack](https://developer.android.com/jetpack/))
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - allows data to survive configuration changes such as screen rotations.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)   - lifecycle-aware data holder class to respects the lifecycle Fragments.
- [AndroidX](https://developer.android.com/jetpack/androidx/) - Complete project implemented using AndroidX libraries.
- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - Navigation made simple, not relevant in currnet context. But will be useful whilst further enhancements.
- [Paging](https://developer.android.com/topic/libraries/architecture/paging/) - helps to load the result with controlled flow and manages the up/downward scrolling with pagination.

### Workflow of the application
The app name is **QuakeList**. 
Once installed it can be found in the phone with a black **tremor** icon.

### Implementation

1. The App is designed to list the of earthquakes from the [USGS](https://earthquake.usgs.gov/fdsnws/event/1/) by calling intended API endpoint with filters(offset and limit). The UI implemented as LinearLayout(RecycleView) to showcase the result list.
2. The network call is performed using Retrofit2 in conjunction with RxAndroid expects to convert the results to be mapped onto Kotlin data classes using Gson converter. RxJava helps to retrieve the result asynchronously and handover the result to Gson for further processing.
3. Android's pagination library enables smoother scrolling up and downwards using PagedList, maintains the cache of pre-fetched items and scrolled up data.
4. ViewModel in combination with LiveData helps the data to survive view lifecycle changes. Moreover, maintains an abstraction between the View and ViewModel.

### Design
- The application is based on MVVM pattern. 
In MVVM architecture, Views react to changes in the ViewModel without being called explicitly.
- The API requests are made using retrofit.
- The Gson is used conjunction retrofit to parser results onto Kotlin data classes.
- The ViewModel interacts with a data repository(Using Retrofit) to get the data and updates the View.
- The data source manages the data to be fetched from the network on UI scrolls using paging library.
- The ViewModel delegates all the requests from the view to the repository and vice versa.
- The RecylerView is used instead of normal listview.

### Further enhancements
- No data/ limited network scenario to handled with progress bar.
- Improving async by replacing the Rxjava with [Kotin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) in conjunction with [Koin](https://insert-koin.io/) for better performance.
- Introducing unit and instrument test
- furthermore, the refactoring is an endless thought.
