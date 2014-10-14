package de.curlse.mrpatpat.picturesofreddit.api;

import de.curlse.mrpatpat.picturesofreddit.model.Listing;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Adrian Endrich on 14.10.14.
 */
public class RedditClient {

    private static RedditApiInterface redditService;

    public static RedditApiInterface getRedditClient() {
        if (redditService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://reddit.com/r")
                    .build();
            redditService = restAdapter.create(RedditApiInterface.class);
        }
        return redditService;
    }

    public interface RedditApiInterface {
        @GET("/{subreddit}/{section}.json")
        void getPosts(@Path("subreddit") String subreddit, @Path("section") String section, Callback<Listing> callback);

        @GET("/{subreddit}/{section}.json")
        void getPostsAfter(@Path("subreddit") String subreddit, @Path("section") String section, @Query("after") String after, Callback<Listing> callback);
    }

}
