package com.robot0x.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Jackie on 2016/3/4.
 */
public class StringUtil {

    /**
     * 判断给定字符串是否空白串，空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null祸空字符串，返回true
     * @param input
     * @return
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input)) {
            return true;
        }

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (c!=' ' && c!='\t' && c!='\r' && c!='\n' ) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将一个InputStream流转换成字符串
     * @param is
     * @return
     */
    public static String toConvertString(InputStream is) {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer res = new StringBuffer();
        try {
            String line = reader.readLine();
            while (line != null) {
                res.append(line + "<br>");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is) {
                    is.close();;
                    is = null;
                }
                if (null != isr) {
                    isr.close();;
                    isr = null;
                }
                if (null != reader) {
                    reader.close();
                    reader = null;
                }
            } catch (IOException e){

            }
        }
        return res.toString();
    }
}
