package de.curlse.mrpatpat.picturesofreddit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;

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


public class ListingActivity extends Activity implements Callback<Listing> {

    private List<Post> posts;

    private RedditGridAdapter mAdapter;
    private boolean mIsDownloadInProgress = false;
    private Post last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listing);


        // Create the array adapter and bind it to the gridview
        posts = new ArrayList<Post>();
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setOnScrollListener(new EndlessScrollListener());
        mAdapter = new RedditGridAdapter(this, 0, posts);
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        downloadData();
    }

    private void downloadData() {
        if (last == null) {
            RedditClient.getRedditClient().getPosts("earthporn", "hot", this);
        } else {
            RedditClient.getRedditClient().getPostsAfter("earthporn", "hot",this.last.getName(), this);
        }
    }

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
        // Add the found streams to our array to render
        this.posts.addAll(posts);
        this.last = this.posts.get(this.posts.size() - 1);

        // Tell the adapter that it needs to rerender
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void failure(RetrofitError error) {

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
            if ( !loading &&
            (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)){
                // I load the next page of gigs using a background task,
                // but you can call any function here.
                downloadData();
                loading = true;
            }
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {


        }
    }
}
