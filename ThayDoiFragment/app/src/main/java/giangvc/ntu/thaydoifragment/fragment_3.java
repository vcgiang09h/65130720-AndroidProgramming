package giangvc.ntu.thaydoifragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_3 extends Fragment {

    public fragment_3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Nạp file layout tương ứng cho fragment 3
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
}