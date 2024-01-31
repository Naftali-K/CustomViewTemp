package com.nk.customviewtemp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @Author: naftalikomarovski
 * @Date: 2024/01/30
 */
public class CustomViewTags extends LinearLayout {

    private LinearLayout container;
    private TextView textView;
    private ImageView image;
    private OnClickListener close;
    private OnClickListener click;
    private String idTag;
    private String title;

    public CustomViewTags(Context context) {
        super(context);
        init(null);
    }

    public CustomViewTags(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomViewTags(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomViewTags(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        inflate(getContext(), R.layout.custom_view_tags, this);
        setReferences();

        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CustomViewTags);
            image.setImageDrawable(array.getDrawable(R.styleable.CustomViewTags_imageRef));
            textView.setText(array.getString(R.styleable.CustomViewTags_text));

            array.recycle();
        }

        container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Clicked CONTAINER", Toast.LENGTH_SHORT).show();
                if (click != null) {
                    click.onClick(container);
                }
            }
        });
//
        image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Clicked Close tag", Toast.LENGTH_SHORT).show();
                if (close != null) {
                    close.onClick(image);
                }
            }
        });
    }

    private void setReferences() {
        container = findViewById(R.id.container);
        textView = findViewById(R.id.text);
        image = findViewById(R.id.image);
    }

    public void setTextView(String text) {
        textView.setText(text);
        this.title = text;
    }

    public void closeOnClickListener(OnClickListener onClickListener) {
        this.close = onClickListener;
    }

    public void onClick(OnClickListener onClickListener) {
        this.click = onClickListener;
    }

    public void setTagId(String id) {
        this.idTag = id;
    }

    public String getTagId() {
        return idTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        textView.setText(title);
    }
}
