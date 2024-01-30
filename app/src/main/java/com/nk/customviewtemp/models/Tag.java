package com.nk.customviewtemp.models;

/**
 * @Author: naftalikomarovski
 * @Date: 2024/01/30
 */
public class Tag {
    private String id;
    private String title;

    public Tag() {
    }

    public Tag(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equalID(String id) {
        return this.id.equals(id);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
