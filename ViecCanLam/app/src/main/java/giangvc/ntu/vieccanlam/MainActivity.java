package giangvc.ntu.vieccanlam;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<TASKS> lstVCL;
    TaskRVadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom);

            return insets;
        });

        // Khởi tạo danh sách
        lstVCL = new ArrayList<>();

        // Tìm RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rcvVCL);

        // LayoutManager
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        // Divider
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        this,
                        DividerItemDecoration.VERTICAL
                )
        );

        // Adapter
        adapter = new TaskRVadapter(lstVCL);
        recyclerView.setAdapter(adapter);

        // Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference =
                database.getReference("TASKS");

        // Lắng nghe Firebase
        databaseReference.addValueEventListener(ngheFB);
    }

    // Listener Firebase
    ValueEventListener ngheFB = new ValueEventListener() {

        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

            lstVCL.clear();

            // Đọc dữ liệu từ Firebase - đọc thủ công từng trường để tránh lỗi ép kiểu
            for (DataSnapshot obj : snapshot.getChildren()) {
                try {
                    // Ưu tiên dùng getValue(TASKS.class)
                    TASKS tasks = obj.getValue(TASKS.class);

                    // Nếu thất bại hoặc trống, thử đọc thủ công từng trường
                    if (tasks == null || tasks.getName() == null) {
                        String name    = obj.child("name").getValue(String.class);
                        String date    = obj.child("date").getValue(String.class);
                        String message = obj.child("message").getValue(String.class);
                        Long   pri     = obj.child("priority").getValue(Long.class);

                        // Xóa dấu ngoặc kép thừa trong date nếu có (vd: ""10/05/2026"")
                        if (date != null) date = date.replace("\"", "");

                        tasks = new TASKS(
                            name    != null ? name    : "",
                            date    != null ? date    : "",
                            message != null ? message : "",
                            pri     != null ? pri     : 0L
                        );
                    }

                    lstVCL.add(tasks);

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Lỗi dữ liệu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            if (lstVCL.isEmpty()) {
                Toast.makeText(MainActivity.this, "Firebase trống hoặc đường dẫn sai! Node đang dùng: TASKS", Toast.LENGTH_LONG).show();
            }

            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(MainActivity.this, "Bị từ chối quyền truy cập hoặc lỗi Firebase: " + error.getMessage(), Toast.LENGTH_LONG).show();
        }
    };
}