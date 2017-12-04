package problemset1;

import java.util.HashMap;
import java.util.Iterator;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.regexp.internal.RESyntaxException;

@SuppressWarnings("serial")
public class RegexKeyHashMap<T, E> extends HashMap<T, E> {

  public E put(T key, E value) {
    if (key instanceof String)
      return super.put((T) key, (E) value);
    else
      throw new RuntimeException("RegexKeyHashMap only accepts Strings as keys.");
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public E get(Object key) {

    Iterator regexps = keySet().iterator();
    String keyString;
    Object result = null;
    String stringToMatch = cleanKey(key);
    String[] stringToMatchArray = stringToMatch.split("/");

    while (regexps.hasNext()) {
      keyString = regexps.next().toString();
      String[] keyStringArray = keyString.split("/");
      try {
        RE regexp = new RE(keyString);
        if (regexp.match(stringToMatch) && stringToMatchArray.length == keyStringArray.length) {
          result = super.get(keyString);
          break;
        }
      } catch (RESyntaxException e) {

      }
    }
    return (E) result;
  }

  private String cleanKey(Object obj) {
    String retVal = obj.toString();
    return (retVal.charAt(0) == '^') ? retVal.substring(1) : retVal;
  }

}
