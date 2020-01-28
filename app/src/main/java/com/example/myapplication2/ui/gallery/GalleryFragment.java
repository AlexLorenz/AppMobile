package com.example.myapplication2.ui.gallery;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

public class GalleryFragment extends AppCompatActivity {

//    private GalleryViewModel galleryViewModel;

    @Override
    public View onCreateView(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gallery);
    }
}
