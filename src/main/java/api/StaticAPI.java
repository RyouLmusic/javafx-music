package api;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 8:51
 */
public class StaticAPI {

    /**
     * 歌单里面的内容的api
     * id=141998244
     */
    public static final String SONG_LIST_API = "https://api.itooi.cn/netease/songList?id=";

    /**
     * 说明 : 调用此接口 , 可获取网友精选碟歌单
     *
     * 可选参数 : order: 可选值为 'new' 和 'hot', 分别对应最新和最热 , 默认为 'hot'
     *
     * cat:cat: tag, 比如 " 华语 "、" 古风 " 、" 欧美 "、" 流行 ", 默认为 "全部",可从歌单分类接口获取(/playlist/catlist)
     *
     * limit: 取出歌单数量 , 默认为 50
     *
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*50, 其中 50 为 limit 的值
     *
     * 接口地址 : /top/playlist
     *
     * 调用例子 : /top/playlist?limit=10&order=new
     */
    public static final String PLAYLIST_API = "http://localhost:3000/top/playlist?order=hot&limit=";

    /**
     * 说明 : 调用此接口 , 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情(注意:歌曲封面现在需要通过专辑内容接口获取)
     *
     * 必选参数 : ids: 音乐 id, 如 ids=347230
     *
     * 接口地址 : /song/detail
     *
     * 调用例子 : /song/detail?ids=347230,/song/detail?ids=347230,347231
     */
    public static final String SONG_LIST_DETAIL = "http://localhost:3000/playlist/detail?id=";
    /**
     * 说明 : 调用此接口,传入歌单 id 可获取相关歌单(对应页面 https://music.163.com/#/playlist?id=1)
     */
    public static final String SONG_LIST_RELATED = "http://localhost:3000/related/playlist?id=";

    /**
     * 获取歌曲详情
     * 说明 : 调用此接口 , 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情(注意:歌曲封面现在需要通过专辑内容接口获取)
     *
     * 必选参数 : ids: 音乐 id, 如 ids=347230
     *
     * 接口地址 : /song/detail
     */
    public static final String SONG_DETAIL_API = "http://localhost:3000/song/detail?ids=";


    /**
     *
     * @param limit
     * @param offset
     * @return
     */
    public final static String GET_PLAYLIST_API(Integer limit, Integer offset){
        return PLAYLIST_API+limit+"&offset="+offset;
    }

}
