package de.curlse.mrpatpat.picturesofreddit.listener;

import android.widget.AbsListView;

import de.curlse.mrpatpat.picturesofreddit.ListingActivity;

/**
 * Created by Adrian Endrich on 15.10.14.
 */
public class EndlessScrollListener implements AbsListView.OnScrollListener {

    private final ListingActivity activity;
    private int visibleThreshold = 5;
    private int previousTotal = 0;
    private boolean loading = true;

    public EndlessScrollListener(ListingActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading &&
                (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            activity.loadMore();
            loading = true;
        }

        int topRowVerticalPosition =
                (activity.getGridView() == null || activity.getGridView().getChildCount() == 0) ?
                        0 : activity.getGridView().getChildAt(0).getTop();
        activity.getSwipeRefreshLayout().setEnabled(topRowVerticalPosition >= 0);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {


    }


}
