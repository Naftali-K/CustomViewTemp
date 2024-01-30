package com.nk.customviewtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomViewTags tagCustomView;
    private Button testFlowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setReferences();

        testFlowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), FlowListActivity.class));
            }
        });

        tagCustomView.setTextView("Test set string to custom view, from MainActivity.");

        tagCustomView.onClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Clicked CONTAINER", Toast.LENGTH_SHORT).show();
            }
        });

        tagCustomView.closeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Clicked Close tag", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setReferences() {
        tagCustomView = findViewById(R.id.tag_custom_view);
        testFlowBtn = findViewById(R.id.test_flow_btn);
    }
}