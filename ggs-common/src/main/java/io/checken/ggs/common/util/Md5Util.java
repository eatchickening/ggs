package io.checken.ggs.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    public static String Md5(final String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 为摘要对象提供数据
            md.update(str.getBytes());
            // 计算摘要（hash value），长度16的字节数组（16*8=128位）
            byte b[] = md.digest();

            // 将每个字节都转换成16进制，拼接成32位的字符串（简短，方便使用）
            // java中需要自己手动转换成16进制，所以md5加密方法才有下面的代码
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                /*
                 * 0xff(十六进制)，其为int类型，所以其二进制为：0000 0000 0000 0000 0000 0000 1111 1111 & 0xff 意思是取低8位
                 */
                int i = b[offset] & 0xff; // 相当于i += 256;
                buf.append(String.format("%02x", i));

                // 这种转换方式也可以
                // if(i<16)
                // buf.append("0");
                // String s = Integer.toHexString(i);

            }
            return buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.Md5("helo"));
    }
}