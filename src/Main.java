import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Album album1 = new Album("album1","Alan walker");
        album1.addSong("Song 1",5.2);
        album1.addSong("Song 2",4.5);
        album1.addSong("Song 3",3.5);
        album1.addSong("Song 4",6.5);
        album1.addSong("Song 5",5.5);
        album1.addSong("Song 6",2.5);

        LinkedList<Song>myPlayList = new LinkedList<>();
        album1.addToPlayList("Song 1",myPlayList);
        album1.addToPlayList("Song 2",myPlayList);
        album1.addToPlayList("Song 3",myPlayList);
        album1.addToPlayList("Song 4",myPlayList);
        album1.addToPlayList("Song 5",myPlayList);

        printList(myPlayList);
        play(myPlayList);
    }

    public static void printList(LinkedList<Song>playList){
        ListIterator<Song>itr = playList.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        return;
    }
    public static void play(LinkedList<Song>playList){

        Scanner sc = new Scanner(System.in);

        ListIterator<Song>itr = playList.listIterator();
        if(!itr.hasNext()){
            System.out.println("playList empty");
            return;
        }
        System.out.println("you are now Listening" + itr.next());
        showMenu();

        boolean forward = true;
        while(true){
            int option = sc.nextInt();

            switch(option){
                case 0:
                    System.out.println("Thank for listening");
                    return;
                case 1:
                    showMenu();
                    break;
                case 2:
                    printList(playList);
                    break;
                case 3:
                    if(!forward){
                        if(itr.hasNext())
                            itr.next();
                    }
                    if(!itr.hasNext()){
                        System.out.println("you have reached end of playList");
                    }else{
                        System.out.println("you are listening to:"+ itr.next());
                    }
                    forward = true;
                    break;
                case 4:
                    if(forward){
                        if(itr.hasPrevious())
                            itr.previous();
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("you have reached end of playList");
                    }else{
                        System.out.println("you are listening to:"+ itr.previous());
                    }
                    forward = false;
                    break;
                case 5:
                    if(forward) {
                        System.out.println("repeating your Song:" + itr.previous());
                        forward = false;
                    }
                    else {
                        System.out.println("repeating your Song:" + itr.next());
                        forward = true;
                    }
                    break;
                case 6:
                    if(forward) {
                        System.out.println("Removed this Song:" + itr.previous());
                        itr.remove();
                    }
                    else{
                        System.out.println("Removed this Song:" + itr.next());
                        itr.remove();
                    }
              }  //1 2 3 4 5
        }
    }
    public static void showMenu(){
        System.out.println("0 : Exit");
        System.out.println("1 : print Menu");
        System.out.println("2 : show list of all songs");
        System.out.println("3 : play next song");
        System.out.println("4 : play previous song");
        System.out.println("5 : Repeat song");
        System.out.println("6 : delete song");
    }

}


// ListIterator<Song>itr = myPlayList.listIterator();
/*iterator point between gaps does not point to the node{
       node " gap iterator" node
*/
//itr.next();
//itr.hasNext();   //boolean check whether node is present in next or not
//itr.previous();
//itr.hasPrevious(); ////boolean check whether node is present in previous or not

//node1 node2 node3 "itr" node4 //s.o.p(itr.next()) it will print node4 and go to null
//node1 node2 node3 "itr" node4 //s.o.p(itr.previous()) it will print node3 and go to gap after node2









