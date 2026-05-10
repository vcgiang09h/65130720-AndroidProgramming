package giangvc.ntu.bonusfilestoreapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    String TAG = "FirestoreTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

        ghiDulieu();

        docDulieu();
    }

    private void ghiDulieu() {
        CollectionReference students = db.collection("students");

        Map<String, Object> sinhVien = new HashMap<>();
        sinhVien.put("hoTen", "Vo Cong Giang");
        sinhVien.put("mssv", "65130720");
        sinhVien.put("khoa", "Cong nghe Thong tin");
        students.document("SV_01").set(sinhVien);
        Log.d(TAG, "Đã gửi lệnh ghi dữ liệu!");
    }

    private void docDulieu() {
        db.collection("students")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Lỗi khi đọc dữ liệu.", task.getException());
                        }
                    }
                });
    }
}