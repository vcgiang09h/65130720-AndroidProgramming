package ntu.edu.baith2_2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Đã tạm ẩn phần code EdgeToEdge tự động sinh ra để bạn dễ tập trung vào logic chính.
    }

    public void XuLyCong(View view) {
        // 1. Tìm các ô nhập liệu (Ánh xạ view)
        EditText edtA = findViewById(R.id.edtA);
        EditText edtB = findViewById(R.id.edtB);
        EditText edtKQ = findViewById(R.id.edtKQ);

        try {
            // 2. Lấy chữ người dùng nhập và chuyển luôn thành số nguyên (gộp bước)
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());

            // 3. Tính tổng và hiển thị ra màn hình
            int tong = a + b;
            edtKQ.setText(String.valueOf(tong));

        } catch (NumberFormatException e) {
            // Báo lỗi nếu người dùng không nhập gì hoặc nhập chữ
            Toast.makeText(this, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show();
            edtKQ.setText("Lỗi!");
        }
    }
}