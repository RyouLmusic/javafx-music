package cache;

import api.GetPlaylist;
import entity.Playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/10 11:06
 */
public class PlaylistCache implements Cache {

    GetPlaylist getPlaylist;

    public final static LinkedList<Playlist> playlists = new LinkedList<>();

    public final Integer MAX_SIZE = 45 * 20;

    public PlaylistCache(){
        getPlaylist = new GetPlaylist();
    }


    /**
     * 生产（获取网络资源）
     * @param playlist
     */
    public void produce(Playlist playlist){

        synchronized (playlists){

            //如果队列是满的，则再有事件要进入则要进行阻塞
            if (playlists.size() >= MAX_SIZE){

                try {
                    print("队列已经满了...");
                    //让那些要对队列进行操作的线程进行阻塞
                    playlists.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            print(playlist + ": 新事件已经提交...");
            playlists.addFirst(playlist);
            //唤醒那些在等待队列的线程
            playlists.notify();
        }
    }

    /**
     * 消费队列里面的事件
     * @return
     */
    public Playlist consume(Integer index){

        synchronized (playlists){

            //如果队列是空的
            if (playlists.isEmpty()){

                try {
                    print("队列是空的...");
                    playlists.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Playlist playlist = playlists.get(index);
            playlists.notify();
//            print(playlist + "：事件已经被取出队列...");

            return playlist;
        }

    }

    /**
     * 将网络热门歌单product进入playlists
     */
    public void setPlaylistCache(){

        for (int i = 0;i < 20; i++){

            int finalI = i;
            new Thread(() -> {
                List<Playlist> playlists = getPlaylist.getPlaylist(finalI);
                for (int j = 0; j < 45; j++){
                    produce(playlists.get(j));
                    System.out.println("j : +++++++++" + j);
                }
            }).start();

        }

    }

    /**
     * 传入每页数目和页数获取歌单list信息
     * @param pageSize
     * @param page
     * @return
     */
    public List<Playlist> getPlaylist(Integer pageSize, int page){
        List<Playlist> playlists = new ArrayList<>();

        for (int i = 0; i < pageSize; i++){
            playlists.add(consume(pageSize*page + i));
        }
        return playlists;
    }


    public void print(String str){
        System.out.println(str);
    }

    /**
     * 测试用
     * @return
     */
    public LinkedList<Playlist> get(){
        return playlists;
    }

    public static void main(String[] args) {
/*
        PlaylistCache playlistCache = new PlaylistCache();

        //开启生产线程
        new Thread(() -> {
            //循环产生新事件
            while (true){

                playlistCache.produce(new Playlist());
            }
        }, "Producer").start();

        //开启消费线程
        new Thread(() -> {
            int i = 0;
            while (true){

                playlistCache.consume(i++);


                try {
                    //为了看出效果，进行睡眠
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Consumer").start();
    }*/


        PlaylistCache playlistCache1 = new PlaylistCache();
        PlaylistCache playlistCache2 = new PlaylistCache();

//        System.out.println(playlistCache1.get() == playlistCache2.get());

        playlistCache1.setPlaylistCache();

    }
}
