package nyc.c4q.mustafizurmatin.rickandportyapi;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import nyc.c4q.mustafizurmatin.rickandportyapi.models.CommentModel;
import nyc.c4q.mustafizurmatin.rickandportyapi.models.ResultsBean;
import nyc.c4q.mustafizurmatin.rickandportyapi.views.FireBaseViewHolder;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";
    ImageView pokeminDetailImage;
    TextView pokemonDetailText;
    DatabaseReference firebaseDatabase;
    RecyclerView firbaseRV;
    Button commentButton;
    ResultsBean cardsBean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_details);

        Log.d(TAG, "onCreate: ran");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
     fab.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View view) {

             FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
             ft.replace(R.id.fragment_container, new PostFragment());
             ft.commit();
             Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     .setAction("Action", null).show();
         }
       });*/
        pokeminDetailImage = findViewById(R.id.pokemon_detail);
        pokemonDetailText = findViewById(R.id.pokemon_description);
        commentButton = findViewById(R.id.comment_button);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostFragment postFragment = new PostFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Comment",cardsBean.getName());
                postFragment.setArguments(bundle);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, postFragment);
                ft.commit();

            }
        });


        if (getIntent().getStringExtra("Pokemon") != null) {
            String cardbeanJson = getIntent().getStringExtra("Pokemon");
            cardsBean = new Gson().fromJson(cardbeanJson, ResultsBean.class);
            Log.d(TAG, "onCreate: intent ran");
            Picasso.with(this)
                    .load(cardsBean.getImage()).resize(200, 200)
                    .into(pokeminDetailImage);

            pokemonDetailText.setText(cardsBean.getName());


        }
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        firbaseRV = findViewById(R.id.recycler_view_comments);
        RickFireAdapter rmAdapter = new RickFireAdapter(
                CommentModel.class,
                R.layout.comment_itemview,
                FireBaseViewHolder.class,
                firebaseDatabase.child("Comments").child(cardsBean.getName()));
        firbaseRV.setLayoutManager(new LinearLayoutManager(DetailsActivity.this));
        firbaseRV.setAdapter(rmAdapter);



    }

}


