package cn.gebixiaoba.controller;

import cn.gebixiaoba.bean.Message;
import cn.gebixiaoba.entity.Signature;
import cn.gebixiaoba.entity.Warehouseman;
import cn.gebixiaoba.entity.WarehousemanOrderBook;
import cn.gebixiaoba.services.WarehousemanService;
import cn.gebixiaoba.untils.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2020/3/27.
 */
@Controller
@RequestMapping("warehouseman")
public class WarehousemanController {
    @Value("${upload.savePath}")
    private String savePath;

    @Autowired
    private WarehousemanService warehousemanService;
    @RequestMapping("login")
    @ResponseBody
    public Warehouseman login(Warehouseman warehouseman){
        return warehousemanService.checkout(warehouseman);
    }

    @RequestMapping("orderbooklist")
    @ResponseBody
    public List<WarehousemanOrderBook> findrdAllOrderBook(Warehouseman warehouseman){
        return warehousemanService.findAllOrderBook();
    }

    @RequestMapping("signature/{clazz}")
    @ResponseBody
    public Signature findByClazz(@PathVariable("clazz") String clazz){
        return warehousemanService.findByClazz(clazz);
    }

    @RequestMapping("upload")
    @ResponseBody
    public Message upload(HttpServletRequest request,@RequestParam(value="file")MultipartFile file){
        Message message = new Message();
        Signature signature = new Signature();
        if (!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            String type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            String sha1 = SHA1.encode(file);
            fileName = sha1+"."+type;

            try {
                File  saveFilePath = new File(this.savePath);
                System.out.println(saveFilePath);
                if (!saveFilePath.exists()) {//如果"realPath+relPath"这个路径不存在则创建该路径
                    saveFilePath.mkdirs();
                }
                String path = this.savePath+fileName;
                System.out.println(path);
                file.transferTo(new File(path));
            }catch (Exception e){

            }
            signature.setPath(fileName);
            signature.setClazz(request.getParameter("clazz"));
            signature.setTips(request.getParameter("tips"));
            message = warehousemanService.upload(signature);
        }else {
           message.setCode(-2);
           message.setMessage("文件不能为空");
        }

        return message;
    }

}
