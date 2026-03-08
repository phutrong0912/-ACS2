package com.dacs2.service;

import com.dacs2.model.WebInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface WebInfoService {

    WebInfo updateWebInfo(WebInfo webInfo, MultipartFile file) throws IOException;

    WebInfo getWebInfo();

}
