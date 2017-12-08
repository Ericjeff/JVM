import java.lang.ref.WeakReference;

public class WeakRef{


    private static class User{
        private int id;
        private String name ;
        private byte[] b ;
        
        public User(int id,String name){
            this.id = id;
            this.name = name;
            b = new byte[1024*1024*1];
        }

        @Override
        public String toString(){
            return "id:"+id+", name:"+name;
        }
    }

    public static void main(String[] args) {
       
        User u = new User(23,"WeakRef");
        WeakReference<User> weak = new WeakReference<User>(u);

        //去除强引用
        u = null;

        System.out.println(weak.get());
        System.gc();
        System.out.println("After GC:\n"+weak.get());
    }
}

/**
 * 在doc中编译使用 javac -encoding utf-8 
 * 运行 java -Xmx10m 
 */