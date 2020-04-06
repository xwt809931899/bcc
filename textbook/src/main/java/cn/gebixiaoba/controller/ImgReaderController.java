package cn.gebixiaoba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2020/4/3.
 */
@Controller
@RequestMapping("img")
public class ImgReaderController {

    @Value("${upload.savePath}")
    private String savePath;

    @RequestMapping("original/{fileName}")
    public String originalImage(@PathVariable(value="fileName") String fileName,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {

        String  type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
        String filePath = savePath + fileName;
        System.out.println(filePath);
        FileInputStream inputStream = null;
        OutputStream out = null;
        try {
            out = httpServletResponse.getOutputStream();
            inputStream = new FileInputStream(filePath);
            //设置发送到客户端的响应内容类型
            httpServletResponse.setContentType("image/"+type);
            //设置文件头：如果设置则自动变成下载模式
            //httpServletResponse.setHeader("Content-Disposition", "attachment;fileName="+fileName);

			/*缓存读写		begin*/
            byte[] buffer = new byte[inputStream.available()];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
			/*缓存读写		end*/

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                out.close();
            } catch (IOException e) {

            }

        }
        return null;
    }
}
