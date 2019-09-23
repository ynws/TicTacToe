package com.example.tictactoe;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainFragment extends Fragment {

    private AlertDialog mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        View aboutButton = rootView.findViewById(R.id.about_button);
        aboutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.about_title);
                builder.setMessage(R.string.about_text);
                // ダイアログ外側をクリックしても消さない
                builder.setCancelable(false);
                builder.setPositiveButton(R.string.ok_label, null);
                mDialog = builder.show();
            }
        });
        return rootView;
    }

    @Override
    public void onPause(){
        super.onPause();

        // Aboutダイアログを非表示にする
        if (mDialog != null){
            mDialog.dismiss();
        }
    }
}
