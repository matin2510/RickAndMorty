package nyc.c4q.mustafizurmatin.rickandportyapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.mustafizurmatin.rickandportyapi.R;
import nyc.c4q.mustafizurmatin.rickandportyapi.models.ResultsBean;
import nyc.c4q.mustafizurmatin.rickandportyapi.views.RickAndMortyViewHolder;

/**
 * Created by c4q on 3/16/18.
 */

public class RickAndMortyAdapter extends RecyclerView.Adapter<RickAndMortyViewHolder> {

    private List<ResultsBean> resultsBeanList;

    public RickAndMortyAdapter(List<ResultsBean> resultsBeanList) {
        this.resultsBeanList = resultsBeanList;
    }

    @Override
    public RickAndMortyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new RickAndMortyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RickAndMortyViewHolder holder, int position) {
        holder.onBind(resultsBeanList.get(position));

    }

    @Override
    public int getItemCount() {
        return resultsBeanList.size();
    }
}
