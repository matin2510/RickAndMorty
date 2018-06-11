package nyc.c4q.mustafizurmatin.rickandportyapi;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nyc.c4q.mustafizurmatin.rickandportyapi.models.CommentModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {
    EditText writePost;
    Button sendPost;
    DatabaseReference databaseReference;


    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        writePost = view.findViewById(R.id.write_comment);
        sendPost = view.findViewById(R.id.send_comment);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String name = bundle.getString("Comment");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Comments").child(name);
        sendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BLAH", "onClick: ran ");
                CommentModel commentModel = new CommentModel();
                commentModel.setComments(writePost.getText().toString());
                commentModel.setTime(String.valueOf(System.currentTimeMillis()));
                databaseReference.push().setValue(commentModel);
            }
        });

    }
}
