package com.gupaoedu.vip.pattern.factory.simplefactory;

/**
 * Created by Tom.
 */
public class CourseFactory {
    public ICouse create(Class<? extends ICouse> clazz){
//        if("java".equals(name)){
//            return new JavaCouse();
//        }else if("python".equals(name)){
//            return new PythonCouse();
//        }else {
//            return null;
//        }

//        try {
//            if (!(null == className || "".equals(className))) {
//                return (ICouse) Class.forName(className).newInstance();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;

        try {
            if (null != clazz) {
                return clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
