package com.cyberwith.hometask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cyberwith.hometask.Adapter.ReportListAdapter;
import com.cyberwith.hometask.models.Report;
import com.cyberwith.hometask.models.ReportListModel;
import com.cyberwith.hometask.network.MyApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "getData";
    private List<ReportListModel> reportListModels;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reportListModels = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData(){
        Call<Report> reportCall = MyApi.getApiData().getReport();
        reportCall.enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {
                Report report = response.body();
                Log.i(TAG, "onResponse: "+ report.getErrorReport());

                reportListModels = report.getReportListModel();
                Log.i(TAG, "onResponse: "+reportListModels.get(0).getId());
                recyclerView.setAdapter(new ReportListAdapter(MainActivity.this, reportListModels));
            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {
                Toast.makeText(getApplicationContext()," Please check your internet", Toast.LENGTH_LONG).show();
            }
        });
    }
}