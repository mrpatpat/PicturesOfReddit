package de.curlse.mrpatpat.picturesofreddit.adapter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import de.curlse.mrpatpat.picturesofreddit.ListingActivity;

/**
 * Created by Adrian Endrich on 15.10.14.
 */
public class NavDrawerAdapter extends ArrayAdapter<String> implements ListView.OnItemClickListener {

    private final ListingActivity activity;
    private final int resource;
    private final List<String> objects;

    public NavDrawerAdapter(ListingActivity activity, int resource, List<String> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String subreddit = getItem(position);
        Log.i("NAV", "loading " + subreddit);
        activity.load(subreddit);
        activity.closeDrawer();
    }

}
