//const playBtn = document.querySelector('');
//const prevBtn = document.querySelector('');
//const nextBtn = document.querySelector('');
//
//let audio = document.querySelector('');
//let songTitle = document.querySelector('');
//let songAuthor = document.querySelector('');

let playlist = [];
let n_songs = 0;
let audio_index = 0;

function addSongToPlaylist(songID, songName, songAuthor) {
    let song = {
        filePath: `songs/song${songID}.mp3`,
        name: `${songName}`,
        author: `${songAuthor}`
    };
    playlist.push(song);
    n_songs += 1;
}

function createNewPlaylist(songID, songName, songAuthor) {
    let song = {
        filePath: `songs/song${songID}.mp3`,
        name: `${songName}`,
        author: `${songAuthor}`
    };
    playlist = [];
    playlist.push(song);
    audio_index = 0;
    n_songs = 1;
    loadSong();
}

function loadSong() {
    document.getElementById("audio-player").pause();
    let cur_song_file = playlist[audio_index].filePath;
    document.getElementById("audio-player").setAttribute('src', cur_song_file);
    document.getElementById("audio-player").load();
    document.getElementById("audio-player").play();
    document.getElementById("songName").innerText = `${playlist[audio_index].name}`;
    document.getElementById("songAuthor").innerText = `${playlist[audio_index].author}`;

}

function playNext() {
    if (n_songs > 1) {
        if (audio_index + 1 === n_songs) {
            audio_index = 0;
        } else {
            audio_index += 1;
        }
    }
    loadSong();
}

function playPrevious() {
    if (n_songs > 1) {
        if (audio_index === 0) {
            audio_index = n_songs - 1;
        } else {
            audio_index -= 1;
        }
    }
    loadSong();
}
