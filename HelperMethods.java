/**
 * Created by twisstosin on 1/25/2017.
 */

public class HelperMethods 
{




    //Check If RecyclerView has reached end of items
    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(isLastItemDisplaying(recyclerView)) //check for scroll down
                {
                    //Last item on list is being displayed, perform action here
                }
            }
        });

    //Check if last item in a recyclerView is being displayed
    public boolean isLastItemDisplaying(RecyclerView recyclerView)
    {
        if (recyclerView.getAdapter().getItemCount() != 0) {
            int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.getAdapter().getItemCount() - 1)
                return true;
        }
        return false;
    }
}