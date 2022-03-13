package com.abc.hey.reflect;

import java.lang.reflect.Method;

/**
 * @description: 反射练习
 * @create: 2020-11-29-16:08
 * @author: Hey
 */

    /*
        Class对象功能:
            *获取功能:
            1.获取成员变量们
                * Field[] getFields() :获取所有public修饰的成员变量
                * Field getField(String name) :获取指定name的public修饰的成员变量

                * Field[] getDeclaredFields() : 获取所有的成员变量,不受限于修饰符
                * Field getDeclaredField(String name) : 获取指定name的成员变量,不受限于修饰符
            2. 获取构造方法们
                * Constructor<?>[] getConstructors()
                * Constructor<T> getConstructor(类<?>...parameterTypes)

                * Constructor<?>[] getDeclaredConstructors()
                * Constructor<T> getDeclaredConstructor(类<?>...parameterTypes)
            3. 获取成员方法们
                * Method[] getMethods()
                * Method getMethod(String name,类<?>...parameterTypes)

                * Method[] getDeclaredMethods()
                * Method getDeclaredMethod(String name,类<?>...parameterTypes)
            4. 获取类名
                * String getName()

        * Field:成员变量
            * 操作:
                1.设置值: void set(Object obj, Object value)
                2.获取值: Object get(Object obj)
                3.忽略访问权限修饰符的安全检查: setAccessible(true) 暴力反射
        * Constructor:构造方法
            * 操作:
                1.创建对象: T newInstance(Object... initargs)
                2.如果使用空参数构造方法创建对象,操作可以简化:Class对象的newInstance方法
        * Method:成员方法
            *操作:
                执行方法:Object invoke(Object obj, Object... args)
                获取方法名称:String getName()


     */
public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        Method method = personClass.getMethod("eat",String.class);
        Person p = new Person();
        method.invoke(p,"apple");
        String name = method.getName();
        System.out.println(name);
        String className = personClass.getName();
        System.out.println(className);
        
    }
}
