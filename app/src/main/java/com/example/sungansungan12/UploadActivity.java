package com.example.sungansungan12;
//조정동 담당
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadActivity extends AppCompatActivity {
    ImageButton home;
    AppCompatButton uploadPOST;
    EditText productName, productDescription, productPrice, productAvailable;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        // 레이아웃에서 필요한 뷰 요소들을 찾아와 변수에 할당
        home = findViewById(R.id.homeButton);
        uploadPOST = findViewById(R.id.uplodePOSTBt);
        productName = findViewById(R.id.productName);
        productDescription = findViewById(R.id.productDescription);
        productPrice = findViewById(R.id.productPrice);
        productAvailable = findViewById(R.id.productAvailable);

        // Firebase Realtime Database의 "posts" 노드에 대한 DatabaseReference 가져오기
        databaseReference = FirebaseDatabase.getInstance().getReference("posts");

        // 홈 버튼 클릭 시 홈 화면으로 이동
        home.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        // 업로드 버튼 클릭 시 게시글 업로드 처리
        uploadPOST.setOnClickListener(v -> {
            // 사용자가 입력한 게시글 정보 가져오기
            String name = productName.getText().toString();
            String description = productDescription.getText().toString();
            String price = productPrice.getText().toString();
            String available = productAvailable.getText().toString();

            // 게시글 객체 생성
            Post post = new Post(name, description, price, available);

            // Firebase Realtime Database에 게시글 추가
            String postId = databaseReference.push().getKey();
            databaseReference.child(postId).setValue(post);

            // 홈 화면으로 이동
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
