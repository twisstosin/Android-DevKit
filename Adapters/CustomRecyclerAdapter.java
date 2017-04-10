
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by twisstosin on 11/27/2016.
 */

 //From a Music App
 //Can be edited to fit intended use

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    private List<Song> songList;
    private Context context;

    // Allows to remember the last item shown on screen

    private int lastPosition = 0;

    private MyViewHolder previousView;

    public CustomRecyclerAdapter() {
    }

    public CustomRecyclerAdapter(Context context, List<Song> songList) {
        this.context = context;
        this.songList = songList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song,parent, false);

        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Here you apply the animation when the view is bound
        //setAnimation(holder.container, position);

        if(songList != null) {
            final Song song = songList.get(position);

            holder.artisteTextView.setText(song.getArtiste());
            holder.titleTextView.setText(song.getTitle());

//            holder.artisteTextView.setTextColor();
//            holder.titleTextView.setTextColor(R.color.colorAccent);
//            holder.visualizer.setVisibility(View.GONE);
//            holder.tintView.setVisibility(View.GONE);

            holder.imageView.setImageResource(song.getImageUrl());
        }
    }

    @Override
    public int getItemCount() {
        if(songList != null)
            return songList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView artisteTextView;
        TextView titleTextView;
        ImageView imageView;
        MusicVisualizer visualizer;
        View tintView;
        boolean Clicked = false;

        ImageButton moreBtn;
        //CardView container;
        public MyViewHolder(View view) {
            super(view);
            artisteTextView = (TextView) view.findViewById(R.id.song_artist);
            titleTextView = (TextView) view.findViewById(R.id.song_title);
            imageView = (ImageView)view.findViewById(R.id.photo);
            tintView = (View)view.findViewById(R.id.tint_view);
            moreBtn = (ImageButton)view.findViewById(R.id.btn_more);

          //  container = (CardView)view.findViewById(R.id.card_container);

            visualizer = (MusicVisualizer)view.findViewById(R.id.visualizer);
        }
    }

    public void setSongPaused(RecyclerView recyclerView, int position)
    {
        MyViewHolder myViewHolder = (MyViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
        myViewHolder.visualizer.setVisibility(View.INVISIBLE);
    }

    public void setSongPlayed(RecyclerView recyclerView, int position)
    {
        if(previousView != null)
        {
            MyViewHolder previousViewHolder = previousView;

            previousViewHolder.artisteTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorPrimaryText));
            previousViewHolder.titleTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorPrimaryText));
            previousViewHolder.visualizer.setVisibility(View.GONE);
            previousViewHolder.tintView.setVisibility(View.GONE);

        }
        MyViewHolder myViewHolder = (MyViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
        myViewHolder.artisteTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorAccent));
        myViewHolder.titleTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorAccent));
        myViewHolder.visualizer.setVisibility(View.VISIBLE);
        myViewHolder.tintView.setVisibility(View.VISIBLE);
    }

    public void setSongPlaying(RecyclerView recyclerView, int position)

    {

            MyViewHolder myViewHolder = (MyViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
            if(myViewHolder != null)
            {
                myViewHolder.artisteTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorAccent));
                myViewHolder.titleTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorAccent));
                myViewHolder.visualizer.setVisibility(View.VISIBLE);
                myViewHolder.tintView.setVisibility(View.VISIBLE);
            }

        if(previousView != null && previousView != myViewHolder)
        {
            MyViewHolder previousViewHolder = previousView;

            previousViewHolder.artisteTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorPrimaryText));
            previousViewHolder.titleTextView.setTextColor(recyclerView.getResources().getColor(R.color.colorPrimaryText));
            previousViewHolder.visualizer.setVisibility(View.GONE);
            previousViewHolder.tintView.setVisibility(View.GONE);
            previousView = myViewHolder;

        }
        else
            previousView = myViewHolder;
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }



}

