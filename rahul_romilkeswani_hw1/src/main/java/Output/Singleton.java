package Output;
public class Singleton{
    private static Singleton INSTANCE = null;
    public static Singleton getInstance(){
        if(INSTANCE==null)
            INSTANCE = new Singleton ();
        return INSTANCE;
    }
}
