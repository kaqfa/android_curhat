package info.fahri.aplikasicurhat.apiclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CurhatInterface {
    @GET("curhat/")
    Call<List<Curhat>> getCurhat();

    @FormUrlEncoded
    @POST("curhat/")
    Call<Curhat> postCurhat(@Field("nama")String nama, @Field("konten")String konten);

    @DELETE("curhat/")
    Call<Curhat> delCurhat(@Query("id") int id);
}
