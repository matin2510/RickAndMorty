package nyc.c4q.mustafizurmatin.rickandportyapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.mustafizurmatin.rickandportyapi.adapters.RickAndMortyAdapter;
import nyc.c4q.mustafizurmatin.rickandportyapi.models.ResultsBean;
import nyc.c4q.mustafizurmatin.rickandportyapi.models.RickAndMortyResponse;
import nyc.c4q.mustafizurmatin.rickandportyapi.networking.RickService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";
    private static final String TAG = "pineapples";


    private RecyclerView rickRV;
    private RickAndMortyAdapter rickAdapter;

    private List<ResultsBean> resultsBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rickRV = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rickRV.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RickService rickService  = retrofit.create(RickService.class);
        Call<RickAndMortyResponse> call = rickService.getCharacter();
        call.enqueue(new Callback<RickAndMortyResponse>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse> call, Response<RickAndMortyResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: ");
                    RickAndMortyResponse rickAndMortyResponse = response.body();
                    resultsBeanList = rickAndMortyResponse.getResults();
                    Log.d(TAG, "onResponse: ");
                    rickAdapter = new RickAndMortyAdapter(resultsBeanList);
                    rickRV.setAdapter(rickAdapter);

                }else {
                    Log.d(TAG, "on Response Error: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getMessage());
                t.printStackTrace();

            }
        });
    }
}
