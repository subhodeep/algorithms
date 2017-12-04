package problemset1;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestObjectToMap {


  public static void main(String args[]) {
    Map<String, String> result = new HashMap<String, String>();
    SampleBean sampleBean = new SampleBean();
    sampleBean.setSampleProperty1("sampleProperty1");
    sampleBean.setSampleProperty2("sampleProperty2");
    try {
      BeanInfo info = Introspector.getBeanInfo(sampleBean.getClass());
      for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
        Method reader = pd.getReadMethod();
        if (reader != null && reader.getName() != "getClass")
          result.put(pd.getName(), reader.invoke(sampleBean).toString());
      }
    } catch (IntrospectionException ex) {

    } catch (IllegalAccessException ex) {

    } catch (InvocationTargetException ex) {

    }
    System.out.println(result);
  }
}
