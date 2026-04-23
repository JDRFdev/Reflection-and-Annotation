import com.mini.test.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
         try {
             Class<?> c1 = Person.class;
             Person p1=new Person();
             Class<?> c2=p1.getClass();
            Class<?> c3=Class.forName("com.mini.test.Person");
             System.out.println(c1);
             System.out.println(c2);
             System.out.println(c3);
             Field[] fields = c1.getDeclaredFields();
             Method[] methods=c1.getMethods();
             for (Field field : fields) {
                 System.out.println(field.getName() + " - " + field.getType());
             }
             for (Method method:methods){
                 System.out.println(method.getName());
             }
             Field field=Person.class.getDeclaredField("name");
             field.setAccessible(true);
             field.set(p1,"Juan");
             System.out.println(field.get(p1));
             System.out.println(p1.getName()    );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
             throw new RuntimeException(e);
         } catch (IllegalAccessException e) {
             throw new RuntimeException(e);
         }
    }
}