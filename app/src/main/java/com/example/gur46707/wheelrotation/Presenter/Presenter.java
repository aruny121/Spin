package com.example.gur46707.wheelrotation.Presenter;




import com.example.gur46707.wheelrotation.Constants;
import com.example.gur46707.wheelrotation.Model.User;
import com.example.gur46707.wheelrotation.Retrofit.ApiInterface;
import com.example.gur46707.wheelrotation.View.IDashboard;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements  IPresenter {
    IDashboard IDashboard;
    public Presenter(IDashboard dashboard) {
        this.IDashboard = dashboard;
        }

        @Override
        public void fetchSpeed() {
        Apifetch();
        }



    /**
     * author - Arun yadav
     * Date - 2/6/2019
     * desc - function to call api and get response
     */
    public void Apifetch(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        ApiInterface api = retrofit.create(ApiInterface.class);
        Call<List<User>> call = api.getSpeed();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> getSpeed = response.body();
                System.out.print("response is"+getSpeed);
                //null check for response
                    if(getSpeed != null && getSpeed.size() > 0 && getSpeed.get(0) != null)
                    {
                        if(getSpeed.get(0).getStatus().equalsIgnoreCase("success")){
                            IDashboard.onApiResult(getSpeed.get(0).getRandom(), Constants.SUCCESS_API);
                        }
                        else {
                            IDashboard.onApiResult(0,Constants.FAIL_API);
                            }
                    } else {
                        IDashboard.onApiResult(0,Constants.FAIL_API);
                        }
            }
                @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                    IDashboard.onApiResult(0,Constants.FAIL_API);
                    }
        });
    }
}
