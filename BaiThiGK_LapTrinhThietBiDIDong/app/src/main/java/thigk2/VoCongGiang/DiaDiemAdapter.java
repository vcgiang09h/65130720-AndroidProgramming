package thigk2.VoCongGiang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DiaDiemAdapter extends RecyclerView.Adapter<DiaDiemAdapter.DiaDiemViewHolder> {

    private Context context;
    private ArrayList<DiaDiem> listData;

    public DiaDiemAdapter(Context context, ArrayList<DiaDiem> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public DiaDiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Bơm layout item_du_lich vào
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_du_lich, parent, false);
        return new DiaDiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaDiemViewHolder holder, int position) {
        DiaDiem diaDiem = listData.get(position);

        // Gán text
        holder.tvTenDiaDiem.setText(diaDiem.getTenDiaDiem());
        holder.tvDiaChi.setText(diaDiem.getDiaChi());

        String packageName = holder.itemView.getContext().getPackageName();
        int imageId = holder.itemView.getResources().getIdentifier(
                diaDiem.getTenAnh(), "mipmap", packageName);

        if (imageId != 0) {
            holder.imgAnh.setImageResource(imageId);
        } else {
            holder.imgAnh.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    // Lớp nội ViewHolder
    class DiaDiemViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAnh;
        TextView tvTenDiaDiem, tvDiaChi;

        public DiaDiemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnh = itemView.findViewById(R.id.imgAnh);
            tvTenDiaDiem = itemView.findViewById(R.id.tvTenDiaDiem);
            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
        }
    }
}