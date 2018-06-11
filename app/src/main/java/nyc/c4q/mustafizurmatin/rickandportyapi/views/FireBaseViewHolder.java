package nyc.c4q.mustafizurmatin.rickandportyapi.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.mustafizurmatin.rickandportyapi.R;
import nyc.c4q.mustafizurmatin.rickandportyapi.models.CommentModel;

/**
 * Created by c4q on 6/3/18.
 */

public class FireBaseViewHolder extends RecyclerView.ViewHolder {
    ImageView userIcon;
    TextView timeStamp;
    TextView comments;


    public FireBaseViewHolder(View itemView) {
        super(itemView);
        userIcon = itemView.findViewById(R.id.user_icon);
        timeStamp = itemView.findViewById(R.id.time_stamp);
        comments = itemView.findViewById(R.id.comments);


    }

    public void onBind(CommentModel commentModel) {
        timeStamp.setText(commentModel.getTime());
        comments.setText(commentModel.getComments());


    }
}
