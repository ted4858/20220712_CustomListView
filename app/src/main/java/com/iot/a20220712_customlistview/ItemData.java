package com.iot.a20220712_customlistview;

public class ItemData {
    private int image = 0;
    private String name = null;
    private long time = 0;
    private String message = null;

    public ItemData(int imageRid, String name, long time, String message) {
        this.image = imageRid;
        this.name = name;
        this.time = time;
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int imageRid) {
        this.image = imageRid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
