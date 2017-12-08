
import java.nio.ByteBuffer;
public class AccessDirectBuffer{

    /**
     * 读写直接内存和堆的速度
     */
    public void directAccess(){
        long s = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocateDirect(500);

        for(int i=0;i<1000000;i++){
            for(int j=0;j<99;j++)
                b.putInt(j);
            //反转缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。
            //如果已定义了标记，则丢弃该标记。 常与compact方法一起使用。通常情况下，在准备从缓冲区中读取数据时调用flip方法
            b.flip();
            for(int j=0;j<99;j++)
                b.getInt(j);
            //clear方法将缓冲区清空，一般是在重新写缓冲区时调用
            b.clear();
        }

        long e = System.currentTimeMillis();
        System.out.println("DirectTime:"+(e-s));
    }

    public void access(){
        long s = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocate(500);

        for(int i=0;i<1000000;i++){
            for(int j=0;j<99;j++)
                b.putInt(j);
            //反转缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。
            //如果已定义了标记，则丢弃该标记。 常与compact方法一起使用。通常情况下，在准备从缓冲区中读取数据时调用flip方法
            b.flip();
            for(int j=0;j<99;j++)
                b.getInt(j);
            //clear方法将缓冲区清空，一般是在重新写缓冲区时调用
            b.clear();
        }

        long e = System.currentTimeMillis();
        System.out.println("time:"+(e-s));
    }


    /**
     * 查看直接内存和堆申请空间的速度
     */
    
    public void directAllocation(){
        long s = System.currentTimeMillis();
        ByteBuffer b;
        for(int i=0;i<2000000;i++)
             b = ByteBuffer.allocateDirect(500);

        long e = System.currentTimeMillis();
        System.out.println("DirectTime:"+(e-s));
    }


    public void allocation(){
        long s = System.currentTimeMillis();
        ByteBuffer b;
        for(int i=0;i<2000000;i++)
             b = ByteBuffer.allocateDirect(500);

        long e = System.currentTimeMillis();
        System.out.println("Time:"+(e-s));
    }

    public static void main(String[] args) {
        AccessDirectBuffer adb = new AccessDirectBuffer();
        
        //读写
        System.out.println("读写");
        adb.directAccess();
        adb.access();

        adb.directAccess();
        adb.access();

        //申请内存
        System.out.println("申请内存");
        adb.directAllocation();
        adb.allocation();

        adb.directAllocation();
        adb.allocation();
    }

}

/**
 * 编译的时候如果报编码错误，使用javac -encoding utf-8 
 * 运行时使用：java -client 和java -server 查看它们的区别
 */