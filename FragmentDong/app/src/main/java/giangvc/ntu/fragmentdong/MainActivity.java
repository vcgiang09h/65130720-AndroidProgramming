package giangvc.ntu.fragmentdong;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy đối tượng FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Bắt đầu transaction và thêm các Fragment động vào View tĩnh
        fragmentManager.beginTransaction()
                .add(R.id.frame_content_holder, new FragmentContent())
                .add(R.id.frame_footer_holder, new FragmentFooter())
                .commit();
    }
}