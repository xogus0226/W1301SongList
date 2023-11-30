package kr.ac.kumoh.s20180074.w1301songlist

import retrofit2.http.GET

interface SongApi {
    @GET("song")
    suspend fun getSongs(): List<Song>
}