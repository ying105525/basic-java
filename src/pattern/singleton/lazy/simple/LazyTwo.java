package pattern.singleton.lazy.simple;

/**
 * Created by Tom on 2018/3/7.
 */
public class LazyTwo {

    private LazyTwo(){}

    private static LazyTwo lazy = null;

    public static synchronized LazyTwo getInstance(){

        if(lazy == null){
            lazy = new LazyTwo();
        }
        return lazy;

    }

}
