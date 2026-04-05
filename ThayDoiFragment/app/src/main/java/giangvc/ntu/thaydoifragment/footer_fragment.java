package giangvc.ntu.thaydoifragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class footer_fragment extends Fragment {

    public footer_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Cất view vào một biến v thay vì return ngay [5]
        View v = inflater.inflate(R.layout.fragment_footer, container, false);

        // Tìm kiếm FragmentManager [5]
        FragmentManager fragmentManager = getParentFragmentManager();

        // Tìm các nút bấm theo ID [5]
        Button b1 = v.findViewById(R.id.button1);
        Button b2 = v.findViewById(R.id.button2);
        Button b3 = v.findViewById(R.id.button3);

        // Lắng nghe sự kiện cho nút 1 và sử dụng replace() để thay thế fragment [6]
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.view_content, new fragment_1())
                        .commit();
            }
        });

        // Lắng nghe sự kiện cho nút 2 [6]
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.view_content, new fragment_2())
                        .commit();
            }
        });

        // Lắng nghe sự kiện cho nút 3 [6]
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.view_content, new fragment_3())
                        .commit();
            }
        });

        // Trả về view sau khi thiết lập xong [5]
        return v;
    }
}