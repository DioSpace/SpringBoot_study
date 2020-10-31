package com.my.service;

import com.my.utils.models.ReturnValue;
import org.springframework.web.multipart.MultipartFile;

public interface FileManagerService {
    public ReturnValue uploadFileTest(MultipartFile zipFile, String describe);
}
