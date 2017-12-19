package com.jackie.dragrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jackie.dragrecyclerview.databinding.ItemViewBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created on 12/12/2017.
 *
 * @author Jackie
 * @version 1.0
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> implements ItemTouchHelperAdapter {
    private static final String TAG = "Adapter";

    private List<Integer> data;
    private ItemTouchHelper helper;

    public Adapter(List<Integer> data) {
        this.data = data;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout
                .item_view, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.binding.setItem(data.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onItemMove(int from, int to) {
        Collections.swap(data, from, to);
        notifyItemMoved(from, to);
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ItemViewBinding binding;

        public Holder(final ItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
