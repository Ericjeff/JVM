import java.lang.ref.SoftReference;

public class SoftRef{

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
        User u = new User(1,"SoftRef");
        //创建软引用
        SoftReference<User> soft = new SoftReference<User>(u);
        //去除强引用
        u = null;

        //查看是否会被回收
        System.out.println(soft.get());
        System.gc();
        System.out.println("After GC:\n"+soft.get());

        byte[] b = new byte[1024*925*7];
        System.gc();
        System.out.println("After GC:\n"+soft.get());
    }
}

/**
 * 在doc中编译使用 javac -encoding utf-8 
 * 运行 java -Xmx10m 
 */

