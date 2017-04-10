
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import static android.view.Gravity.CENTER;

/**
 * Created by twisstosin on 4/9/2017.
 */

public class SearchView extends android.support.v7.widget.SearchView {
    public SearchView(Context context) {
        super(context);

        this.onActionViewExpanded();
        this.setIconified(true);
        TextView searchText = (TextView) this.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        TextView hintText = (TextView) this.findViewById(android.support.v7.appcompat.R.id.action_text);
        hintText.setGravity(CENTER);
        searchText.setTypeface([Whatever Typeface]]);
        searchText.setTextSize(13);
        searchText.setGravity(CENTER);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.onActionViewExpanded();
        this.setIconified(true);
        TextView searchText = (TextView) this.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchText.setTypeface([Whatever Typeface]]);
        searchText.setTextSize(13);
        searchText.setGravity(CENTER);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.onActionViewExpanded();
        this.setIconified(true);
        TextView searchText = (TextView) this.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchText.setTypeface([Whatever Typeface]]);
        searchText.setTextSize(13);
        searchText.setGravity(CENTER);
    }


}
