package com.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CharContent {
    private int id;
    private String content;
    private String usernaem;

    public String getUsernaem() {
        return usernaem;
    }

    public void setUsernaem(String usernaem) {
        this.usernaem = usernaem;
    }

    public String getUp_time() {
        return up_time;
    }

    public void setUp_time(String up_time) {
        this.up_time = up_time;
    }

    private String up_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return usernaem;
    }

    public void setUsername(String username) {
        this.usernaem = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        up_time = sdf.format(time);
        this.up_time =up_time;
        this.time = time;
    }

    private Date time;

    @Override
    public String toString() {
        return "CharContent{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + usernaem +
                ", time=" + time +
                '}';
    }

}
