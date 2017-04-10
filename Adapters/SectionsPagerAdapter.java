
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twisstosin on 1/25/2017.
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Tab> tabArray = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm, List<Tab> TabArrayList) {
        super(fm);
        tabArray = TabArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        if(tabArray.get(position).ID == 2)
            return AlbumsFragment.newInstance(2);
        else
            return TabFragment.newInstance(tabArray.get(position).ID);
    }

    @Override
    public int getCount() {
        // Show number total pages.
        return tabArray.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //Removed Super Class so fragment won't be destroyed when way off screen
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabArray.get(position).Title;
    }

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        super.restoreState(state, loader);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}