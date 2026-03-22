package ntu.edu.listview1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnChuyen;
    TextView txtKetQua;

    String[] dsQuocGia = {"Việt Nam", "Nhật Bản", "Hàn Quốc", "Mỹ", "Pháp", "Anh"};

    void getDieuKhien() {
        listView = findViewById(R.id.listView);
        btnChuyen = findViewById(R.id.btnChuyen);
        txtKetQua = findViewById(R.id.txt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDieuKhien();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsQuocGia);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                txtKetQua.setText("Quốc gia bạn chọn là: " + item);
                Toast.makeText(MainActivity.this, "Đã chọn: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CauthuActivity.class);
                startActivity(intent);
            }
        });
    }
}