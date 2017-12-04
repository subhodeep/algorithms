package problemset1;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TestRegexKeyHashMap {

  public static void main(String args[]) {

    printPyramid(5);
  }


  public static void testLinkedHashSet() {

    Set<HashChecker> hashCheckerSet = new LinkedHashSet<HashChecker>();
    HashChecker hashCheckerObjectFirst = new HashChecker("abc");
    HashChecker hashCheckerObjectSecond = new HashChecker("pop");
    hashCheckerSet.add(hashCheckerObjectFirst);
    hashCheckerSet.add(hashCheckerObjectSecond);

    for (HashChecker checker : hashCheckerSet) {
      System.out.println(checker.getHashIdentifier());
      System.out.println(checker.hashCode());
    }



  }

  public static void testWeakReferences() {

    String p = "abc";
    WeakReference<String> _stringValue = new WeakReference<String>(p);

    if (_stringValue.get() == p)
      System.out.println("Equal");

  }

  public static void testMap() {

    List<String> list1 = new ArrayList<String>();
    list1.add("itemsearch");
    // List<String> list2 = new ArrayList<String>();
    // list2.add("parceldroppost");
    RegexKeyHashMap<String, List<String>> customMap = new RegexKeyHashMap<String, List<String>>();
    customMap.put("/v1/parceldrop/itemsearch/[0-9]+", list1);
    // customMap.put("/v1/parceldrop", list2);
    List<String> list3 = customMap.get("/v1/parceldrop/itemsearch/22345");
    list3.add("itemsearch2");
    System.out.println(customMap.get("/v1/parceldrop/itemsearch/22345"));
    // System.out.println(customMap.get("/v1/parceldrop"));

  }


  public static void printPyramid(int index) {

    for (int i = 1; i <= index; i++) {

      int counter = 0;

      for (int j = 0; j < ((2 * index) - 1); j++) {

        boolean result = printAsterik(index - i, i, j);

        if (result) {
          counter++;
          if (counter <= i) {
            System.out.print(counter);
          }
        } else {
          System.out.print(" ");
        }

      }

      System.out.println("");

    }

  }

  public static boolean printAsterik(int start_index, int row_number, int element) {

    if (element >= start_index && (element - start_index) % 2 == 0) {
      return true;
    } else
      return false;
  }
}
