package ntu.edu.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LandscapeAdapter adapter; // [20]
    ArrayList<Landscape> listData; // [22]
    RecyclerView recycleLand; // [22]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chuẩn bị dữ liệu [3, 22]
        listData = getDataForRecyclerView();

        // Tìm điều khiển RecyclerView [26]
        recycleLand = findViewById(R.id.recycle_land);

        // Tạo layout manager và quy định bố cục [26]
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycleLand.setLayoutManager(layoutManager);

        // Tạo adapter và gán vào RecyclerView [27]
        adapter = new LandscapeAdapter(this, listData);
        recycleLand.setAdapter(adapter);
    }

    // Hàm tạo dữ liệu Hardcode [3]
    private ArrayList<Landscape> getDataForRecyclerView() {
        ArrayList<Landscape> list = new ArrayList<>();
        // Truyền vào tên file ảnh tương ứng (lưu trong thư mục mipmap) và tên địa danh hiển thị [12, 23, 24, 28]
        list.add(new Landscape("hanoi", "Cột cờ Hà Nội"));
        list.add(new Landscape("eiffel", "Tháp Eiffel"));
        list.add(new Landscape("buckingham", "Cung điện Buckingham"));
        list.add(new Landscape("statue_of_liberty", "Tượng Nữ thần Tự do"));
        return list; // [24]
    }
}