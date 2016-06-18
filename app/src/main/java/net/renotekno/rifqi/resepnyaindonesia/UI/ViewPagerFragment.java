package net.renotekno.rifqi.resepnyaindonesia.UI;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.renotekno.rifqi.resepnyaindonesia.Model.Recipes;
import net.renotekno.rifqi.resepnyaindonesia.R;

public class ViewPagerFragment extends Fragment {
    private int index;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        index = getArguments().getInt(MainActivity.ITEM_INDEX);
        getActivity().setTitle(Recipes.names[index]);

        final DirectionFragment directionFragment = new DirectionFragment();
        final IngridientsFragment ingridientFragment = new IngridientsFragment();

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? directionFragment : ingridientFragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });



        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
