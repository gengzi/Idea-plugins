package club.gsjblog.soulsoother.utils;

import org.apache.http.util.TextUtils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    /**
     * 获取properties 的配置内容
     * @param filePath
     * @param keyWord
     * @return
             * @throws IOException
     */
    public static String getPropertieByKey(String filePath, String keyWord) {
        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            properties.load(bufferedReader);
            String des = properties.getProperty(keyWord);
            if(TextUtils.isEmpty(des)){
                return "des:字段未定义";
            }
            return des;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return  "所peoperties文件未找到，请查看配置的路径，以及文件的权限配置为完全控制";
        } catch (IOException e) {
            e.printStackTrace();
            return "请查看perperties的文件权限";
        } finally {
            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "des:解析失败";
    }


    /**
     * 获取文件行数
     * @param filePath  文件路径
     * @return
     * @throws IOException
     */
    public static int getTotalLines(String filePath) throws IOException {
        File file = new File(filePath);
        long startTime = System.currentTimeMillis();
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        reader.skip(Long.MAX_VALUE);
        int lines = reader.getLineNumber();
        reader.close();
        long endTime = System.currentTimeMillis();

        System.out.println("统计文件行数运行时间： " + (endTime - startTime) + "ms");
        return lines;
    }
}
