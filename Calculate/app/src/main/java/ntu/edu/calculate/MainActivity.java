package ntu.edu.calculate;

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
        setContentView(R.layout.activity_main);
    }
    public void XuLyCong(View view) {

        // Tìm thành phần điều khiển trên tệp XML, mapping sang java
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKetQua = findViewById(R.id.edtKQ);

        // Lấy dữ liệu về ở điều khiển số a
        String strA = editTextSoA.getText().toString();

        // Lấy dữ liệu về ở điều khiển số b
        String strB = editTextSoB.getText().toString();

        // Chuyển dữ liệu sang dạng số
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);

        // Tính toán theo yêu cầu
        int tong = so_A + so_B;

        String strTong = String.valueOf(tong); // chuyển sang dạng chuỗi

        // Hiển thị màn hình
        editTextKetQua.setText(strTong);
    }
}