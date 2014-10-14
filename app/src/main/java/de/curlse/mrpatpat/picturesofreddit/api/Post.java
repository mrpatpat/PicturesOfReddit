package de.curlse.mrpatpat.picturesofreddit.api;

/**
 * Created by Adrian Endrich on 14.10.14.
 */
public interface Post {

    public String getName();
    public String getSubreddit();
    public String getSelftext();
    public String getAuthor();
    public int getScore();
    public boolean isOver18();
    public String getThumbnail();
    public int getDowns();
    public String getPermalink();
    public boolean isStickied();
    public double getCreated();
    public String getUrl();
    public String getTitle();
    public double getCreatedUtc();
    public int getUps();
    public int getNumComments();

}
