

public class HeapAlloc{

    public static void main(String[] args) {
      System.out.println("MaxMemory:"+Runtime.getRuntime().maxMemory());
      System.out.println("free mem=:"+Runtime.getRuntime().freeMemory());  
      System.out.println("total mem=:"+Runtime.getRuntime().totalMemory());

      byte[] b = new byte[1024*1024];
      System.out.println("分配了1M空间给数组");

      System.out.println("MaxMemory:"+Runtime.getRuntime().maxMemory());
      System.out.println("free mem=:"+Runtime.getRuntime().freeMemory());  
      System.out.println("total mem=:"+Runtime.getRuntime().totalMemory());

      byte[] b1 = new byte[4*1024*1024];
      System.out.println("分配了4M空间给数组");

      System.out.println("MaxMemory:"+Runtime.getRuntime().maxMemory());
      System.out.println("free mem=:"+Runtime.getRuntime().freeMemory());  
      System.out.println("total mem=:"+Runtime.getRuntime().totalMemory());

    }
}