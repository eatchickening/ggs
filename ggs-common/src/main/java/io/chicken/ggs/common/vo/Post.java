package io.chicken.ggs.common.vo;

public class Post {
    private Long postId;

    private String postcode;

    private String postName;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postcode='" + postcode + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}