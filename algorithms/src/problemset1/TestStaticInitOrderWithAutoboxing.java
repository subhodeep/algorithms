package problemset1;

public class TestStaticInitOrderWithAutoboxing {

  static {
    System.out.println(getYesOrNo() ? "yes" : "no");
  }

  static final public Boolean YES_OR_NO = Boolean.TRUE;

  static boolean getYesOrNo() {
    return YES_OR_NO;
  };

  public static void main(String[] args) {}


}
