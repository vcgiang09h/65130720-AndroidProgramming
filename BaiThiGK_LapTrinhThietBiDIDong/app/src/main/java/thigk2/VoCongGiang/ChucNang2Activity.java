package thigk2.VoCongGiang;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ChucNang2Activity extends AppCompatActivity {

    ListView lvThanhPho;
    String[] dsThanhPho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang2);

        lvThanhPho = findViewById(R.id.lvThanhPho);
        dsThanhPho = new String[]{
                "TP Đà Nẵng",
                "Tỉnh khánh Hòa",
                "TP. Huế",
                "TP. Hồ Chí Minh",
                "TP. Hà Nội",
                "Tỉnh Nghệ An",
                "Tỉnh Lâm Đồng",
                "TP. Hải Phòng",
                "TP. Cần Thơ",
                "Võ Công Giang"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsThanhPho
        );

        lvThanhPho.setAdapter(adapter);

        lvThanhPho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mucDuocChon = dsThanhPho[position];
                Toast.makeText(ChucNang2Activity.this, "Đang chọn: " + mucDuocChon, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void quayLaiTrangChu(View view) {
        finish();
    }
}