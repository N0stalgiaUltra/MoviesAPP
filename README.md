<h1 align="center">Movies App</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api"> <img alt="API" src="https://img.shields.io/badge/API-25%2B-brightgreen.svg?style=flat"/></a>

  <br>
  <a href="https://wa.me/+5521990399627"><img alt="WhatsApp" src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white"/></a>
  <a href="https://www.linkedin.com/in/vinicius-santos-b217b5168/"><img alt="Linkedin" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/></a>
  <a href="mailto:viniciusantos0898@gmail.com"><img alt="Gmail" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white"/></a>
</p>

<p align="center">  

⭐ This project was created to display my tech knowledge in native Android development with Kotlin. More techincal info below.

Movies App is a native Android App made with Kotlin. The app is capable of getting information from a RESTful API, using Retrofit; displaying the data (LiveData) in cards, inside a Recycler View; displaying movies posters with Glide and utilizing Clean Architecture and SOLID patterns to make the code clean, reusable and decoupled.
</p>

</br>

<p float="left" align="center">
<img alt="screenshot" width="30%" src="screenshots/moviesApp_1.png"/>
<img alt="screenshot" width="30%" src="screenshots/moviesApp_2.png"/>
</p>

## Download

Download the <a href="https://github.com/N0stalgiaUltra/MoviesAPP/tree/main/apk">APK </a> directly from this repo. You can check out <a href="https://www.google.com/search?q=how+to+install+apk+in+android">here</a> how to install an APK to your Android device.

## Tech Stack

- Minimum SDK Level 25
- <a href="https://kotlinlang.org/">Kotlin</a>

- Jetpack
  - Live Data: Used for observe data from a reactive point of view. Allowing the data used in UI to be updated automatically.
  - Lifecycle: Observe the Android lifecycle and manipulate the states from the UI after the lifecycle change.
  - ViewModel: Used to retrieve the data from the Model layer and update the data from View.
  - ViewBinding: Manages the XML layout views in Kotlin through a class.
  - Recycler View: Show a more efficient way of displaying a list of Views in the screen, recycling the views for better performance.
    
- Architecture
  - MVVM (Model-View-ViewModel) + Clean Architecture: The first item is used to separate the logic of the app's UI, helping with testability and organization; also, the Clean Architecture helps to build the app's main system with well designed layers, who work with independency, facilitating with the scalability and maintenance.
  - Repository pattern: This pattern help with the data layer´s abstraction

- Libraries  
  - [Glide](https://bumptech.github.io/glide/): Used for image loading and caching.
  - [Retrofit & OkHTTP](https://square.github.io/retrofit/): Used to make the communication with a RESTful API
  - [Koin](https://insert-koin.io/): Used for Dependency Injection

## Third Party APIs

[The Movies Database](https://www.themoviedb.org/?language=pt), this API provides all kind of data related to movies and series and it's completely free.

## Features

### Popular movies listing
<img src="screenshots/gif1_moviesApp.gif" width="25%"/>
Layout created with CardView and Linear Layout. The app consumes the Movies API with Retrofit and OkHttp, and mapping the response into a movie object displayed by the Recycler View

### Movie detail screen
<img src="screenshots/gif2_moviesApp.gif" width="25%"/>
Screen created to display the details about a movie card. This screen contains an abstract and others info about the movie selected. Those infos are passed by de Main Activity via Intent.


# License
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

Google Play e o logótipo do Google Play são marcas comerciais da Google LLC.
