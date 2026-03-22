package ntu.edu.linearlayout_tong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TimDieuKhien();
    }

    void TimDieuKhien() {
    }

    // ================= XỬ LÝ CỘNG =================
    public void XuLyCong(View v) {
        // B1. Lấy dữ liệu 2 số
        // B1.1 Tìm EditText số 1 và số 2
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText) findViewById(R.id.edtSo2);

        // B1.2 Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        // B1.3 Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);

        // B2. Tính toán
        float Tong = soA + soB;

        // B3. Hiện kết quả
        // B3.1 Tìm EditText kết quả
        EditText editTextKQ = (EditText) findViewById(R.id.edtKetQua);
        // B3.2 Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tong);
        // B3.3 Gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKQ);
    }

    // ================= XỬ LÝ TRỪ =================
    public void XuLyTru(View v) {
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText) findViewById(R.id.edtSo2);

        float soA = Float.parseFloat(editTextSo1.getText().toString());
        float soB = Float.parseFloat(editTextSo2.getText().toString());

        float Hieu = soA - soB;

        EditText editTextKQ = (EditText) findViewById(R.id.edtKetQua);
        editTextKQ.setText(String.valueOf(Hieu));
    }

    // ================= XỬ LÝ NHÂN =================
    public void XuLyNhan(View v) {
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText) findViewById(R.id.edtSo2);

        float soA = Float.parseFloat(editTextSo1.getText().toString());
        float soB = Float.parseFloat(editTextSo2.getText().toString());

        float Tich = soA * soB;

        EditText editTextKQ = (EditText) findViewById(R.id.edtKetQua);
        editTextKQ.setText(String.valueOf(Tich));
    }

    // ================= XỬ LÝ CHIA =================
    public void XuLyChia(View v) {
        // B1. Lấy dữ liệu 2 số
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText) findViewById(R.id.edtSo2);

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);

        // B2. Tính toán
        float Thuong = soA / soB;

        // B3. Hiện kết quả
        EditText editTextKQ = (EditText) findViewById(R.id.edtKetQua);
        String chuoiKQ = String.valueOf(Thuong);
        editTextKQ.setText(chuoiKQ);
    }
}