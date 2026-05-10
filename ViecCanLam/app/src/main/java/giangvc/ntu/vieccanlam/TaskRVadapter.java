package giangvc.ntu.vieccanlam;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRVadapter extends RecyclerView.Adapter<TaskRVadapter.TaskItemViewHolder> {
    List<TASKS> dataSource;

    public TaskRVadapter(List<TASKS> dataSource) {
        this.dataSource = dataSource;
    }
    //
    public class TaskItemViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTenVCL;
        TextView tvNgayHetHan;
        public int position;
        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTenVCL = itemView.findViewById(R.id.txtTenVCL);
            tvNgayHetHan = itemView.findViewById(R.id.txtDeadline);

        }

        @Override
        public void onClick(View v) {
            //Lay vi tri
            int vtClicked = getAdapterPosition();
            if (vtClicked == RecyclerView.NO_POSITION) return; // Tránh crash khi click quá nhanh hoặc item đã bị xóa
            
            //Luc o nguon du lieu
            TASKS taskClicked = dataSource.get(vtClicked);
            //Xu ly, vi du o day ta Toast
            Toast.makeText(v.getContext(), "Bạn vừa chọn việc " + taskClicked.getName(), Toast.LENGTH_LONG).show();
        }
    }


    @NonNull
    @Override
    public TaskItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item,parent, false);
        TaskItemViewHolder viewHolder = new TaskItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.position = position;
        TASKS task = dataSource.get(position);
        holder.tvTenVCL.setText(task.getName());
        holder.tvNgayHetHan.setText(task.getDate());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
