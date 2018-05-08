package nyc.c4q.mustafizurmatin.rickandportyapi.networking;

import nyc.c4q.mustafizurmatin.rickandportyapi.models.RickAndMortyResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 3/16/18.
 */

public interface RickService {
    @GET("character")
    Call<RickAndMortyResponse> getCharacter();

}
