package de.curlse.mrpatpat.picturesofreddit.adapter;

/**
 * Created by Adrian Endrich on 14.10.14.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.curlse.mrpatpat.picturesofreddit.R;
import de.curlse.mrpatpat.picturesofreddit.api.Post;

public class RedditGridAdapter extends ArrayAdapter<Post> {

    /**
     * layout inflater
     */
    private LayoutInflater mInflater;

    /**
     * constructs a new RedditGridAdapter
     * @param context
     * @param textViewResourceId
     * @param posts the posts
     */
    public RedditGridAdapter(Context context, int textViewResourceId, List<Post> posts) {
        super(context, textViewResourceId, posts);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * get the view of a single gridlist entry
     * @param position
     * @param convertView
     * @param parent
     * @return the view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder;

        if (view == null) {
            // View doesn't exist so create it and create the holder
            view = mInflater.inflate(R.layout.grid_cell, parent, false);

            holder = new Holder();
            holder.thumbnail = (ImageView) view.findViewById(R.id.imageView);

            view.setTag(holder);

        } else {
            // Just get our existing holder
            holder = (Holder) view.getTag();
        }
        Post post = getItem(position);

        Glide.with(getContext())
                .load(post.getUrl())
                .placeholder(R.drawable.loader)
                .into(holder.thumbnail);

        return view;
    }

    /**
     * Holder class for efficiency
     */
    private static final class Holder {
        public ImageView thumbnail;
    }
}

