package net.renotekno.rifqi.resepnyaindonesia.UI;

;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import net.renotekno.rifqi.resepnyaindonesia.Model.Recipes;
import net.renotekno.rifqi.resepnyaindonesia.R;

public class MainActivity extends AppCompatActivity implements FragmentList.ListTap{

    public static final String ITEM_INDEX = "item_index";
    public static final String ITEM_LIST = "item_list";
    public static final String VIEW_PAGER = "view_pager";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentList savedFragment = (FragmentList) getSupportFragmentManager().findFragmentByTag(ITEM_LIST);
        if(savedFragment == null) {
            FragmentList fragmentList = new FragmentList();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.placeholder, fragmentList, ITEM_LIST);
            transaction.commit();
        }
    }

    @Override
    public void OnListItemTapped(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(ITEM_INDEX, position);
        ViewPagerFragment pager = new ViewPagerFragment();
        pager.setArguments(bundle);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.placeholder, pager, VIEW_PAGER);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
