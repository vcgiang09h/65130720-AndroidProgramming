package giangvc.ntu.thaydoifragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_1 extends Fragment {

    public fragment_1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Nạp file layout của fragment [9]
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
}