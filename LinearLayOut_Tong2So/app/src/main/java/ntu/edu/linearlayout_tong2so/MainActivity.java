package ntu.edu.linearlayout_tong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. Khai báo các biến toàn cục
    EditText edtSo1, edtSo2, edtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }

    void TimDieuKhien() {
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        edtKetQua = findViewById(R.id.edtKetQua);
    }

    // ================= XỬ LÝ CỘNG =================
    public void XuLyCong(View view) {
        String sa = edtSo1.getText().toString().trim();
        String sb = edtSo2.getText().toString().trim();

        // Kiểm tra người dùng có nhập đủ 2 số chưa
        if (sa.isEmpty() || sb.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return; // Dừng hàm lại, không chạy code bên dưới nữa
        }

        // Tái sử dụng luôn chuỗi sa, sb ở trên để chuyển thành số
        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);

        double tong = a + b;
        edtKetQua.setText(String.valueOf(tong));
    }

    // ================= XỬ LÝ TRỪ =================
    public void XuLyTru(View view) {
        String sa = edtSo1.getText().toString().trim();
        String sb = edtSo2.getText().toString().trim();

        if (sa.isEmpty() || sb.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);

        double hieu = a - b;
        edtKetQua.setText(String.valueOf(hieu));
    }

    // ================= XỬ LÝ NHÂN =================
    public void XuLyNhan(View view) {
        String sa = edtSo1.getText().toString().trim();
        String sb = edtSo2.getText().toString().trim();

        if (sa.isEmpty() || sb.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);

        double tich = a * b;
        edtKetQua.setText(String.valueOf(tich));
    }

    // ================= XỬ LÝ CHIA =================
    public void XuLyChia(View view) {
        String sa = edtSo1.getText().toString().trim();
        String sb = edtSo2.getText().toString().trim();

        if (sa.isEmpty() || sb.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);

        if (b == 0) {
            Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
            edtKetQua.setText("Lỗi!");
            return;
        }

        double thuong = a / b;
        edtKetQua.setText(String.valueOf(thuong));
    }
}