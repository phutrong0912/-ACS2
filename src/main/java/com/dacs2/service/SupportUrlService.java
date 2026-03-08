package com.dacs2.service;

import com.dacs2.model.SupportUrl;

import java.util.List;

public interface SupportUrlService {

    void addSupportUrl(String title, String url, String position);

    List<SupportUrl> getSupportUrl();

    void deleteSupportUrl(Integer id);

}
