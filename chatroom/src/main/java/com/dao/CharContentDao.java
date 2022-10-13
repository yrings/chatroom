package com.dao;

import com.pojo.CharContent;

import java.util.List;

public interface CharContentDao {
    public void addNewcontent(CharContent charContent);


    //查询出最新的10条记录
    public List<CharContent> findNewcontent();

    public CharContent findAllcontent();

    public List<CharContent> findAllContent();

    public void deleteContent(CharContent charContent);

    public void logicDelete(CharContent charContent);

    public void recoverContent(CharContent charContent);

    public List<CharContent> findAllLogicDelete();
}
