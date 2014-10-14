package de.curlse.mrpatpat.picturesofreddit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.curlse.mrpatpat.picturesofreddit.adapter.RedditGridAdapter;
import de.curlse.mrpatpat.picturesofreddit.api.Post;
import de.curlse.mrpatpat.picturesofreddit.api.RedditClient;
import de.curlse.mrpatpat.picturesofreddit.model.Child;
import de.curlse.mrpatpat.picturesofreddit.model.Listing;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ListingActivity extends Activity implements Callback<Listing>, AdapterView.OnItemClickListener {

    /**
     * List of all Posts
     */
    private List<Post> posts;

    /**
     * Adapter to bind posts to grid
     */
    private RedditGridAdapter adapter;

    /**
     * indicates wether a download is in progress
     */
    private boolean isDownloading = false;

    /**
     * the last post
     */
    private Post lastPost;

    /**
     * current subreddit
     */
    private String subreddit;

    /**
     * current section
     */
    private String section;

    /**
     * called on activity creation
     *
     * @param savedInstanceState saved Instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        bindAdapter();
    }

    /**
     * binds the post list data to the gridview through an adapter
     */
    private void bindAdapter() {
        if (posts == null)
            posts = new ArrayList<Post>();

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setOnScrollListener(new EndlessScrollListener());
        adapter = new RedditGridAdapter(this, 0, posts);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    /**
     * loads a subreddit and section
     */
    private void load(String subreddit, String section) {
        if(!isDownloading) {
            this.isDownloading = true;
            this.subreddit = subreddit;
            this.section = section;
            RedditClient.getRedditClient().getPosts(subreddit, section, this);
        }
    }

    /**
     * loads more results
     */
    private void loadMore() {
        if(!isDownloading) {
            this.isDownloading = true;
            RedditClient.getRedditClient().getPostsAfter(subreddit, section, lastPost.getName(), this);
        }
    }

    /**
     * refreshes results
     */
    private void refresh() {
        if(!isDownloading) {
            this.isDownloading = true;
            RedditClient.getRedditClient().getPosts(subreddit, section, this);
        }
    }

    /**
     * called when the request results are ready
     * @param listing the result
     * @param response the response
     */
    @Override
    public void success(Listing listing, Response response) {

        List<Child> children = listing.getData().getChildren();
        List<Post> posts = new ArrayList<Post>();

        for (Child c : children) {
            Post p = c.getData();
            if (p.getThumbnail() != "default" && p.getThumbnail() != ""
                    && (p.getUrl().endsWith(".jpg") || p.getUrl().endsWith(".jpeg")
                    || p.getUrl().endsWith(".png") || p.getUrl().endsWith(".gif")
                    || p.getUrl().endsWith(".bmp"))) {
                posts.add(p);
            }
        }

        this.posts.addAll(posts);
        this.lastPost = this.posts.get(this.posts.size() - 1);

        this.isDownloading = false;

        adapter.notifyDataSetChanged();
    }

    /**
     * called when the API Request failed.
     * @param error the error
     */
    @Override
    public void failure(RetrofitError error) {
        Toast.makeText(this,"Api Error",Toast.LENGTH_LONG).show();
        Log.e("RETROFIT",error.getMessage());
        this.isDownloading = false;
    }

    /**
     * called when an grid cell is clicked
     * @param adapterView adapterView
     * @param view view
     * @param pos position in the list
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

    }

    public class EndlessScrollListener implements AbsListView.OnScrollListener {

        private int visibleThreshold = 5;
        private int currentPage = 0;
        private int previousTotal = 0;
        private boolean loading = true;

        public EndlessScrollListener() {
        }

        public EndlessScrollListener(int visibleThreshold) {
            this.visibleThreshold = visibleThreshold;
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem,
                             int visibleItemCount, int totalItemCount) {
            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                    currentPage++;
                }
            }
            if (!loading &&
                    (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                // I load the next page of gigs using a background task,
                // but you can call any function here.
                loadMore();
                loading = true;
            }
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {


        }
    }
}
