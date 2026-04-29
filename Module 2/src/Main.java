import com.JDRFdev.Chef;
import com.JDRFdev.Container;
import com.JDRFdev.Oven;
import com.JDRFdev.Restaurant;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Class<?>> cls=Set.of(Restaurant.class, Chef.class, Oven.class);
        Container c=new Container(cls);
        Restaurant r= c.getObject(Restaurant.class);
        r.getChef().setName("Juan");
        r.serv();
        System.out.println(r.getChef().getName());
        System.out.println(r.getName());

    }
}