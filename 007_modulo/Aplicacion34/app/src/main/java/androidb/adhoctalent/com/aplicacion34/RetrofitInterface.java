package androidb.adhoctalent.com.aplicacion34;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    public static final String URL =
            "http://172.16.193.241:8080/IEEE_Webservice/webresources/";


    @GET("ws")
    Call<List<Personas>> getPersonas() ;

}
