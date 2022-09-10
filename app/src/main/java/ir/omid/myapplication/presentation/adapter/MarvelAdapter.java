package ir.omid.myapplication.presentation.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ir.omid.myapplication.R;
import ir.omid.myapplication.databinding.LayoutMyAdapterBinding;
import ir.omid.myapplication.model.dto.MarvelHeroDto;

public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.MarvelHero> {
    List<MarvelHeroDto> items;
    Actions actions;
    public MarvelAdapter(List<MarvelHeroDto> items,Actions actions) {
        this.actions = actions;
        this.items = items;
    }

    @NonNull
    @Override
    public MarvelHero onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        ViewDataBinding view = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.layout_my_adapter,parent, false);
        return new MarvelHero((LayoutMyAdapterBinding) view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarvelHero holder, int position) {
        holder.setInfo(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateAdapter(List<MarvelHeroDto> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class MarvelHero extends RecyclerView.ViewHolder {
        LayoutMyAdapterBinding binding;
        public MarvelHero(@NonNull LayoutMyAdapterBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void setInfo(MarvelHeroDto item) {
            binding.setHero(item);
            binding.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(itemView)
                    .load(item.imageUrl)
                    .into(binding.image);
            binding.setActions(actions);
        }
    }


    public interface Actions {
        void onClick(MarvelHeroDto item);
    }
}
