
package de.curlse.mrpatpat.picturesofreddit.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.curlse.mrpatpat.picturesofreddit.api.Post;

public class Data_ implements Post{

    @Expose
    private String domain;
    @SerializedName("banned_by")
    @Expose
    private Object bannedBy;
    @SerializedName("media_embed")
    @Expose
    private MediaEmbed mediaEmbed;
    @Expose
    private String subreddit;
    @SerializedName("selftext_html")
    @Expose
    private Object selftextHtml;
    @Expose
    private String selftext;
    @Expose
    private Object likes;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = new ArrayList<Object>();
    @SerializedName("secure_media")
    @Expose
    private Object secureMedia;
    @SerializedName("link_flair_text")
    @Expose
    private Object linkFlairText;
    @Expose
    private String id;
    @Expose
    private int gilded;
    @SerializedName("secure_media_embed")
    @Expose
    private SecureMediaEmbed secureMediaEmbed;
    @Expose
    private boolean clicked;
    @SerializedName("report_reasons")
    @Expose
    private Object reportReasons;
    @Expose
    private String author;
    @Expose
    private Object media;
    @Expose
    private int score;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @SerializedName("over_18")
    @Expose
    private boolean over18;
    @Expose
    private boolean hidden;
    @Expose
    private String thumbnail;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @Expose
    private boolean edited;
    @SerializedName("link_flair_css_class")
    @Expose
    private Object linkFlairCssClass;
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @Expose
    private int downs;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = new ArrayList<Object>();
    @Expose
    private boolean saved;
    @SerializedName("is_self")
    @Expose
    private boolean isSelf;
    @Expose
    private String name;
    @Expose
    private String permalink;
    @Expose
    private boolean stickied;
    @Expose
    private double created;
    @Expose
    private String url;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @Expose
    private String title;
    @SerializedName("created_utc")
    @Expose
    private double createdUtc;
    @Expose
    private int ups;
    @SerializedName("num_comments")
    @Expose
    private int numComments;
    @Expose
    private boolean visited;
    @SerializedName("num_reports")
    @Expose
    private Object numReports;
    @Expose
    private Object distinguished;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Data_ withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Object getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    public Data_ withBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
        return this;
    }

    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public Data_ withMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
        return this;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Data_ withSubreddit(String subreddit) {
        this.subreddit = subreddit;
        return this;
    }

    public Object getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(Object selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public Data_ withSelftextHtml(Object selftextHtml) {
        this.selftextHtml = selftextHtml;
        return this;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public Data_ withSelftext(String selftext) {
        this.selftext = selftext;
        return this;
    }

    public Object getLikes() {
        return likes;
    }

    public void setLikes(Object likes) {
        this.likes = likes;
    }

    public Data_ withLikes(Object likes) {
        this.likes = likes;
        return this;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public Data_ withUserReports(List<Object> userReports) {
        this.userReports = userReports;
        return this;
    }

    public Object getSecureMedia() {
        return secureMedia;
    }

    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    public Data_ withSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
        return this;
    }

    public Object getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public Data_ withLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Data_ withId(String id) {
        this.id = id;
        return this;
    }

    public int getGilded() {
        return gilded;
    }

    public void setGilded(int gilded) {
        this.gilded = gilded;
    }

    public Data_ withGilded(int gilded) {
        this.gilded = gilded;
        return this;
    }

    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    public Data_ withSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
        return this;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public Data_ withClicked(boolean clicked) {
        this.clicked = clicked;
        return this;
    }

    public Object getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    public Data_ withReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Data_ withAuthor(String author) {
        this.author = author;
        return this;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Data_ withMedia(Object media) {
        this.media = media;
        return this;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Data_ withScore(int score) {
        this.score = score;
        return this;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Data_ withApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
        return this;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public Data_ withOver18(boolean over18) {
        this.over18 = over18;
        return this;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Data_ withHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Data_ withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Data_ withSubredditId(String subredditId) {
        this.subredditId = subredditId;
        return this;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public Data_ withEdited(boolean edited) {
        this.edited = edited;
        return this;
    }

    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public Data_ withLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
        return this;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public Data_ withAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
        return this;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public Data_ withDowns(int downs) {
        this.downs = downs;
        return this;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public Data_ withModReports(List<Object> modReports) {
        this.modReports = modReports;
        return this;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public Data_ withSaved(boolean saved) {
        this.saved = saved;
        return this;
    }

    public boolean isIsSelf() {
        return isSelf;
    }

    public void setIsSelf(boolean isSelf) {
        this.isSelf = isSelf;
    }

    public Data_ withIsSelf(boolean isSelf) {
        this.isSelf = isSelf;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data_ withName(String name) {
        this.name = name;
        return this;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Data_ withPermalink(String permalink) {
        this.permalink = permalink;
        return this;
    }

    public boolean isStickied() {
        return stickied;
    }

    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }

    public Data_ withStickied(boolean stickied) {
        this.stickied = stickied;
        return this;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public Data_ withCreated(double created) {
        this.created = created;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Data_ withUrl(String url) {
        this.url = url;
        return this;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public Data_ withAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data_ withTitle(String title) {
        this.title = title;
        return this;
    }

    public double getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Data_ withCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
        return this;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public Data_ withUps(int ups) {
        this.ups = ups;
        return this;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public Data_ withNumComments(int numComments) {
        this.numComments = numComments;
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Data_ withVisited(boolean visited) {
        this.visited = visited;
        return this;
    }

    public Object getNumReports() {
        return numReports;
    }

    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    public Data_ withNumReports(Object numReports) {
        this.numReports = numReports;
        return this;
    }

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public Data_ withDistinguished(Object distinguished) {
        this.distinguished = distinguished;
        return this;
    }

}
