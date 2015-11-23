package by.minsk.gerasimenko.anton.feed.models;

/**
 * Created by gerasimenko on 07.10.2015.
 */

public class NewsPOJO {

    //@JsonProperty("id")
    private int id;
    //@JsonProperty("newsId")
    private int newsId;
    //@JsonProperty("categoryId")
    private int categoryId;

    //@JsonProperty("pubDate")
    private long pubDate;

    //@JsonProperty("region")
    private int region;

    //@JsonProperty("title")
    private String title;

    //@JsonProperty("summary")
    private String summary;

    //@JsonProperty("frontImageUrl")
    private String frontImageUrl;

    //@JsonProperty("frontURLImageUrlSize1")
    private String frontImageUrlSize1;

    //@JsonProperty("frontURLImageUrlSize2")
    private String frontImageUrlSize2;

    //@JsonProperty("commentCount")
    private int commentCount;

    //@JsonProperty("shortUrl")
    private String shortUrl;

    //@JsonProperty("isPhoto")
    private boolean isPhoto;

    //@JsonProperty("isInfographic")
    private boolean isInfographic;

    //@JsonProperty("isVideo")
    private boolean isVideo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFrontImageUrl() {
        return frontImageUrl;
    }

    public void setFrontImageUrl(String frontImageUrl) {
        this.frontImageUrl = frontImageUrl;
    }

    public String getFrontImageUrlSize1() {
        return frontImageUrlSize1;
    }

    public void setFrontImageUrlSize1(String frontImageUrlSize1) {
        this.frontImageUrlSize1 = frontImageUrlSize1;
    }

    public String getFrontImageUrlSize2() {
        return frontImageUrlSize2;
    }

    public void setFrontImageUrlSize2(String frontImageUrlSize2) {
        this.frontImageUrlSize2 = frontImageUrlSize2;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public boolean isPhoto() {
        return isPhoto;
    }

    public void setIsPhoto(boolean isPhoto) {
        this.isPhoto = isPhoto;
    }

    public boolean isInfographic() {
        return isInfographic;
    }

    public void setIsInfographic(boolean isInfographic) {
        this.isInfographic = isInfographic;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
    }
}
