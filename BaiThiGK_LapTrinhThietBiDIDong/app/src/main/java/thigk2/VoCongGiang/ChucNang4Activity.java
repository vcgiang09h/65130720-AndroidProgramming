package thigk2.VoCongGiang;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ChucNang4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang4);
    }
    public void quayLaiTrangChu(View view) {
        finish();
    }
}