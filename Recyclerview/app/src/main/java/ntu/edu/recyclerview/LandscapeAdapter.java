package ntu.edu.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ItemLandHolder> {

    Context context; // [13]
    ArrayList<Landscape> listData; // [13]

    // Hàm khởi tạo [13]
    public LandscapeAdapter(Context context, ArrayList<Landscape> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Bơm (inflate) layout item_land vào [14, 15]
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_land, parent, false);
        return new ItemLandHolder(view); // [16]
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lấy đối tượng hiển thị [16]
        Landscape landscape = listData.get(position); // [17]

        // Đặt dữ liệu cho TextView [18]
        holder.tvCaption.setText(landscape.getCaption());

        // Đặt dữ liệu cho ImageView bằng cách lấy ID dựa vào tên file ảnh trong mipmap [11, 12, 18]
        String packageName = holder.itemView.getContext().getPackageName();
        int imageId = holder.itemView.getResources().getIdentifier(
                landscape.getImageFileName(), "mipmap", packageName); // [12]
        holder.ivLandscape.setImageResource(imageId); // [19]
    }

    @Override
    public int getItemCount() {
        return listData.size(); // [20]
    }

    // Lớp ViewHolder [9, 10]
    class ItemLandHolder extends RecyclerView.ViewHolder {
        TextView tvCaption;
        ImageView ivLandscape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            // Tìm kiếm các điều khiển theo ID [21]
            tvCaption = itemView.findViewById(R.id.text_view_caption);
            ivLandscape = itemView.findViewById(R.id.im_view_lan);
        }
    }
}