package net.renotekno.rifqi.resepnyaindonesia.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.renotekno.rifqi.resepnyaindonesia.Model.Recipes;
import net.renotekno.rifqi.resepnyaindonesia.R;
import net.renotekno.rifqi.resepnyaindonesia.UI.FragmentList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final FragmentList.ListTap mListener;

    public ListAdapter(FragmentList.ListTap listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mDishImage;
        private TextView mDishTitle;
        private int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            mDishImage = (ImageView) itemView.findViewById(R.id.dishImage);
            mDishTitle = (TextView) itemView.findViewById(R.id.dishTitle);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mPosition =position;
            mDishImage.setImageResource(Recipes.resourceIds[position]);
            mDishTitle.setText(Recipes.names[position]);
        }

        @Override
        public void onClick(View v) {
            mListener.OnListItemTapped(mPosition);
        }
    }
}
