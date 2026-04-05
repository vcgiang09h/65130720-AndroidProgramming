package giangvc.ntu.thaydoifragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_2 extends Fragment {

    public fragment_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Nạp file layout tương ứng cho fragment 2
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}