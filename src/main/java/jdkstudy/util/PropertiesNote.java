package jdkstudy.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * =========================================
 * Properties 源码学习笔记
 * =========================================
 *
 * 1. 继承关系：
 *    - extends Hashtable<Object, Object>
 *
 * 2. 设计目的：
 *    - 用于配置文件（.properties）
 *    - 历史原因导致使用 Hashtable
 *
 * 3. 核心特点：
 *    - 线程安全（synchronized）
 *    - key / value 实际应为 String
 *    - 不推荐作为普通 Map 使用
 *
 * 4. 常用 API：
 *    - load(InputStream)
 *    - getProperty(String)
 *    - setProperty(String, String)
 *
 * 5. 易踩坑：
 *    - put(Object, Object) 会绕过 String 约束
 *    - 默认编码是 ISO-8859-1
 *
 */
public class PropertiesNote {

    public static void main(String[] args) throws Exception {
        basicUse();
    }

    /**
     * 最基本的使用方式
     * 1. 创建对象
     * 2. 加载输入流
     * 3. 获取属性
     */
    static void basicUse() throws Exception {
        Properties props = new Properties();

        // 默认获取输入流的位置：src/main/resources
        InputStream in = PropertiesNote.class.getClassLoader().getResourceAsStream("app.properties");

        if (in != null) {
            // 加载输入流
            props.load(in);
            in.close();
        }

        // 获取属性
        String url = props.getProperty("db.url");
        String url2 = props.get("db.url").toString();
        System.out.println("数据库URL: " + url);
    }
}
