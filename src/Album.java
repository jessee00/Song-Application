
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song>songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean findSong(String title)
    {
        for(Song checkSong : this.songs)       //can also write songs
        {
            if(checkSong.getTitle().equals(title)){
                System.out.println("Song Found !!");
                return true;
            }
        }
        return false;
    }
        //add song in ArrayList songs
    public boolean addSong(String title,double duration){
        if(findSong(title) == true){
            System.out.println("song already present");
            return false;
        }
        //add
        Song newSong = new Song(title,duration); //this.songs.add(new Song(title,duration));
        this.songs.add(newSong);
        return true;
    }
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for (Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        return false;
    }

    //which no of song want to add to playList from album
    public boolean addToPlayList(int trackNumber,LinkedList<Song>playList){
        int index = trackNumber-1;
        if(index>=0 && index<=this.songs.size()-1){
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }
}
