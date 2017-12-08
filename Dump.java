import java.util.Vector;

public class Dump{

    public static void main(String[] args) {
        Vector<Byte[]> v = new Vector<Byte[]>();
        for(int i=0;i<25;i++){
            v.add(new Byte[1024*1024]);
        }
    }
}

//-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=H:/a.dump