package ntu.edu.tuychinhlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MonAn> danhSachMonAn;

    public MonAnAdapter(Context context, ArrayList<MonAn> danhSachMonAn) {
        this.context = context;
        this.danhSachMonAn = danhSachMonAn;
    }

    @Override
    public int getCount() {
        return danhSachMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return danhSachMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_mon_an, null);
        }

        // Tìm kiếm các điều khiển
        TextView tvTenMonAn = view.findViewById(R.id.tvTenMonAn);
        TextView tvDonGia = view.findViewById(R.id.tvDonGia);
        TextView tvMoTa = view.findViewById(R.id.tvMoTa);
        ImageView imgAnhDaiDien = view.findViewById(R.id.imgAnhDaiDien);

        // Gán dữ liệu lên giao diện
        MonAn monAnHienTai = danhSachMonAn.get(i);
        tvTenMonAn.setText(monAnHienTai.getTenMonAn());
        tvDonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        tvMoTa.setText(monAnHienTai.getMoTa());
        imgAnhDaiDien.setImageResource(monAnHienTai.getIdAnhMinhHoa());

        return view;
    }
}