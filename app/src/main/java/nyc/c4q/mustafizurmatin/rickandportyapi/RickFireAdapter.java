package nyc.c4q.mustafizurmatin.rickandportyapi;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

import nyc.c4q.mustafizurmatin.rickandportyapi.models.CommentModel;
import nyc.c4q.mustafizurmatin.rickandportyapi.views.FireBaseViewHolder;

/**
 * Created by c4q on 6/3/18.
 */

public class RickFireAdapter extends FirebaseRecyclerAdapter<CommentModel,FireBaseViewHolder> {




    public RickFireAdapter(Class<CommentModel> modelClass, int modelLayout, Class<FireBaseViewHolder> viewHolderClass, DatabaseReference ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(FireBaseViewHolder viewHolder, CommentModel model, int position) {
        viewHolder.onBind(model);

    }
}
