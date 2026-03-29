package ntu.edu.tuychinhlv;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSachMonAn;
    ArrayList<MonAn> danhSachMonAn;
    MonAnAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo ListView và Danh sách
        lvDanhSachMonAn = findViewById(R.id.lvDanhSachMonAn);
        danhSachMonAn = new ArrayList<>();

        // Chuẩn bị dữ liệu mô phỏng
        danhSachMonAn.add(new MonAn("Cơm tấm sườn", 25000, "Mô tả cơm tấm sườn", R.drawable.cts));
        danhSachMonAn.add(new MonAn("Cơm sườn trứng", 30000, "Mô tả cơm sườn trứng", R.drawable.cst));
        danhSachMonAn.add(new MonAn("Sườn bì chả", 32000, "Mô tả sườn bì chả", R.drawable.sb));
        danhSachMonAn.add(new MonAn("Cơm tấm đặc biệt", 35000, "Mô tả cơm tấm đặc biệt", R.drawable.db));

        // Thiết lập Adapter
        adapter = new MonAnAdapter(this, danhSachMonAn);
        lvDanhSachMonAn.setAdapter(adapter);

        // Bắt sự kiện chọn trên ListView
        lvDanhSachMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MonAn monAnChon = danhSachMonAn.get(i);
                Toast.makeText(MainActivity.this, monAnChon.getTenMonAn(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}