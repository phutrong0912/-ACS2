package com.dacs2.service;

import com.dacs2.model.ContactUrl;

import java.io.IOException;
import java.util.List;

public interface ContactUrlService {

    List<ContactUrl> getContactUrls();

    void addContactUrl(String name, String url) throws IOException;

    void deleteContactUrl(int id) throws IOException;

}
