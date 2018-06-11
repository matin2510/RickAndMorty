package nyc.c4q.mustafizurmatin.rickandportyapi.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import nyc.c4q.mustafizurmatin.rickandportyapi.DetailsActivity;
import nyc.c4q.mustafizurmatin.rickandportyapi.R;
import nyc.c4q.mustafizurmatin.rickandportyapi.models.ResultsBean;
import nyc.c4q.mustafizurmatin.rickandportyapi.views.RickAndMortyViewHolder;

/**
 * Created by c4q on 3/16/18.
 */

public class RickAndMortyAdapter extends RecyclerView.Adapter<RickAndMortyViewHolder> {

    private List<ResultsBean> resultsBeanList;
    private static final String TAG = "RickAndMortyAdapter";

    public RickAndMortyAdapter(List<ResultsBean> resultsBeanList) {
        this.resultsBeanList = resultsBeanList;
    }

    @Override
    public RickAndMortyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new RickAndMortyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RickAndMortyViewHolder holder, final int position) {
        holder.onBind(resultsBeanList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ran");
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                String cardbeanJson = new Gson().toJson(resultsBeanList.get(position));
                intent.putExtra("Pokemon", cardbeanJson);
                // Log.d(TAG, "onClick: " + cardsBean.getArtist());
                holder.itemView.getContext().startActivity(intent);




                Toast.makeText(holder.itemView.getContext(), resultsBeanList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultsBeanList.size();
    }
}
