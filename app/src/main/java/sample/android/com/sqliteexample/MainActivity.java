package sample.android.com.sqliteexample;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etDept, etNumber;
    private TextView tvShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etDept = findViewById(R.id.etDept);
        etNumber = findViewById(R.id.etNumber);
        tvShowData = findViewById(R.id.tvViewData);
    }


    public void saveData(View view) {

        String name = etName.getText().toString().trim();
        String dept = etDept.getText().toString().trim();
        String number = etNumber.getText().toString().trim();

        if (name.isEmpty()) {

            etName.setError("pls enter name");
            etName.requestFocus();
            return;
        }

        if (dept.isEmpty()) {

            etDept.setError("pls enter dept");
            etDept.requestFocus();
            return;
        }
        if (number.isEmpty()) {

            etNumber.setError("pls enter number");
            etNumber.requestFocus();
            return;
        }

        // All is okay

        MySqlite mySqlite = new MySqlite(this);

        long checker = mySqlite.insertData(name, dept, number);

        if (checker == -1) {
            Toast.makeText(this, "Failed to insert data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();
        }
    }

    public void viewData(View view) {

        Intent intent = new Intent(this, ListActivity.class);

        startActivity(intent);


    }
}
