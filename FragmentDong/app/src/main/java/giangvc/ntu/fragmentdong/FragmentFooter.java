package giangvc.ntu.fragmentdong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class FragmentFooter extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Nạp giao diện cho footer [6, 7]
        return inflater.inflate(R.layout.fragment_footer, container, false);
    }
}