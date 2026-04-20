package thigk2.VoCongGiang;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChucNang3Activity extends AppCompatActivity {

    RecyclerView rvDuLich;
    ArrayList<DiaDiem> listDiaDiem;
    DiaDiemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang3);

        rvDuLich = findViewById(R.id.rvDuLich);

        rvDuLich.setLayoutManager(new LinearLayoutManager(this));

        listDiaDiem = new ArrayList<>();
        // Tham số 1: Tên file ảnh (không có .jpg/png) | Tham số 2: Tên địa điểm | Tham số 3: Địa chỉ
        listDiaDiem.add(new DiaDiem("thap_ba", "Tháp Bà Ponagar", "Đường 2/4, Vĩnh Phước, Nha Trang"));
        listDiaDiem.add(new DiaDiem("vinpearl", "Vinpearl Land", "Đảo Hòn Tre, Vĩnh Nguyên, Nha Trang"));
        listDiaDiem.add(new DiaDiem("hon_chong", "Hòn Chồng", "Khóm Hòn Chồng, Vĩnh Phước, Nha Trang"));
        listDiaDiem.add(new DiaDiem("chua_long_son", "Chùa Long Sơn", "20 Đường 23/10, Phương sơn, Nha Trang"));
        listDiaDiem.add(new DiaDiem("nha_tho_da", "Nhà thờ Núi (Nhà thờ Đá)", "1 Thái Nguyên, Phước Tân, Nha Trang"));

        adapter = new DiaDiemAdapter(this, listDiaDiem);
        rvDuLich.setAdapter(adapter);
    }

    public void quayLaiTrangChu(View view) {
        finish();
    }
}