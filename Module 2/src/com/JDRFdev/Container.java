package com.JDRFdev;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Container {
    private Map<Class<?>,Object> map=new HashMap<>();

    public Container(Set<Class<?>> cls) {
        for (Class<?>c:cls){
            if (c.isAnnotationPresent(Component_.class)){
                Object obj=inyect(c);
                map.put(c,obj);
            }
        }
    }

    public Object inyect(Class<?> c) {
        Object obj;
        try {
            obj = c.getDeclaredConstructor().newInstance();
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inyect.class)) {
                    Object ob = getObject(field.getType());
                    if(ob==null){
                        ob=inyect(field.getType());
                    }
                    field.setAccessible(true);
                    field.set(obj, ob);
                }
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public Object getObject(Class<?> c){

        return map.get(c);
    }

}
