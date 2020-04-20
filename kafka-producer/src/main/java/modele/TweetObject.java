package modele;

import java.util.Date;

public class TweetObject {

    public TweetObject(){};

    public Long statusId;

    public String displayName;

    public Date date;

    public int retweetCount;

    public int favoriteCount;

    public String country;

    public String countryCode;

    public String source;

    public String tweetText;

    public Long getStatusId() {
        return statusId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Date getDate() {
        return date;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSource() {
        return source;
    }

    public String getTweetText() {
        return tweetText;
    }

    @Override
    public String toString() {
        return "TweetObject{" +
                "statusId=" + statusId +
                ", displayName='" + displayName + '\'' +
                ", date=" + date +
                ", retweetCount=" + retweetCount +
                ", favoriteCount=" + favoriteCount +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", source='" + source + '\'' +
                ", tweetText='" + tweetText + '\'' +
                '}';
    }

    public TweetObject(Long statusId, String displayName, Date date, int retweetCount, int favoriteCount, String country, String countryCode, String source, String tweetText) {
        this.statusId = statusId;
        this.displayName = displayName;
        this.date = date;
        this.retweetCount = retweetCount;
        this.favoriteCount = favoriteCount;
        this.country = country;
        this.countryCode = countryCode;
        this.source = source;
        this.tweetText = tweetText;
    }


    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }
}
