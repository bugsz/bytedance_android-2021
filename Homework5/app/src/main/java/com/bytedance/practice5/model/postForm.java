package com.bytedance.practice5.model;

import com.google.gson.annotations.SerializedName;

import okhttp3.MultipartBody;

public class postForm {
    public postForm(){
        from = "";
        to = "";
        content = "";
        image = null;
    }

    @SerializedName("from")
    String from;
    @SerializedName("to")
    String to;
    @SerializedName("content")
    String content;
    @SerializedName("image")
    MultipartBody.Part image;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartBody.Part getImage() {
        return image;
    }

    public void setImage(MultipartBody.Part image) {
        this.image = image;
    }

}
