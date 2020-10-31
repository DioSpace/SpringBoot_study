package com.my.controller;

import com.my.service.FileManagerService;
import com.my.utils.models.ReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file")
public class FileManagerController {

    @Autowired
    private FileManagerService fileManagerService;

    /**
     * 文件上传测试接口
     *
     * @return
     */
    @RequestMapping("/upload")
    public ReturnValue uploadFileTest(@RequestParam("uploadFile") MultipartFile zipFile,
                                      @RequestParam("describe") String describe) {
        return fileManagerService.uploadFileTest(zipFile, describe);
    }

}
