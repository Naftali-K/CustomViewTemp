package com.nk.customviewtemp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nk.customviewtemp.models.Tag;

import java.util.ArrayList;
import java.util.List;

public class FlowListActivity extends AppCompatActivity {

    private static final String TAG = "Test_Code";

    private ConstraintLayout container;
    private Flow flowView;
    private List<Tag> tagList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_list);
        setReferences();
        createList(8);
        setFlowView();
    }

    private void setReferences() {
        container = findViewById(R.id.container);
        flowView = findViewById(R.id.flow_view);
    }

    private void createList(int listSize) {
        for (int i = 0; i < listSize; i++) {
            Tag tag = new Tag("ID-" + i, "#Tag-" + i);
            tagList.add(tag);
        }

        Log.d(TAG, "setFlowView: List: " + tagList.toString());
    }

    private void setFlowView() {
        for (Tag tag: tagList) {
            flowView.addView(createTagButton(tag));
        }
    }

    private CustomViewTags createTagButton(Tag tag) {
        CustomViewTags customViewTags = new CustomViewTags(getBaseContext());
        customViewTags.setId(View.generateViewId());
        customViewTags.setTagId(tag.getId());
        customViewTags.setTitle(tag.getTitle());

        customViewTags.onClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked OPEN ID: " + customViewTags.getTagId() + " Tag Title: " + customViewTags.getTitle());
                Toast.makeText(getBaseContext(), "ID: " + customViewTags.getTagId() + " Title: " + customViewTags.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        customViewTags.closeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked DELETE ID: " + customViewTags.getTagId() + " Tag Title: " + customViewTags.getTitle());
                Toast.makeText(getBaseContext(), "DELETE ID: " + customViewTags.getTagId() + " Title: " + customViewTags.getTitle(), Toast.LENGTH_SHORT).show();
                removeTag(customViewTags.getTagId(), customViewTags);
            }
        });

        //Container with Flow MUST!!! be ConstraintLayout. MUST!!!
        container.addView(customViewTags);

        return customViewTags;
    }

    private void removeTag(String id, CustomViewTags customViewTags) {
        for (Tag tag: tagList) {
            if (tag.equalID(id)) {
                tagList.remove(tag);

                flowView.removeView(customViewTags);
                container.removeView(customViewTags);

                return;
            }
        }
    }
}