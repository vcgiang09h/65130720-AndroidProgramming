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
        danhSachMonAn.add(new MonAn(
                "Cơm tấm sườn",
                25000,
                "Cơm tấm ăn kèm sườn nướng thơm, bì và mỡ hành, chan nước mắm đậm đà.",
                R.drawable.cts));

        danhSachMonAn.add(new MonAn(
                "Cơm sườn trứng",
                30000,
                "Cơm tấm với sườn nướng và trứng ốp la béo ngậy, ăn kèm dưa chua.",
                R.drawable.cst));

        danhSachMonAn.add(new MonAn(
                "Sườn bì chả",
                32000,
                "Món cơm gồm sườn nướng, bì heo và chả trứng hấp, hương vị truyền thống.",
                R.drawable.sb));

        danhSachMonAn.add(new MonAn(
                "Cơm tấm đặc biệt",
                35000,
                "Cơm tấm đầy đủ sườn, bì, chả, trứng và nhiều topping hấp dẫn.",
                R.drawable.db));

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
