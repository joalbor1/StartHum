package com.starthum.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.starthum.R;
import com.starthum.ShowResults;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class LazyAdapter extends BaseAdapter {
 
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
 
    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data = d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);
 
        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
        TextView genre = (TextView)vi.findViewById(R.id.genre); // genre
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
        TextView pos = (TextView)vi.findViewById(R.id.position); // genre
        
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);
 
        // Setting all values in listview
        title.setText(song.get(ShowResults.KEY_TITLE));
        artist.setText(song.get(ShowResults.KEY_ARTIST));
        genre.setText(song.get(ShowResults.KEY_GENRE));
        imageLoader.DisplayImage(song.get(ShowResults.KEY_THUMB_URL), thumb_image);
        pos.setText(song.get(ShowResults.KEY_POSITION));
        return vi;
    }
}