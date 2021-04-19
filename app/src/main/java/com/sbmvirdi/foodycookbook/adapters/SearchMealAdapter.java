package com.sbmvirdi.foodycookbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sbmvirdi.foodycookbook.databinding.SearchMealRowBinding;
import com.sbmvirdi.foodycookbook.interfaces.LoadData;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;

import java.util.List;

public class SearchMealAdapter extends RecyclerView.Adapter<SearchMealAdapter.SearchMealViewHolder> {

    List<Meal> mList;
    Context mContext;
    LoadData<Meal> loadData;

    public SearchMealAdapter(List<Meal> mList, Context mContext, LoadData<Meal> loadData) {
        this.mList = mList;
        this.mContext = mContext;
        this.loadData = loadData;
    }

    @NonNull
    @Override
    public SearchMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchMealViewHolder(SearchMealRowBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchMealViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class SearchMealViewHolder extends RecyclerView.ViewHolder {
        Meal meal;
        SearchMealRowBinding searchMealRowBinding;
        public SearchMealViewHolder(@NonNull SearchMealRowBinding searchMealRowBinding) {
            super(searchMealRowBinding.getRoot());
            this.searchMealRowBinding = searchMealRowBinding;
            searchMealRowBinding.getRoot().setOnClickListener(v->{
                loadData.onDataLoaded(meal);
            });
        }

        public void setData(Meal meal) {
            this.meal = meal;
            Glide.with(mContext).load(meal.getStrMealThumb()).into(searchMealRowBinding.strMealThumb);
            searchMealRowBinding.strMealName.setText(meal.getStrMeal());
            if (meal.getStrCategory()!=null) {
                searchMealRowBinding.strCategory.setText(meal.getStrCategory());
            }

            if (meal.getStrArea()!=null) {
                searchMealRowBinding.strArea.setText(meal.getStrArea());
            }
        }
    }
}
