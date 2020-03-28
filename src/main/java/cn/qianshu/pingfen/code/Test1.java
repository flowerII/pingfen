package cn.qianshu.pingfen.code;

import java.io.File;

public class Test1 {
    public static void main(String[] args) throws Exception {
        String imgPath = "e:\\二维码12.png";
        String content = "helloworld你好";
        String logo = "D:\\javawork\\T-1\\src\\main\\resources\\static\\images\\locked.png";
        //加密：文字信息->二维码
        ZXingUtil.encodeImg(imgPath, "png",content, 430, 430,logo);
        //解密：二维码  ->文字信息
        ZXingUtil.decodeImg(new File(imgPath));
    }
}