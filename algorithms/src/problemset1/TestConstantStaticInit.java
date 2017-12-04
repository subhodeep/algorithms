package problemset1;

import java.lang.reflect.InvocationTargetException;

class ChildConstantStaticBlock {

  public static int a = 9;
  public static final String str = "String";


  static {

    System.out.println("In ChildConstantStaticBlock static block");
  }

}


public class TestConstantStaticInit {

  public static final int a = 9;

  static {

    System.out.println("In TestConstantStaticInit static block");
  }

  public static void main(String args[]) {

    // System.out.println(ChildConstantStaticBlock.class);
    System.out.println(ChildConstantStaticBlock.str);

    System.out.println(a);
    java.lang.reflect.Method m;
    try {
      m = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[] {String.class});
      m.setAccessible(true);
      ClassLoader cl = ClassLoader.getSystemClassLoader();
      Object checkLoading = m.invoke(cl, "collection.algorithms.StaticBlock");
      System.out.println(checkLoading != null);
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
        | InvocationTargetException e) {
      e.printStackTrace();
    }

  }



}
