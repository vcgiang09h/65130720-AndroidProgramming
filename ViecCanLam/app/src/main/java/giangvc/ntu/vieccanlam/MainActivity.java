package giangvc.ntu.vieccanlam;

import android.content.Intent;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

        // FAB - mở màn hình thêm việc
        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(v -> {
            startActivity(new Intent(this, ThemTaskActivity.class));
        });

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

            // Đọc dữ liệu từ Firebase
            for (DataSnapshot obj : snapshot.getChildren()) {

                TASKS tasks = obj.getValue(TASKS.class);

                if (tasks != null) {
                    lstVCL.add(tasks);
                }
            }

            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
}