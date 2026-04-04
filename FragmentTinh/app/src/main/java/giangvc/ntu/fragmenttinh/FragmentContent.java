package giangvc.ntu.fragmenttinh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class FragmentContent extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Gắn giao diện fragment_content vào Fragment [7]
        return inflater.inflate(R.layout.fragment_content, container, false);
    }
}