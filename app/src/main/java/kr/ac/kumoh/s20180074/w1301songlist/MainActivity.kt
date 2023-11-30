package kr.ac.kumoh.s20180074.w1301songlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20180074.w1301songlist.ui.theme.W1301SongListTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SongViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel)
        }
    }
}
@Composable
fun MainScreen(viewmodel: SongViewModel){
    // by는 위임자
    val songList by viewmodel.songList.observeAsState(emptyList())

    W1301SongListTheme {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            SongList(songList)
        }
    }
}
@Composable
fun SongList(list: List<Song>){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ){
        items(list){
            song -> SongItem(song)
        }
    }

}

@Composable
fun SongItem(song: Song) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffffffcc))
            .padding(16.dp)
    ){
        TextTitle(song.title)
        TextSinger(song.singer)
    }
}

@Composable
fun TextSinger(singer: String) {
    Text(singer, fontSize = 30.sp)
}

@Composable
fun TextTitle(title: String) {
    Text(title, fontSize = 30.sp)
}
