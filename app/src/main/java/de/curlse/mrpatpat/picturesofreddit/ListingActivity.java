package de.curlse.mrpatpat.picturesofreddit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.curlse.mrpatpat.picturesofreddit.adapter.RedditGridAdapter;
import de.curlse.mrpatpat.picturesofreddit.api.Post;
import de.curlse.mrpatpat.picturesofreddit.api.RedditClient;
import de.curlse.mrpatpat.picturesofreddit.listener.EndlessScrollListener;
import de.curlse.mrpatpat.picturesofreddit.model.Child;
import de.curlse.mrpatpat.picturesofreddit.model.Listing;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ListingActivity extends Activity implements Callback<Listing>, AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

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
     * swipe 2 refresh
     */
    private SwipeRefreshLayout mSwipeRefreshLayout;

    /**
     * grid view
     */
    private GridView gridView;

    /**
     * drawer layout
     */
    private DrawerLayout mDrawerLayout;

    /**
     * drawer list
     */
    private ListView mDrawerList;

    /**
     * called on activity creation
     *
     * @param savedInstanceState saved Instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        initDrawer();
        initSwipeToRefresh();
        bindAdapter();
        load("earthporn", "hot");
    }

    private void initDrawer() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        //mDrawerList.setAdapter(new ArrayAdapter<String>(this,
        //      R.layout.drawer_list_item, mPlanetTitles));
        // Set the list's click listener
        //mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    /**
     * called on menu creation
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    /**
     * on menu item click
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_refresh:
                this.refresh();
                break;
            // action with ID action_settings was selected
            case R.id.action_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }

    /**
     * swipe 2 refresh
     */
    private void initSwipeToRefresh() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.s2rLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    /**
     * binds the post list data to the gridview through an adapter
     */
    private void bindAdapter() {
        if (posts == null)
            posts = new ArrayList<Post>();

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setOnScrollListener(new EndlessScrollListener(this));
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
    public void loadMore() {
        if(!isDownloading) {
            this.isDownloading = true;
            RedditClient.getRedditClient().getPostsAfter(subreddit, section, lastPost.getName(), this);
        }
    }

    /**
     * refreshes results
     */
    private void refresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        posts.clear();
        adapter.notifyDataSetChanged();
        bindAdapter();
        load(subreddit, section);
    }

    /**
     * called when the request results are ready
     * @param listing the result
     * @param response the response
     */
    @Override
    public void success(Listing listing, Response response) {

        List<Child> children = listing.getData().getChildren();

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
        this.mSwipeRefreshLayout.setRefreshing(false);

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

    /**
     * on swipe 2 refresh
     */
    @Override
    public void onRefresh() {
        this.refresh();
    }

    public GridView getGridView() {
        return gridView;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

}
