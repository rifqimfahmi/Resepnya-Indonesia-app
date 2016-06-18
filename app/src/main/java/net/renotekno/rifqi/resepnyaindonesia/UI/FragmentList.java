package net.renotekno.rifqi.resepnyaindonesia.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.renotekno.rifqi.resepnyaindonesia.Adapter.ListAdapter;
import net.renotekno.rifqi.resepnyaindonesia.R;

public class FragmentList extends Fragment {
    RecyclerView recyclerView;


    public interface ListTap {
        void OnListItemTapped(int position);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListTap listener = (ListTap) getActivity();

        //recyclerview here
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}
