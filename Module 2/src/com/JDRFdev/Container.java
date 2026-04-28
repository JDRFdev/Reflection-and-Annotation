package com.JDRFdev;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Container {
    private Map<Class<?>,Object> map=new HashMap<>();
    private Properties props= new Properties();
    public Container(Set<Class<?>> cls) {
        try {
            props.load(new FileInputStream("src/application.properties"));
            for (Class<?>c:cls){
            if (c.isAnnotationPresent(Component_.class)){
                Object obj=inyect(c);
                map.put(c,obj);
            }
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                }else if (field.isAnnotationPresent(Value.class)){
                    String key=field.getAnnotation(Value.class).value();
                    field.setAccessible(true);
                    field.set(obj,props.getProperty(key));
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
    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> c){

        return (T)map.get(c);
    }

}
