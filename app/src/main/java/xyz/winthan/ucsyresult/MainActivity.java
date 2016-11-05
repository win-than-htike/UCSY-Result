package xyz.winthan.ucsyresult;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    private EditText etRowNo, etYear;
    private CheckBox cbExternal;
    private Button btnSearch;
    private ProgressDialog pDialog;
    String rollNoText = null;
    String yearText = null;
    String result = null;
    private TextView tvRollNo,tvYear,tvMajor,tvName;
    private AlertDialog dialog;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etRowNo = (EditText) findViewById(R.id.et_roll_no);
        etYear = (EditText) findViewById(R.id.et_year);
        btnSearch = (Button)findViewById(R.id.btn_search);
        pDialog = new ProgressDialog(this);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fetchResult(etRowNo.getText().toString(),etYear.getText().toString());
                builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_layout,null);
                builder.setView(dialogView);

                tvRollNo = (TextView)dialogView.findViewById(R.id.tv_rollno);
                tvYear = (TextView)dialogView.findViewById(R.id.textview_year);
                tvMajor = (TextView)dialogView.findViewById(R.id.tv_major);
                tvName = (TextView)dialogView.findViewById(R.id.tv_student_name);

                fetchResult(etRowNo.getText().toString(),etYear.getText().toString());

                dialog = builder.show();

            }
        });

        etYear.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (etYear.getText().length() < 1){
                    etYear.setError("Enter Year");
                }
            }
        });

        etRowNo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (etRowNo.getText().length() < 1){
                    etRowNo.setError("Enter Row Number");
                }
            }
        });


    }

    public void fetchResult(String rollNo, String year){

        pDialog.setMessage("Looking For Result...");
        pDialog.show();

        if (rollNo.isEmpty() && year.isEmpty()){
            pDialog.hide();

        }else {

            ExamApiInterface api = ExamClient.getClient().create(ExamApiInterface.class);
            Call<List<ExamResult>> call = api.getExamResult(rollNo,year);
            call.enqueue(new Callback<List<ExamResult>>() {
                @Override
                public void onResponse(Call<List<ExamResult>> call, Response<List<ExamResult>> response) {
                    pDialog.hide();

                    if (response.body().size() == 0){
                        tvRollNo.setText("Exam Fail");

                    }else {

                        ExamResult list = response.body().get(0);

                        switch (list.getYear()){
                            case "1":
                                tvYear.setText("First Year");
                                break;

                            case "2":
                                tvYear.setText("Second Year");
                                break;

                            case "3":
                                tvYear.setText("Third Year");
                                break;

                            case "4":
                                tvYear.setText("Fourth Year");
                                break;

                            case "5":
                                tvYear.setText("Master Year");
                                break;
                        }

                        tvName.setText(list.getName());

                        tvRollNo.setText(list.getRollNo());

                        if (list.getMajor().isEmpty()){
                            tvMajor.setText("null");
                        }else {
                            tvMajor.setText(list.getMajor());
                        }

                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<List<ExamResult>> call, Throwable t) {
                    pDialog.hide();
                    Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
