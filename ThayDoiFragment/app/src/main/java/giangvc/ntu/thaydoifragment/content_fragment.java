package giangvc.ntu.thaydoifragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class content_fragment extends Fragment {

    public content_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Nạp file layout tương ứng cho content fragment
        // (Đảm bảo bạn đã tạo file xml tên là fragment_content.xml hoặc content_fragment.xml)
        return inflater.inflate(R.layout.fragment_content, container, false);
    }
}