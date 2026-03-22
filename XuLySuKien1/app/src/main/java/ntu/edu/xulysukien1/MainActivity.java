package ntu.edu.xulysukien1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. Khai báo biến toàn cục (Lần này phải khai báo thêm Button để gọi trong code)
    EditText editTextSo1, editTextSo2, editTextKQ;
    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Gọi hàm ánh xạ id
        TimDieuKhien();

        // 3. Gắn bộ lắng nghe sự kiện ẩn danh cho từng nút
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_CONG(); // Gọi hàm xử lý cộng
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_TRU(); // Gọi hàm xử lý trừ
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_NHAN(); // Gọi hàm xử lý nhân
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_CHIA(); // Gọi hàm xử lý chia
            }
        });
    }

    // Hàm ánh xạ ID từ file XML sang Java
    void TimDieuKhien() {
        // Ánh xạ các ô nhập liệu
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKQ = findViewById(R.id.edtKetQua);

        // Ánh xạ các nút bấm (ID lấy từ file XML lúc nãy)
        btnCong = findViewById(R.id.btnPlus);
        btnTru = findViewById(R.id.btnMinus);
        btnNhan = findViewById(R.id.btnMulti);
        btnChia = findViewById(R.id.btnDivide);
    }

    // ================= CÁC HÀM TÍNH TOÁN =================
    // Chú ý: Các hàm này không còn tham số (View view) như cách cũ nữa

    void XULY_CONG() {
        // Lấy dữ liệu
        String so1 = editTextSo1.getText().toString().trim();
        String so2 = editTextSo2.getText().toString().trim();

        // Kiểm tra chống lỗi rỗng (Mình vẫn giữ lại vì nó rất cần thiết)
        if (so1.isEmpty() || so2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Ép kiểu float như trong video
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);

        // Tính toán và hiển thị
        float tong = num1 + num2;
        editTextKQ.setText(String.valueOf(tong));
    }

    void XULY_TRU() {
        String so1 = editTextSo1.getText().toString().trim();
        String so2 = editTextSo2.getText().toString().trim();

        if (so1.isEmpty() || so2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);

        float hieu = num1 - num2;
        editTextKQ.setText(String.valueOf(hieu));
    }

    void XULY_NHAN() {
        String so1 = editTextSo1.getText().toString().trim();
        String so2 = editTextSo2.getText().toString().trim();

        if (so1.isEmpty() || so2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);

        float tich = num1 * num2;
        editTextKQ.setText(String.valueOf(tich));
    }

    void XULY_CHIA() {
        String so1 = editTextSo1.getText().toString().trim();
        String so2 = editTextSo2.getText().toString().trim();

        if (so1.isEmpty() || so2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);

        if (num2 == 0) {
            Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
            editTextKQ.setText("Lỗi");
            return;
        }

        float thuong = num1 / num2;
        editTextKQ.setText(String.valueOf(thuong));
    }
}