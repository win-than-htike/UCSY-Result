package xyz.winthan.ucsyresult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Win Than on 11/4/2016.
 */
public interface ExamApiInterface {

    @GET("/api/v1/q?")
    Call<List<ExamResult>> getExamResult(
            @Query("roll_no") String rollNo,
            @Query("year") String year);


}
