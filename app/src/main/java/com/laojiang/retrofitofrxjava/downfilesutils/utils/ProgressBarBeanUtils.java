package com.laojiang.retrofitofrxjava.downfilesutils.utils;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/22 8:22.
 */

public class ProgressBarBeanUtils {
    public ProgressBarBeanUtils() {
    }

    /**

     * 直接设置对象属性值,无视private/protected修饰符,不经过setter函数.

     */

    public static void setFieldValue(final Object object, final String fieldName, final Object value) {

        Field field = getDeclaredField(object, fieldName);



        if (field == null)

            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");



        makeAccessible(field);



        try {

            field.set(object, value);

        } catch (IllegalAccessException e) {

            Log.e("zbkc", "", e);

        }

    }



    /**

     * 循环向上转型,获取对象的DeclaredField.

     */

    protected static Field getDeclaredField(final Object object, final String fieldName) {

        return getDeclaredField(object.getClass(), fieldName);

    }



    /**

     * 循环向上转型,获取类的DeclaredField.

     */

    @SuppressWarnings("unchecked")

    protected static Field getDeclaredField(final Class clazz, final String fieldName) {

        for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {

            try {

                return superClass.getDeclaredField(fieldName);

            } catch (NoSuchFieldException e) {

                // Field不在当前类定义,继续向上转型

            }

        }

        return null;

    }



    /**

     * 强制转换fileld可访问.

     */

    protected static void makeAccessible(Field field) {

        if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {

            field.setAccessible(true);

        }

    }
}
