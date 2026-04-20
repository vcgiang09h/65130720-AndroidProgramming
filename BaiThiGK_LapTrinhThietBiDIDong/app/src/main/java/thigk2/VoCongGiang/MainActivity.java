package thigk2.VoCongGiang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Các hàm xử lý sự kiện onClick được định nghĩa bên XML

    public void moChucNang1(View view) {
        Intent intent = new Intent(MainActivity.this, ChucNang1Activity.class);
        startActivity(intent);
    }

    public void moChucNang2(View view) {
        Intent intent = new Intent(MainActivity.this, ChucNang2Activity.class);
        startActivity(intent);
    }

    public void moChucNang3(View view) {
        Intent intent = new Intent(MainActivity.this, ChucNang3Activity.class);
        startActivity(intent);
    }

    public void moChucNang4(View view) {
        Intent intent = new Intent(MainActivity.this, ChucNang4Activity.class);
        startActivity(intent);
    }
}