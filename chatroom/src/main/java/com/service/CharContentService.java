package com.service;

import com.pojo.CharContent;

import java.io.IOException;
import java.util.List;

public interface CharContentService {
    public void addNewcontent(CharContent charContent) throws IOException;

    public List<CharContent> findNewcontent() throws IOException;

    public List<CharContent> findAllContent() throws IOException;

    public void deleteContent(CharContent charContent) throws IOException;

    public void logicDelete(CharContent charContent)  throws  IOException;

    public void recover(CharContent charContent) throws  IOException;

    public List<CharContent> findAllLogicDelete() throws IOException;
}
