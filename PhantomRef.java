import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomRef{

    public static PhantomRef phantom;
    static ReferenceQueue<PhantomRef> queue;

    public static class CheckRefQueue extends Thread{
        @Override
        public void run(){
            while(true){
                if(queue!=null){
                    PhantomReference<PhantomRef> ref =null;
                    try{

                        ref = (PhantomReference<PhantomRef>)queue.remove();  
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    if(ref!=null){
                        System.out.println("对象删除 is delete");
                    }
                }
            }
        }
    }

    @Override
    public void finalize(){
        System.out.println("对象复活");
        phantom = this;
    }
    public static void main(String[] args) {
        
        CheckRefQueue check  =new CheckRefQueue();
        check.setDaemon(true);
        check.start();

        phantom = new PhantomRef();
        queue = new ReferenceQueue<PhantomRef>();
        //生成虚引用
        PhantomReference<PhantomRef> p = new PhantomReference<PhantomRef>(phantom, queue);

        //去除强引用
        phantom = null;
        System.gc();
        System.out.println("第一次GC");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }

        if(phantom!=null){
            System.out.println("对象可以使用");
        }else{
            System.out.println("对象不可以使用");
        }

        phantom = null;
        System.out.println("第二次GC");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(phantom!=null){
            System.out.println("对象可以使用");
        }else{
            System.out.println("对象不可以使用");
        }
    }
}