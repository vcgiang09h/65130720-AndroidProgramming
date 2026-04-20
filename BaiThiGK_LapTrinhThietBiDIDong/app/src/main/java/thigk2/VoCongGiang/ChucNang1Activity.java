package thigk2.VoCongGiang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ChucNang1Activity extends AppCompatActivity {

    EditText edtChieuDai, edtChieuRong;
    Button btnTinhToan;
    TextView tvChuVi, tvDienTich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang1);

        edtChieuDai = findViewById(R.id.edtChieuDai);
        edtChieuRong = findViewById(R.id.edtChieuRong);
        btnTinhToan = findViewById(R.id.btnTinhToan);
        tvChuVi = findViewById(R.id.tvChuVi);
        tvDienTich = findViewById(R.id.tvDienTich);

        btnTinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strDai = edtChieuDai.getText().toString().trim();
                String strRong = edtChieuRong.getText().toString().trim();

                if (strDai.isEmpty() || strRong.isEmpty()) {
                    Toast.makeText(ChucNang1Activity.this, "Vui lòng nhập đầy đủ chiều dài và chiều rộng!", Toast.LENGTH_SHORT).show();
                    return; // Dừng lạ
                }

                double chieuDai = Double.parseDouble(strDai);
                double chieuRong = Double.parseDouble(strRong);

                double chuVi = (chieuDai + chieuRong) * 2;
                double dienTich = chieuDai * chieuRong;

                // Hiển thị kết quả lên màn hình
                tvChuVi.setText("Chu vi: " + chuVi + " m");
                tvDienTich.setText("Diện tích: " + dienTich + " m²");
            }
        });
    }

    // Hàm xử lý nút Quay Lại (đã được gọi sẵn bằng android:onClick bên file XML)
    public void quayLaiTrangChu(View view) {
        finish(); // Đóng Activity hiện tại để quay về MainActivity
    }
}