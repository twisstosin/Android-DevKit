
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by twisstosin on 4/9/2017.
 */

public class CustomListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Artist> artists;

    public CustomListAdapter(Context context, List<Artist> items) {
        this.artists = items;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        if(artists != null)
        return artists.size();
    }

    @Override
    public Object getItem(int i) {
        if(artists != null)
        return artists.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    private static class ViewHolder {
        public TextView nameView;
        public ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        LayoutInflater li = (LayoutInflater)CustomListAdapter.this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = li.inflate(R.layout.list_item,null);
            holder.nameView = (TextView) convertView.findViewById(R.id.text);
            holder.img = (ImageView) convertView.findViewById(R.id.photo);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        if(artists != null) {
            holder.nameView.setText(artists.get(position).getArtisteName());
            
        }
        else
            {
                holder.nameView.setText(songs.get(position).getTitle());
                holder.nameView.setTextSize(15);
                
            }
        return convertView;

    }
}
