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
    public int getCount() { return danhSachMonAn.size(); }

    @Override
    public Object getItem(int i) { return danhSachMonAn.get(i); }

    @Override
    public long getItemId(int i) { return i; }

    // Tạo lớp ViewHolder để lưu trữ các view
    private static class ViewHolder {
        TextView tvTenMonAn;
        TextView tvDonGia;
        TextView tvMoTa;
        ImageView imgAnhDaiDien;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_mon_an, null);

            holder = new ViewHolder();
            // Chỉ gọi findViewById 1 lần duy nhất khi tạo mới View
            holder.tvTenMonAn = view.findViewById(R.id.tvTenMonAn);
            holder.tvDonGia = view.findViewById(R.id.tvDonGia);
            holder.tvMoTa = view.findViewById(R.id.tvMoTa);
            holder.imgAnhDaiDien = view.findViewById(R.id.imgAnhDaiDien);

            // Gắn ViewHolder vào View
            view.setTag(holder);
        } else {
            // Tái sử dụng ViewHolder nếu View đã tồn tại
            holder = (ViewHolder) view.getTag();
        }

        // Gán dữ liệu lên giao diện
        MonAn monAnHienTai = danhSachMonAn.get(i);
        holder.tvTenMonAn.setText(monAnHienTai.getTenMonAn());
        // Có thể thêm định dạng tiền tệ ở đây (VD: 25,000 đ) thay vì ép kiểu double đơn thuần
        holder.tvDonGia.setText(String.format("%,.0f đ", monAnHienTai.getDonGia()));
        holder.tvMoTa.setText(monAnHienTai.getMoTa());
        holder.imgAnhDaiDien.setImageResource(monAnHienTai.getIdAnhMinhHoa());

        return view;
    }
}