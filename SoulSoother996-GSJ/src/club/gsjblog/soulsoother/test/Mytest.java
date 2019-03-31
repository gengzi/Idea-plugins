package club.gsjblog.soulsoother.test;


import club.gsjblog.soulsoother.utils.PropertiesUtils;

public class Mytest {


    public static void main(String[] args) {
        String des = PropertiesUtils.getPropertieByKey("classpath:base.properties", "jitang06");
        System.out.println(des);

    }


    public void fun(){
        String path = this.getClass().getClassLoader().getResource("/").getPath();


    }
}
