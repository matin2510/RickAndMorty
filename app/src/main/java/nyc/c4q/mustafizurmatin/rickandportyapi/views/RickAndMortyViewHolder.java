package nyc.c4q.mustafizurmatin.rickandportyapi.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.mustafizurmatin.rickandportyapi.R;
import nyc.c4q.mustafizurmatin.rickandportyapi.models.ResultsBean;

/**
 * Created by c4q on 3/16/18.
 */

public class RickAndMortyViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private ImageView imageView;


    public RickAndMortyViewHolder(View itemView) {
        super(itemView);
        textView= itemView.findViewById(R.id.rick_name);
        imageView= itemView.findViewById(R.id.rick_image);

    }

    public void onBind(ResultsBean resultsBean) {
        textView.setText(resultsBean.getName());
        Picasso.with(itemView.getContext()).load( resultsBean.getImage())
                .into(imageView);
    }
}
