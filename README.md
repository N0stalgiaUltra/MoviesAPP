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

Download the <a href="apk/app-debug.apk?raw=true">APK </a> directly from this repo. You can check out <a href="https://www.google.com/search?q=how+to+install+apk+in+android">here</a> how to install an APK to your Android device.

# Tech Stack

- Minimum SDK Level 25
- <a href="https://kotlinlang.org/">Kotlin</a>

- Jetpack
  - Live Data:
  - Lifecycle
  - ViewModel
  - ViewBinding
  - Recycler View
    
- Architecture
  - MVVM
  - Clean Architecture
  - Repository pattern 

- Libraries  
  - [Glide](https://bumptech.github.io/glide/): 
  - [Retrofit & OkHTTP](https://square.github.io/retrofit/): 
  - [Koin](https://insert-koin.io/):

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
aqui entra a licença
