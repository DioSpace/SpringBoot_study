package com.my.service.impl;

import com.my.service.FileManagerService;
import com.my.utils.models.ReturnCodeAndMsgEnum;
import com.my.utils.models.ReturnValue;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileManagerServiceImpl implements FileManagerService {

    private static final Logger logger = LoggerFactory.getLogger(FileManagerServiceImpl.class);

    @Override
    public ReturnValue uploadFileTest(MultipartFile zipFile, String describe) {
        String targetFilePath = "F:\\ideaProjects\\StoreFile";
        String fileName = describe;
        if (fileName == null) {//如果名字为空,就取个随机值
            fileName = UUID.randomUUID().toString().replace("-", "");
        }
        File targetFile = new File(targetFilePath + File.separator + fileName);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFile);
            IOUtils.copy(zipFile.getInputStream(), fileOutputStream);
            logger.info("------>>>>>>uploaded a file successfully!<<<<<<------");
        } catch (IOException e) {
            return new ReturnValue<>(-1, null);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return new ReturnValue<>(ReturnCodeAndMsgEnum.Success, null);
    }
}
