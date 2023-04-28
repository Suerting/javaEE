package cn.edu.cqwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class SetController {
    @RequestMapping(value ="/test1",method = RequestMethod.POST)
    public String fileup(MultipartFile file1,HttpServletRequest request, Model model) throws IOException {
//        获取文件名
        String filename1=file1.getOriginalFilename();
        model.addAttribute("filename1",filename1);
//        将上传的文件传到指定文件夹
        file1.transferTo(new File(request.getRealPath("/setfile")+"\\"+file1.getOriginalFilename()));
        System.out.println(filename1);
        return "filesuccess";
    }
    @RequestMapping(value = "/file",method = RequestMethod.GET)
    public String file(){
        return "fileup";
    }
}
