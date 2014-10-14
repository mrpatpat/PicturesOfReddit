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
    private LayoutInflater mInflater;

    public RedditGridAdapter(Context context, int textViewResourceId, List<Post> objects) {
        super(context, textViewResourceId, objects);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

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

        // Populate via the holder for speed
        Post post = getItem(position);

        // Populate the item contents

        // Load the screen cap image on a background thread
        Glide.with(getContext())
                .load(post.getUrl())
                .into(holder.thumbnail);

        return view;
    }

    // Holder class used to efficiently recycle view positions
    private static final class Holder {
        public ImageView thumbnail;
    }
}
