package com.plantatree.plantatree.model;

import android.media.Image;

import com.google.gson.annotations.Expose;

import java.util.Arrays;

/**
 * Created by jianhuizhu on 15-08-22.
 */
public class Tree {
    @Expose
    private String name;
    @Expose
    private int imageResourceId;
    @Expose
    private String description;
    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("Tree{");
        sb.append("name='").append(name).append('\'');
        sb.append(", imageResourceId=").append(imageResourceId);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
